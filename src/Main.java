import com.sun.security.jgss.GSSUtil;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String errorMessage = "Something went wrong during your input. Restart the program and try again.";
        UserInfo u1 = new UserInfo();
        ItemInfo i1 = new ItemInfo();   //pre-generated item
        ItemInfo i2 = new ItemInfo();   //user-generated item

        //  Default/test item
        i1.setItemName("Raw Shark");
        i1.setMatCost(500);
        i1.setItemExp(210);
        i1.setItemSellPrice(700);

        while (true) {
            Scanner Input = new Scanner(System.in);
            int option = 0;
            String scannerclear;

            System.out.println("1. Set user stats\n2. Choose method\n3. Calculate!\n4. Exit program");      //Menu output

            if (Input.hasNextInt()) {
                option = Input.nextInt();
                scannerclear = Input.nextLine();     //removes buffered string if there was a invalid input
                if (option < 1 || option > 4) {
                    System.out.println("Invalid input. You need to choose from one of the available options.\n");
                }
            } else {
                System.out.println("Invalid input. You need to choose from one of the available options.\n");
            }
            /*
            try {
                option = Integer.parseInt(Input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(errorMessage());
          //      throw new NumberFormatException("Input was not a number or the number was too big");  //seems to not infinite loop without this. test more.
            }
*/
            switch (option) {
                case 1 -> {
                    System.out.println("What is your username?");
                    u1.setUserName(Input.nextLine());
                    System.out.println("What is your current experience points?");
                    if (Input.hasNextInt()) {
                        u1.setCurrExp(Input.nextInt());
                    } else {
                        System.out.println("Input was not a number. Try again.");
                        scannerclear = Input.next();
                        break;
                    }
                        /*
                    try {
                        u1.setCurrExp(Input.nextInt());
                    } catch (InputMismatchException e) {
                        System.out.println(errorMessage);
                        break;
                        //Input.next();                                   //With input.next instead of the throw new below
                        //       throw new InputMismatchException();           //it still seems to work fine. The value missed will be 0 though. fixable?
                    }*/
                    System.out.println("What is your goal experience points?");

                    try {
                        u1.setGoalExp(Input.nextInt());
                    } catch (InputMismatchException e) {
                        System.out.println(errorMessage);
                        throw new InputMismatchException();
                    }
                    System.out.println("How much gold do you have?");
                    try {
                        u1.setGold(Input.nextInt());
                    } catch (InputMismatchException e) {
                        System.out.println(errorMessage);
                        throw new InputMismatchException("Input has to be a number.");
                    }
                }
                case 2 -> {
                    System.out.println("What is the name of the item that you will craft?");
                    i2.setItemName(Input.nextLine());
                    System.out.println("How much does the materials for that item cost?");
                    try {
                        i2.setMatCost(Input.nextInt());
                    } catch (InputMismatchException e) {
                        System.out.println(errorMessage);
                        throw new InputMismatchException("Input has to be a number.");
                    }
                    System.out.println("How much experience do you get for crafting that item?");
                    try {
                        i2.setItemExp(Input.nextInt());
                    } catch (InputMismatchException e) {
                        System.out.println(errorMessage);
                        throw new InputMismatchException("Input has to be a number.");
                    }
                    System.out.println("How much does the item sell for?");
                    try {
                        i2.setItemSellPrice(Input.nextInt());
                    } catch (InputMismatchException e) {
                        System.out.println(errorMessage);
                        throw new InputMismatchException("Input has to be a number.");
                    }
                }
                case 3 -> {
                    System.out.println("Starting test of case 1...");
                    System.out.println("Username: " + u1.getUserName());
                    System.out.printf("Current experience: %,d", u1.getCurrExp());
                    System.out.printf("\nExperience goal: %,d", u1.getGoalExp());
                    System.out.printf("\nGold: %,d\n", u1.getGold());
                }
                case 4 -> {
                    System.out.println("Thanks for using this program!\nExiting...");
                    System.exit(0);
                }
            }
        }
    }
}

