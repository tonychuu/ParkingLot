package main;

public class ExitGate implements Gate {
	
	  private final int GATEID;
	  
	  public ExitGate(int gateid) {
		  GATEID = gateid;
	  }
	  
	  public void allowCar() {
	    //TODO open the gate
	  }

	  public boolean check(ParkingLot lot) {
	    lot.addAvailability();
	    allowCar();
	    return true;
	  }
	  
	  public int getId() {
		  return GATEID;
	  }
	}