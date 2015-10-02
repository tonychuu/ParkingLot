package main;

public interface Gate {
	
	  public void allowCar();

	  public boolean check(ParkingLot lot);
	  
	  public int getId();
	}