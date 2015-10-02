package main;

public class EntryGate implements Gate {
	
	public final int GATEID;
	  
	  public EntryGate(int gateid) {
		  GATEID = gateid;
	  }
	
	  public void allowCar() {
	    //TODO open the gate
	  }

	  public boolean check(ParkingLot lot) {
	    if (lot.checkAvailability()){
	      allowCar();
	      return true;
	    }
	    return false;
	  }
	  
	  public int getId() {
		  return GATEID;
	  }
	}