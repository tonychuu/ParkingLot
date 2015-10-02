import java.util.Scanner;

public class ParkingManagement {
  static Scanner userInput = new Scanner(System.in);
  public static void main(String[] args) {
    String welcomemsg = "Parking Lot Management System.";
    String notnumbererror = "Sorry, your input is not a number. Please try again.";
    String negativeerror = "Sorry, your input is a negative number. Please try again.";
    String zeroerror = "Sorry, you must enter a number greater than 0. Please try again.";
    String enterkeyerror = "Sorry, please enter a valid number before hitting the Enter key.";
    String stallquestion = "How many stalls does the parking lot have?\nInput: ";
    String entriesquestion = "How many entry gates does the parking lot have?\nInput: ";
    String exitsquestion = "How many exit gates does the parking lot have?\nInput: ";
    int stalls = 0;
    int entries = 0;
    int exits = 0;
    
    System.out.println(welcomemsg);
    do {
      try {
        

        if (stalls <= 0) {
          System.out.print(stallquestion);
          if (!userInput.hasNextInt()) {
            System.out.println(enterkeyerror + '\n');
            continue;
          }
          stalls = userInput.nextInt();
          if (stalls < 0) {
            System.err.println(negativeerror + '\n');
            continue;
          } else if (stalls == 0) {
            System.err.println(zeroerror + '\n');
            continue;
          }
        }
        if (entries <= 0) {
          System.out.print(entriesquestion);
          if (userInput.hasNextLine()) {
            System.out.println(enterkeyerror + '\n');
            continue;
          }
          entries = userInput.nextInt();
          if (entries < 0) {
            System.err.println(negativeerror + '\n');
            continue;
          } else if (entries == 0) {
            System.err.println(zeroerror + '\n');
            continue;
          }
        }
        if (exits <= 0) {
          System.out.print(exitsquestion);
          if (userInput.hasNextLine()) {
            System.out.println(enterkeyerror + '\n');
            continue;
          }
          exits = userInput.nextInt();
          if (exits < 0) {
            System.err.println(negativeerror + '\n');
            continue;
          } else if (exits == 0) {
            System.err.println(zeroerror + '\n');
            continue;
          }
        }
        break;
      } catch (Exception e) {
        System.err.println(notnumbererror + '\n');
      }
    } while(true);
    ParkingLot lot = new ParkingLot(stalls, entries, exits);

    start(lot);
  }

  public static void start(ParkingLot lot) { //TODO finish
    String menumsg =  " 1. Add a car to parking lot\n2. Remove a car from parking lot\n3. Total number of cars in parking lot\n-1. Exit management system\nInput: ";
    String commanderror = "Sorry, please enter a valid command.";
    String gatenummsg = "Which gate is the car at? ";
    while(true) {
      System.out.print(menumsg + '\n');
      int input = 0;

      if (userInput.hasNextInt()) {
        input = userInput.nextInt();
      } else {
        System.err.println(commanderror);
      }
      switch(input) {
        case 1: System.out.println(gatenummsg);
                input = userInput.nextInt();
                addCar(lot, input);
        case 2:
        case 3:
        case -1:
        default: System.err.println(commanderror);
      }

    }
  }

  /**Asks the gate to add the vehicle into the parking lot.
    *It is up to the gate to check whether the parking lot is full or not.
    *
    *@param lot: the parking lot this system is monitoring
    *@param gateid: the ID of the gate this car is waiting on
    *@return none
    */
  public static void addCar(ParkingLot lot, int gateid) {
    EntryGate gate = lot.getEntryGate(gateid);
    gate.check(lot);
  }

  /**Asks the gate to remove the vehicle from the parking lot.
    *It is up to the gate to free the stalls available flag
    *
    *@param lot: the parking lot this system is monitoring
    *@param gateid: the ID of the gate this car is waiting on
    *@return none
    */
  public static void removeCar(ParkingLot lot, int gateid) {
    ExitGate gate = lot.getExitGate(gateid);
    gate.check(lot);
  }

}