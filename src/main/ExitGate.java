package main;

public class ExitGate implements Gate {
	
  private final int GATEID;
  
  public ExitGate(int gateid) {
    GATEID = gateid;
  }
	  
  /**
   *Opens the gate.
   *
   *@param none
   *@return none
   */
  public void openGate() {
	try {
      System.out.println("Exit gate " + GATEID + " has been lifted.");
      Thread.sleep(10);
	}catch (InterruptedException e) {
		System.err.println("Thread interrupted");
	}
  }

  /**
   *Tells the parking lot to add a stall being used back to being an available stall.
   *
   *@param none
   *@return a boolean value, a true value reflecting that a car has left the parking lot
   */
  public boolean check(ParkingLot lot) {
    lot.addAvailability();
    openGate();
    return true;
  }
	    
  /**
   *Returns the gate's ID number.
   *
   *@param none
   *@return the gate's ID number
   */
  public int getId() {
    return GATEID;
  }
}