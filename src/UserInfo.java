public class UserInfo {
    private String userName;
    private int gold = -1;
    private int currExp = -1;       //all instance variables are set to -1 to keep 0 as a valid input
    private int goalExp = -1;

    /**
     * Method that sets the user's username
     * @param userName is the username that will be set
     */
    public void setUserName(String userName) {
        if (userName != null)
            this.userName = userName;
        else
            throw new NullPointerException("Username was null. Please try again.");
    }

    /**
     * Method that sets the amount of gold the user has
     * @param gold is the gold that will be set
     */
    public void setGold(int gold) {
        if (gold >= 0)
            this.gold = gold;
        else
            System.out.println("You're not allowed to be in debt.");    //error message if the "setters" dont get a new value.
    }

    /**
     * Method that sets the current experience the user has
     * @param currExp is the currExp that will be set
     */
    public void setCurrExp(int currExp) {
        if (currExp >= 0)
            this.currExp = currExp;
        else
            System.out.println("Current experience has to be 0 or higher.");
    }

    /**
     * Method that sets the goal experience for the user
     * @param goalExp is the goalExp that will be set
     */
    public void setGoalExp(int goalExp) {
        if (goalExp > getCurrExp())
            this.goalExp = goalExp;
        else
            System.out.println("Your goal has to be higher than where you're at!");
    }

/*
    public String getUserName() {
        return this.userName;
    }
 */
/*
    public int getGold() {
        return this.gold;
    }
 */

    /**
     * Method that returns the currExp variable for the object
     * @return returns currExp
     */
    public int getCurrExp() {
        return this.currExp;
    }

    /**
     * Method that returns the goalExp variable for the object
     * @return returns goalExp
     */
    public int getGoalExp() {
        return this.goalExp;
    }

    /**
     * Method that calculates the experience left until goal for the object
     * @return returns experience until goal
     */
    public int expToGoal(){
        return (this.goalExp - this.currExp);
    }

    /**
     * Method that calculates how much gold the user will have when goal is completed
     * @param cost variable for how much it costs to get to the goal
     * @return returns gold left after goal
     */
    public double goldLeft(double cost){
        return this.gold + cost;
    }

    /**
     * Method used for printing variables from UserInfo
     * @return variables from UserInfo
     */
    @Override
    public String toString() {
        return String.format("*** User Info ***" +
                "\nUsername: %s" +
                "\nCurrent experience: %,d" +
                "\nExperience goal: %,d" +
                "\nGold: %,d" +
                "\n---------------------------------------------------", this.userName, this.currExp, this.goalExp, this.gold);
    }
}
