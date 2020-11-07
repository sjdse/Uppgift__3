public class UserInfo {
    private String userName;
    private int gold = -1;
    private int currExp = -1;       //all instance variables are set to -1 to keep 0 as a valid input
    private int goalExp = -1;


    public void setUserName(String userName) {
        if (userName != null)
            this.userName = userName;
        else
            throw new NullPointerException("Username was null. Please try again.");
    }

    public void setGold(int gold) {
        if (gold >= 0)
            this.gold = gold;
        else
            System.out.println("You're not allowed to be in debt.");
    }

    public void setCurrExp(int currExp) {
        if (currExp >= 0)
            this.currExp = currExp;
        else
            System.out.println("Current experience has to be 0 or higher.");
    }

    public void setGoalExp(int goalExp) {
        if (goalExp > getCurrExp())
            this.goalExp = goalExp;
        else
            System.out.println("Your goal has to be higher than where you're at!");
    }


    public String getUserName() {
        return this.userName;
    }

    public int getGold() {
        return this.gold;
    }

    public int getCurrExp() {
        return this.currExp;
    }

    public int getGoalExp() {
        return this.goalExp;
    }

}
