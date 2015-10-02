package test;

import static org.junit.Assert.*;
import main.EntryGate;
import main.ExitGate;
import main.ParkingLot;
import main.ParkingManagement;

import org.junit.Test;

public class BasicTest {

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
	
	@Test
	public void invalidStallsValuesTest() {
		int stalls = -10;
		int entrygates = 1;
		int exitgates = 2;
		ParkingLot lot = ParkingManagement.initialize(stalls, entrygates, exitgates);
		assertEquals(lot, null);
	}
	
	@Test
	public void invalidEntryValuesTest() {
		int stalls = 10;
		int entrygates = -5;
		int exitgates = 2;
		ParkingLot lot = ParkingManagement.initialize(stalls, entrygates, exitgates);
		assertEquals(lot, null);
	}
	
	@Test
	public void invalidExitValuesTest() {
		int stalls = -10;
		int entrygates = 1;
		int exitgates = 0;
		ParkingLot lot = ParkingManagement.initialize(stalls, entrygates, exitgates);
		assertEquals(lot, null);
	}
	
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
	
	@Test
	public void addRemoveCarTest() {
		int stalls = 10;
		int entrygates = 1;
		int exitgates = 1;
		ParkingLot lot = ParkingManagement.initialize(stalls, entrygates, exitgates);
		EntryGate entrygate = lot.getEntryGate(1);
		ExitGate exitgate = lot.getExitGate(1);
		for (int i = 0; i < 20; i++) {
		  if (i < 10) {
		    assertTrue(entrygate.check(lot));
		    System.out.println(lot.getCurrentCars());
		  }
		  else {
		    assertTrue(exitgate.check(lot));
		    System.out.println(lot.getCurrentCars());
		  }
		}
	}
}
