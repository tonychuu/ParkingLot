package main;

public interface Gate {
	
  /**
   *Opens the gate.
   *
   *@param none
   *@return none
   */
  public void openGate();

  /**
   *Checks the parking lot for some information.
   *
   *@param none
   *@return a boolean value
   */
  public boolean check(ParkingLot lot);
	  
  /**
   *Returns the gate's ID number.
   *
   *@param none
   *@return the gate's ID number
   */
  public int getId();
}