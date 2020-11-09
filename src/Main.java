import java.util.Scanner;

public class Main {
    /**
     * This method is a menu and takes inputs from the user and uses instance variables to store the inputs.
     * It will then print things based on what the user has written.
     * @param args
     */
    public static void main(String[] args) {

        String errorMessage = "Input was not a number or the number is outside the allowed range. Try again.";
        UserInfo u1 = new UserInfo();
        ItemInfo i1 = new ItemInfo();
        boolean case3Blocker = false; // blocks access to case 3 in the switch until case 1 & 2 are correctly done

        while (true) {
            Scanner Input = new Scanner(System.in);
            int option = 0;

            System.out.println("\n1. Set user stats" +          //menu
                    "\n2. Choose method" +
                    "\n3. Show inputs & start calculation" +
                    "\n4. Exit program");

            if (Input.hasNextInt()) {                           //menu input
                option = Input.nextInt();
                Input.nextLine();     //removes buffered string if there was a invalid input
                if (option < 1 || option > 4) {
                    System.out.println("Invalid input. You need to choose from one of the available options.\n");
                }
            } else {
                System.out.println("Invalid input. You need to choose from one of the available options.\n");
            }

            switch (option) {
                case 1 -> {
                    System.out.println("What is your username?");
                    u1.setUserName(Input.nextLine());

                    System.out.println("What is your current experience points?");
                    if (Input.hasNextInt()) {
                        u1.setCurrExp(Input.nextInt());
                        case3Blocker = true;
                    } else {
                        System.out.println(errorMessage);
                        Input.next();
                        case3Blocker = false;
                        break;                                                  //leaves switch if invalid input
                    }

                    System.out.println("What is your goal experience points?");
                    if (Input.hasNextInt()) {
                        u1.setGoalExp(Input.nextInt());
                        if (u1.getGoalExp() <= u1.getCurrExp()) {       //exits switch if goalExp is too low
                            case3Blocker = false;
                            break;
                        }
                    } else {
                        System.out.println(errorMessage);
                        Input.next();
                        case3Blocker = false;
                        break;
                    }

                    System.out.println("How much gold do you have?");
                    if (Input.hasNextInt()) {
                        u1.setGold(Input.nextInt());
                    } else {
                        System.out.println(errorMessage);
                        Input.next();
                        case3Blocker = false;
                    }
                }
                case 2 -> {
                    System.out.println("What is the name of the item that you will craft?");
                    i1.setItemName(Input.nextLine());

                    System.out.println("How much does the materials for that item cost?");
                    if (Input.hasNextInt()) {
                        i1.setMatCost(Input.nextInt());
                        case3Blocker = true;
                    } else {
                        System.out.println(errorMessage);
                        Input.next();
                        case3Blocker = false;
                        break;
                    }

                    System.out.println("How much experience do you get for crafting that item?");
                    if (Input.hasNextInt()) {
                        i1.setItemExp(Input.nextInt());
                    } else {
                        System.out.println(errorMessage);
                        Input.next();
                        case3Blocker = false;
                        break;
                    }

                    System.out.println("How much does the item sell for?");
                    if (Input.hasNextInt()) {
                        i1.setItemSellPrice(Input.nextInt());
                    } else {
                        System.out.println(errorMessage);
                        Input.next();
                        case3Blocker = false;
                    }
                }
                case 3 -> {
                    if (case3Blocker) {   //only runs if the user has gone through entire case 1 & 2 correctly
                        System.out.println(u1.toString() + i1.toString());

                        System.out.printf("Exp to goal: %,d" +
                                        "\nCrafts to goal: %,.0f" +
                                        "\nTotal cost: %,.0f\t (Positive = profit | Negative = loss)"
                                , u1.expToGoal()
                                , i1.craftsToGoal(u1.expToGoal())
                                , i1.totalCost(i1.craftsToGoal(u1.expToGoal())));

                        if (u1.goldLeft(i1.totalCost(i1.craftsToGoal(u1.expToGoal()))) >= 0)        //show how much gold you have if you could afford your goal
                            System.out.printf("\nYou will have %,.0f gold after completing your goal.\n"
                                    , u1.goldLeft(i1.totalCost(i1.craftsToGoal(u1.expToGoal()))));
                        else if (u1.goldLeft(i1.totalCost(i1.craftsToGoal(u1.expToGoal()))) < 0)    //show how much gold you need to afford your goal
                            System.out.printf("\nYou need %,.0f gold to complete your goal.\n"
                                    , Math.abs(u1.goldLeft(i1.totalCost(i1.craftsToGoal(u1.expToGoal())))));

                    } else {     //output if case 1&2 is not completed
                        System.out.println("You have to go through both option 1 and 2 before proceeding to option 3.");
                    }
                }
                case 4 -> {
                    System.out.println("Thanks for using this program!\nExiting...");
                    System.exit(0);
                }
            }
        }
    }
}

