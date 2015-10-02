public class ExitGate implements Gate {
  public void allowCar() {
    //TODO open the gate
  }

  public void check(ParkingLot lot) {
    lot.addAvailability();
    allowCar();
  }
}