public class UserInfo {
    private String userName;
    private int gold;
    private int currExp;
    private int goalExp;


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
            System.out.println("You're not allowed to be in debt. \nGold is set at 0\n");
    }

    public void setCurrExp(int currExp) {
        if (currExp >= 0)
            this.currExp = currExp;
        else
            System.out.println("Current experience has to be 0 or higher. \nCurrent experience set to 0.\n");
    }

    public void setGoalExp(int goalExp) {
        if (goalExp > getCurrExp())
            this.goalExp = goalExp;
        else
            System.out.println("Your goal has to be higher than where you're at!\nGoal experience set to 0\n");
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
