import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String errorMessage = "Input was not a number or the number is outside the allowed range. Try again.";
        UserInfo u1 = new UserInfo();
        ItemInfo i1 = new ItemInfo();

        while (true) {
            Scanner Input = new Scanner(System.in);
            int option = 0;

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
                    if (Input.hasNextInt()) {
                        u1.setGoalExp(Input.nextInt());
                        if (u1.getGoalExp() <= u1.getCurrExp()) {
                            break;
                        }
                    } else {
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
                    i1.setItemName(Input.nextLine());

                    System.out.println("How much does the materials for that item cost?");
                    if (Input.hasNextInt())
                        i1.setMatCost(Input.nextInt());
                    else {
                        System.out.println(errorMessage);
                        Input.next();
                        break;
                    }

                    System.out.println("How much experience do you get for crafting that item?");
                    if (Input.hasNextInt())
                        i1.setItemExp(Input.nextInt());
                    else {
                        System.out.println(errorMessage);
                        Input.next();
                        break;
                    }

                    System.out.println("How much does the item sell for?");
                    if (Input.hasNextInt())
                        i1.setItemSellPrice(Input.nextInt());
                    else {
                        System.out.println(errorMessage);
                        Input.next();
                    }
                }
                case 3 -> {
                    if (u1.getGold() >= 0 && i1.getItemSellPrice() >= 0) {   //only runs if the user has gone through case 1 & 2
                        System.out.println("*** User Info ***");
                        System.out.println("Username: " + u1.getUserName());
                        System.out.printf("Current experience: %,d", u1.getCurrExp());
                        System.out.printf("\nExperience goal: %,d", u1.getGoalExp());
                        System.out.printf("\nGold: %,d\n", u1.getGold());
                        System.out.println("---------------------------------------------------");
                        System.out.println("*** Item Info ***");
                        System.out.println("Item name: " + i1.getItemName());
                        System.out.printf("Material cost: %,d", i1.getMatCost());
                        System.out.printf("\nExperience for crafting: %,d", i1.getItemExp());
                        System.out.printf("\nItem sell price: %,d\n", i1.getItemSellPrice());
                        System.out.println("---------------------------------------------------");

                        int xpToGoal = u1.getGoalExp() - u1.getCurrExp();
                        double craftsToGoal = Math.ceil((double) xpToGoal / i1.getItemExp());  // cast xpToGoal to double to return decimals after division. round up to make sure Exp passes goal
                        double totalCost = craftsToGoal * (i1.getItemSellPrice() - i1.getMatCost());
                        double goldLeft = u1.getGold() + totalCost;

                        System.out.printf("Exp to goal: %,d", xpToGoal);
                        System.out.printf("\nCrafts to goal: %,.0f\n", craftsToGoal);
                        System.out.printf("\nCost: %,.0f\t (Positive = profit, Negative = loss)", totalCost);
                        if (goldLeft >= 0)
                            System.out.printf("\nYou will have %,.0f gold after completing your goal.", goldLeft);
                        else if (goldLeft < 0)
                            System.out.printf("\nYou need %,.0f gold to complete your goal.", Math.abs(goldLeft));
                    } else if (u1.getGold() < 0 || i1.getItemSellPrice() < 0){
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

