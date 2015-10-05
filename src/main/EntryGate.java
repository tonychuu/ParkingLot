package main;

public class EntryGate implements Gate {
	
  public final int GATEID;
	  
  public EntryGate(int gateid) {
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
    System.out.println("Entry gate " + GATEID + " has been lifted.");
    Thread.sleep(10);
	}catch (InterruptedException e) {
		System.err.println("Thread interrupted");
	}
  }

  /**
   *Checks the parking lot for a available stall and returns the result.
   *If there is a stall available, it also opens the gate to allow the car in
   *
   *@param none
   *@return A boolean, true if there is a free stall, false if not
   */
  public boolean check(ParkingLot lot) {
    if (lot.removeAvailability()){
      openGate();
      return true;
    } else {
        return false;
    }
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