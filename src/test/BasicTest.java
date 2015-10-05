package test;

import static org.junit.Assert.*;
import main.EntryGate;
import main.ExitGate;
import main.ParkingLot;
import main.ParkingManagement;

import org.junit.Test;

public class BasicTest {

	/**
	 * Verifies that the stalls, entry gates, and exit gates passed down are stored properly
	 */
	@Test
	public void validValuesTest() {
		int stalls = 10;
		int entrygates = 1;
		int exitgates = 2;
		ParkingLot lot = ParkingManagement.initialize(stalls, entrygates, exitgates);
		assertEquals(stalls, lot.getStalls());
		assertEquals(entrygates, lot.getEntries());
		assertEquals(exitgates, lot.getExits());
	}
	
	/**
	 * Verifies that illegal stall value is caught properly
	 */
	@Test
	public void invalidStallsValuesTest() {
		int stalls = -10;
		int entrygates = 1;
		int exitgates = 2;
		ParkingLot lot = ParkingManagement.initialize(stalls, entrygates, exitgates);
		assertEquals(lot, null);
	}
	
	/**
	 * Verifies that illegal entry gates value is caught properly
	 */
	@Test
	public void invalidEntryValuesTest() {
		int stalls = 10;
		int entrygates = -5;
		int exitgates = 2;
		ParkingLot lot = ParkingManagement.initialize(stalls, entrygates, exitgates);
		assertEquals(lot, null);
	}
	
	/**
	 * Verifies that illegal stalls and exit gates values are caught properly
	 */
	@Test
	public void invalidExitValuesTest() {
		int stalls = -10;
		int entrygates = 1;
		int exitgates = 0;
		ParkingLot lot = ParkingManagement.initialize(stalls, entrygates, exitgates);
		assertEquals(lot, null);
	}
	
	/**
	 * Verifies that a requested gate id that does not exist is caught properly 
	 */
	@Test
	public void invalidGateTest() {
		int stalls = 10;
		int entrygates = 1;
		int exitgates = 1;
		int invalidgate = 6;
		ParkingLot lot = ParkingManagement.initialize(stalls, entrygates, exitgates);
		assertEquals(lot.getEntryGate(invalidgate), null);
		assertEquals(lot.getExitGate(invalidgate), null);
	}
	
	/**
	 * Verifies that cars can be added to the parking lot and 
	 * verifies only the cars that have stalls available can enter the parking lot
	 */
	@Test
	public void addCarTest() {
		int stalls = 10;
		int entrygates = 1;
		int exitgates = 1;
		ParkingLot lot = ParkingManagement.initialize(stalls, entrygates, exitgates);
		EntryGate gate = lot.getEntryGate(1);
		for (int i = 0; i < 13; i++) {
		  if (i < 10) {
		    assertTrue(gate.check(lot));
		  }
		  else {
		    assertFalse(gate.check(lot));
		  }
		}
	}
	
	/**
	 * Verifies that there can never be less than 0 cars in the parking lot,
	 * verifies that only the cars that have parking stalls can go inside the parking lot
	 */
	@Test
	public void addRemoveCarTest() {
		int stalls = 10;
		int entrygates = 1;
		int exitgates = 1;
		int nocars = 0;
		ParkingLot lot = ParkingManagement.initialize(stalls, entrygates, exitgates);
		EntryGate entrygate = lot.getEntryGate(1);
		ExitGate exitgate = lot.getExitGate(1);
		for (int i = 0; i < 21; i++) {
		  if (i < 2) {
		    lot.addAvailability();
		    assertEquals(lot.getCurrentCars(), nocars);
		  }else if (i < 12) {
		    assertTrue(entrygate.check(lot));
		    System.out.println("There are " + lot.getCurrentCars() + " cars in the parking lot now.");
		  }else if (i == 12) {
			assertFalse(entrygate.check(lot));
			System.out.println("There are " + lot.getCurrentCars() + " cars in the parking lot now.");
		  }else if (i > 12 && i < 17) {
			assertTrue(exitgate.check(lot));
			System.out.println("There are " + lot.getCurrentCars() + " cars in the parking lot now.");
		  } else {
			assertTrue(entrygate.check(lot));
			System.out.println("There are " + lot.getCurrentCars() + " cars in the parking lot now.");
		  }
		}
	}
	
	/**
	 * Verifies that multiple gates in a parking lot works properly
	 */
	@Test
	public void multiplegatesTest() {
		System.out.println("Multiple Gates Test");
		int stalls = 10;
		int entrygates = 2;
		int exitgates = 2;
		int nocars = 0;
		ParkingLot lot = ParkingManagement.initialize(stalls, entrygates, exitgates);
		for (int i = 0; i < 21; i++) {
		  if (i < 2) {
		    getExitGate(lot,i).check(lot);
		    assertEquals(lot.getCurrentCars(), nocars);
		  }else if (i < 12) {
		    assertTrue(getEntryGate(lot, i).check(lot));
		    System.out.println("There are " + lot.getCurrentCars() + " cars in the parking lot now.");
		  }else if (i == 12) {
			assertFalse(getEntryGate(lot, i).check(lot));
			System.out.println("There are " + lot.getCurrentCars() + " cars in the parking lot now.");
		  }else if (i > 12 && i < 17) {
			assertTrue(getExitGate(lot, i).check(lot));
			System.out.println("There are " + lot.getCurrentCars() + " cars in the parking lot now.");
		  } else {
			assertTrue(getEntryGate(lot, i).check(lot));
			System.out.println("There are " + lot.getCurrentCars() + " cars in the parking lot now.");
		  }
		}
	}
	
	/**
	 *Returns an even or odd gate ID entry gate given an integer
	 * 
	 *@param lot: The parking lot associated with the gate
	 *@param counter: The integer that decides the even or odd gate 
	 *@return
	 */
	public EntryGate getEntryGate(ParkingLot lot, int counter) {
		int result = (counter % 2) + 1;
		return lot.getEntryGate(result);
	}
	
	/**
	 *Returns an even or odd gate ID exit gate given an integer
	 * 
	 *@param lot: The parking lot associated with the gate
	 *@param counter: The integer that decides the even or odd gate 
	 *@return
	 */
	public ExitGate getExitGate(ParkingLot lot, int counter) {
		int result = (counter % 2) + 1;
		return lot.getExitGate(result);
	}
}
