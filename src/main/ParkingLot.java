package main;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ParkingLot {
    private final int STALLS;
    private final int ENTRIES;
    private final int EXITS;
    private HashMap<Integer, EntryGate> entrygates = new HashMap<Integer, EntryGate>();
    private HashMap<Integer, ExitGate> exitgates = new HashMap<Integer, ExitGate>();
    private AtomicInteger currentcars = new AtomicInteger(0);

    /**
     *Constructor
     *
     *@param stalls: the number of usable parking stalls
     *@param entries: the number of entry gates
     *@param exits: the number of exit gates
     *@return none
     */
    protected ParkingLot(int stalls, int entries, int exits) {
      STALLS = stalls;
      ENTRIES = entries;
      EXITS = exits;

      for(int i = 0; i < ENTRIES; i++) {
        int gateid = i + 1;
        entrygates.put(gateid, new EntryGate(gateid));
      }
      for(int i = 0; i < EXITS; i++) {
        int gateid = i + 1;
        exitgates.put(gateid, new ExitGate(gateid));
      }
    }

    /**
     *Adds a car to the parking lot.
     *Increases the count for current cars inside the parking lot by one.
     *
     *@param none
     *@return none
     */
    private void addCarToLot() {
      currentcars.incrementAndGet();
    }

    /**
     *Removes a car from the parking lot.
     *Decreases the count for current cars inside the parking lot by one.
     *
     *@param none
     *@return none
     */
    private void removeCarFromLot() {
      currentcars.decrementAndGet();
    }

    /**
     *Called by EntryGate and checks if a free stall is available for the car to park.
     *Called when a car reaches an entry gate, before it enters the parking lot.
     *
     *@param none
     *@return a boolean value, true if there is a parking stall available, false if not
     */
    public synchronized boolean removeAvailability() {
      if (currentcars.get() < STALLS) {
        addCarToLot();
        return true;
      }else {
        return false;
      }
    }

    /**
     *Called by ExitGate and adds a stall back to the total number of free parking stalls available.
     *Called when a car leaves the parking lot.
     *Thread-safe method.
     *
     *@param none
     *@return none
     */
    public synchronized void addAvailability() {
      if (currentcars.get() == 0) {
        System.err.println("There are no more cars in the parking lot!");
      }else {
        removeCarFromLot();
      }
    }

    /**
     *Returns the total count for current cars inside the parking lot.
     *
     *@param none
     *@return the current cars in this parking lot
     */
    public int getCurrentCars() {
      return currentcars.get();
    }

    /**
     *Returns the total count for stalls inside the parking lot.
     *
     *@param none
     *@return the number of stalls in this parking lot
     */
    public int getStalls() {
      return STALLS;
    }
    
    /**
     *Returns the count for entry gates for this parking lot.
     *
     *@param none
     *@return the number of entry gates for this parking lot
     */
    public int getEntries() {
      return ENTRIES;
    }

    /**
     *Returns the count for exit gates for this parking lot.
     *
     *@param none
     *@return the number of exit gates for this parking lot
     */
    public int getExits() {
      return EXITS;
    }

    /**
     *Returns the requested entry gate object.
     *
     *@param gateid: the ID number for the requested gate
     *@return the number of entry gates for this parking lot
     */
    public EntryGate getEntryGate(int gateid) {
      if (gateid <= entrygates.size() && gateid > 0) {
        return entrygates.get(gateid);
      } else {
          return null;
      }
    }

    /**
     *Returns the requested exit gate object.
     *
     *@param gateid: the ID number for the requested gate
     *@return the number of exit gates for this parking lot
     */
    public ExitGate getExitGate(int gateid) {
      if (gateid <= exitgates.size() && gateid > 0) {
        return exitgates.get(gateid);
      } else {
          return null;
      }
    }
}