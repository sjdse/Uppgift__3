import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String errorMessage = "Input was not a number or the number is outside the allowed range. Try again.";
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
            //String scannerclear;            //used to remove buffered string in scanner if there was an invalid input - variable not needed(?)

            System.out.println("\n1. Set user stats\n2. Choose method\n3. Show inputs & start calculation\n4. Exit program");      //Menu output

            if (Input.hasNextInt()) {
                option = Input.nextInt();
                Input.nextLine();     //removes buffered string if there was a invalid input
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
                        System.out.println(errorMessage);
                        Input.next();
                        break;                                                  //leaves switch if invalid input
                    }

                    System.out.println("What is your goal experience points?");
                    if (Input.hasNextInt())
                        u1.setGoalExp(Input.nextInt());
                    else {
                        System.out.println(errorMessage);
                        Input.next();
                        break;
                    }

                    System.out.println("How much gold do you have?");
                    if (Input.hasNextInt())
                        u1.setGold(Input.nextInt());
                    else {
                        System.out.println(errorMessage);
                        Input.next();
                    }
                }
                case 2 -> {
                    System.out.println("What is the name of the item that you will craft?");
                    i2.setItemName(Input.nextLine());
                    System.out.println("How much does the materials for that item cost?");

                    if (Input.hasNextInt())
                        i2.setMatCost(Input.nextInt());
                    else {
                        System.out.println(errorMessage);
                        Input.next();
                        break;
                    }

                    System.out.println("How much experience do you get for crafting that item?");

                    if (Input.hasNextInt())
                        i2.setItemExp(Input.nextInt());
                    else {
                        System.out.println(errorMessage);
                        Input.next();
                        break;
                    }
                    System.out.println("How much does the item sell for?");

                    if (Input.hasNextInt())
                        i2.setItemSellPrice(Input.nextInt());
                    else {
                        System.out.println(errorMessage);
                        Input.next();
                    }
                }
                case 3 -> {
                    if (u1.getGold() >= 0) {
                        System.out.println("*** User Info ***");
                        System.out.println("Username: " + u1.getUserName());
                        System.out.printf("Current experience: %,d", u1.getCurrExp());
                        System.out.printf("\nExperience goal: %,d", u1.getGoalExp());
                        System.out.printf("\nGold: %,d\n", u1.getGold());
                    }
                    if (i2.getItemName() != null && i2.getItemSellPrice() >= 0) { //Only runs if
                        System.out.println("---------------------------------------------------");
                        System.out.println("*** Item Info ***");
                        System.out.println("Item name: " + i2.getItemName());
                        System.out.printf("Material cost: %,d", i2.getMatCost());
                        System.out.printf("\nExperience for crafting: %,d", i2.getItemExp());
                        System.out.printf("\nItem sell price: %,d\n", i2.getItemSellPrice());
                        System.out.println("---------------------------------------------------");
                        /*
                        Probably make these below into variables?
                        100% unreadable
                         */
                        System.out.println("Exp to goal: " + (u1.getGoalExp()-u1.getCurrExp()));
                        System.out.println("Crafts to goal: %.0f" + (Math.ceil((double)(u1.getGoalExp()-u1.getCurrExp()) / i2.getItemExp()))); //# of crafts to goal, casted to double and rounded up to make sure the goal is met
                        System.out.printf("\nTotal cost: %.0f", (Math.ceil((double)(u1.getGoalExp()-u1.getCurrExp()) / i2.getItemExp())*(i2.getItemSellPrice()-i2.getMatCost())));
                        System.out.println("\nGold after: " + (u1.getGold()-(Math.ceil((double)(u1.getGoalExp()-u1.getCurrExp()) / i2.getItemExp())*(i2.getItemSellPrice()-i2.getMatCost()))));
                    } else {        //Only shows up if user didn't make any input or made a mistake in case 2.
                        System.out.println("*** Base item info ***");
                        System.out.println(i1.getItemName());
                        System.out.printf("Material cost: %,d", i1.getMatCost());
                        System.out.printf("\nExperience for crafting: %,d", i1.getItemExp());
                        System.out.printf("\nItem sell price: %,d\n", i1.getItemSellPrice());
                        System.out.println("---------------------------------------------------");
                        System.out.println("Exp to goal: ");
                        System.out.println("Crafts to goal: ");
                        System.out.println("Total cost/profit: ");
                        System.out.println("Gold after: ");
                    }

                    System.out.println();
                }
                case 4 -> {
                    System.out.println("Thanks for using this program!\nExiting...");
                    System.exit(0);
                }
            }
        }
    }
}

