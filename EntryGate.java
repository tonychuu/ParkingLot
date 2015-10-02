public class EntryGate implements Gate {
  public void allowCar() {
    //TODO open the gate
  }

  public void check(ParkingLot lot) {
    if (lot.checkAvailability()){
      allowCar();
    }
  }
}