package main;

import java.util.Scanner;

public class ParkingManagement {
  static Scanner userInput = new Scanner(System.in);
  
  public static void main(String[] args) {
    ParkingLot lot = initialize();
    String welcomemsg = "Welcome to Parking Lot Management System";
    System.out.println(welcomemsg);
    start(lot);
  }

  /**
   *Initializes a parking lot, with required information passed as parameters.
   *
   *@param stalls: the number of usable parking stalls
   *@param entries: the number of entry gates
   *@param exits: the number of exit gates
   *@return A parking lot object
   */
  public static ParkingLot initialize(int stalls, int entries, int exits) {
    String notnumbererror = "Sorry, your input is not a number. Please try again.";
    String negativeerror = "Sorry, your input is a negative number. Please try again.";
    String zeroerror = "Sorry, you must enter a number greater than 0. Please try again.";
    try {
      if (stalls <= 0) {
        if (stalls < 0) {
          System.err.println(negativeerror + '\n');
          return null;
        } else if (stalls == 0) {
            System.err.println(zeroerror + '\n');
            return null;
	    }
      }
      if (entries <= 0) {
        if (entries < 0) {
          System.err.println(negativeerror + '\n');
          return null;
        } else if (entries == 0) {
            System.err.println(zeroerror + '\n');
            return null;
        }
      }
      if (exits <= 0) {        
        if (exits < 0) {
        	System.err.println(negativeerror + '\n');
        	return null;
        } else if (exits == 0) {
        	System.err.println(zeroerror + '\n');
        	return null;
        }
      }
    } catch (Exception e) {
      System.err.println(notnumbererror + '\n');
      return null;
    }
    ParkingLot lot = new ParkingLot(stalls, entries, exits);
    return lot;
  }
  
  /**
   *Initializes a parking lot, with required information asked via console.
   *
   *@param none
   *@return A parking lot object
   */
  public synchronized static ParkingLot initialize() {
    String notnumbererror = "Sorry, your input is not a number. Please try again.";
    String negativeerror = "Sorry, your input is a negative number. Please try again.";
    String zeroerror = "Sorry, you must enter a number greater than 0. Please try again.";
    String stallquestion = "How many stalls does the parking lot have?\nInput: ";
    String entriesquestion = "How many entry gates does the parking lot have?\nInput: ";
    String exitsquestion = "How many exit gates does the parking lot have?\nInput: ";
    int stalls = 0;
    int entries = 0;
    int exits = 0;

    do {
      try {
        if (stalls <= 0) {
          System.out.print(stallquestion);
          if (userInput.hasNextInt()) {
            stalls = userInput.nextInt();
          }else {
        	System.err.println(notnumbererror);
            userInput.next();
            Thread.sleep(100);
            continue;
          }
          if (stalls < 0) {
            System.err.println(negativeerror + '\n');
            Thread.sleep(100);
            continue;
          } else if (stalls == 0) {
            System.err.println(zeroerror + '\n');
            Thread.sleep(100);
            continue;
          }
        }
        if (entries <= 0) {
          System.out.print(entriesquestion);
          if (userInput.hasNextInt()) {
            entries = userInput.nextInt();
          }else {
        	System.err.println(notnumbererror);
            userInput.next();
            Thread.sleep(100);
            continue;
          }
          if (entries < 0) {
            System.err.println(negativeerror + '\n');
            Thread.sleep(100);
            continue;
          } else if (entries == 0) {
              System.err.println(zeroerror + '\n');
              Thread.sleep(100);
              continue;
          }
        }
        if (exits <= 0) {
          System.out.print(exitsquestion);
          if (userInput.hasNextInt()) {
            exits = userInput.nextInt();
          }else {
            System.err.println(notnumbererror);
            userInput.next();
            Thread.sleep(100);
            continue;
          }
          if (exits < 0) {
            System.err.println(negativeerror + '\n');
            Thread.sleep(100);
            continue;
          } else if (exits == 0) {
              System.err.println(zeroerror + '\n');
              Thread.sleep(100);
              continue;
          }
        }
        break;
      } catch (Exception e) {
          System.err.println(notnumbererror + '\n');
      }
    } while(true);
    ParkingLot lot = new ParkingLot(stalls, entries, exits);
    return lot;
  }
  
  /**
   *Starts the management system with a console-based user interface.
   *
   *@param lot: the parking lot this system is monitoring
   *@return none
   */
  public static synchronized void start(ParkingLot lot) {
    String menumsg =  "Please choose from the following options:\n 1. Add a car to parking lot\n 2. Remove a car from parking lot\n 3. Total number of cars in parking lot\n-1. Exit management system\nInput: ";
    String commanderror = "Sorry, please enter a valid command.";
    String gatenummsg = "Which gate is the car at? ";
    while(true) {
      try {
        System.out.print(menumsg);
        int input = 0;

        if (userInput.hasNextInt()) {
          input = userInput.nextInt();
        }else {
          userInput.next();
        }
        switch(input) {
          case 1: 
            System.out.print(gatenummsg);
            if (userInput.hasNextInt()) {
              input = userInput.nextInt();
              addCar(lot, input);
            }else {
              System.err.println(commanderror);
        	  userInput.next();
        	  Thread.sleep(100);
            }
            break;
          case 2: 
            System.out.print(gatenummsg);
            if (userInput.hasNextInt()) {
              input = userInput.nextInt();
              removeCar(lot, input);
            }else {
              System.err.println(commanderror);
              userInput.next();
              Thread.sleep(100);
            }
            break;
          case 3: 
            System.out.println("There is/are " + lot.getCurrentCars() + " car(s) in the parking lot\n");
            break;
          case -1: 
            System.exit(0);
            break;
          default:
            System.err.println(commanderror);
            Thread.sleep(100);
        }
      }catch (Exception e) {
    	  System.err.println("Thread was interrupted");
    	  e.printStackTrace();
      }
    }
  }

  /**
   *Asks the gate to add the vehicle into the parking lot.
   *It is up to the gate to check whether the parking lot is full or not.
   *
   *@param lot: the parking lot this system is monitoring
   *@param gateid: the ID of the gate this car is waiting on
   *@return none
   */
  public static synchronized void addCar(ParkingLot lot, int gateid) {
    EntryGate gate = lot.getEntryGate(gateid);
    if (gate == null) {
      System.err.println("Sorry, no such gate exists. Try another gate.\n");
    } else {
        boolean result = gate.check(lot);
        if (result) {
          System.out.println("Car has entered the parking lot\n");
        } else {
            System.err.println("Sorry, the parking lot is full");
        }
    }
  }

  /**
   *Asks the gate to remove the vehicle from the parking lot.
   *It is up to the gate to free the stalls available flag
   *
   *@param lot: the parking lot this system is monitoring
   *@param gateid: the ID of the gate this car is waiting on
   *@return none
   */
  public static void removeCar(ParkingLot lot, int gateid) {
    ExitGate gate = lot.getExitGate(gateid);
    if (gate == null) {
      System.err.println("Sorry, no such gate exists. Try another gate.\n");
    } else {
        if (gate.check(lot)) {
        	System.out.println("A car has left the parking lot.\n");
        }
    }
  }

}