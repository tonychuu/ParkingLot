import java.util.ArrayList;

public class ParkingLot {
    private final int STALLS;
    private final int ENTRIES;
    private final int EXITS;
    private ArrayList<EntryGate> entrygates = new ArrayList<EntryGate>();
    private ArrayList<ExitGate> exitgates = new ArrayList<ExitGate>();
    private boolean stallavailableflag = true;
    private int currentcars;

    private static ParkingLot lot = null;

    protected ParkingLot(int stalls, int entries, int exits) {
      STALLS = stalls;
      ENTRIES = entries;
      EXITS = exits;

      for(int i = 0; i < ENTRIES; i++) {
        entrygates.add(new EntryGate());
      }
      for(int i = 0; i < EXITS; i++) {
        exitgates.add(new ExitGate());
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
      if (currentcars <= STALLS) {
        if (currentcars == STALLS) {
          stallavailableflag = false;
        }
        addCarToLot();
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