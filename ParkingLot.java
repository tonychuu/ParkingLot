public class ParkingLot {
    private final int STALLS;
    private boolean stallsset;
    private final int ENTRIES;
    private boolean entriesset;
    private final int EXITS;
    private boolean exitsset;
    private int currentcars;

    private static ParkingLot lot = null;

    protected ParkingLot(int stalls, int entries, int exits) {
      STALLS = stalls;
      ENTRIES = entries;
      EXITS = exits;
    }

    public void addCar() {
      currentcars++;
    }

    public void removeCar() {
      currentcars--;
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
}