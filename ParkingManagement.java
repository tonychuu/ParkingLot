import java.util.Scanner;

public class ParkingManagement {
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
        Scanner userInput = new Scanner(System.in);

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
  }
}