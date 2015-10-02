package main;

import java.util.HashMap;

public class ParkingLot {
    private final int STALLS;
    private final int ENTRIES;
    private final int EXITS;
    private HashMap<Integer, EntryGate> entrygates = new HashMap<Integer, EntryGate>();
    private HashMap<Integer, ExitGate> exitgates = new HashMap<Integer, ExitGate>();
    private boolean stallavailableflag = true;
    private int currentcars;

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

    private void addCarToLot() {
      currentcars++;
    }

    private void removeCarFromLot() {
      currentcars--;
    }

    /**Checks if a free stall is available for the car to park
      *Called when a car reaches an entry gate, before it enters the parking lot
      *
      *@param none
      *@return none
      */
    public boolean checkAvailability() {
      if (stallavailableflag) {
        addCarToLot();
        if (currentcars == STALLS) {
          stallavailableflag = false;
        }
        return true;
      }
      return false;
    }

    /**Adds a stall back to the total number of free parking stalls available
      *Called when a car leaves the parking lot
      *
      *@param none
      *@return none
      */
    public void addAvailability() {
      removeCarFromLot();
      if (currentcars < STALLS) {
        stallavailableflag = true;
      }
    }

    public int getCurrentCars() {
      return currentcars;
    }

    public int getStalls() {
      return STALLS;
    }

    public int getEntries() {
      return ENTRIES;
    }

    public int getExits() {
      return EXITS;
    }

    public EntryGate getEntryGate(int gateid) {
      return entrygates.get(gateid);
    }

    public ExitGate getExitGate(int gateid) {
      return exitgates.get(gateid);
    }
}