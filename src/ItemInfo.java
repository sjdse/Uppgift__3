public class ItemInfo {
    private String itemName;
    private int matCost = -1;
    private int itemSellPrice = -1;
    private int itemExp = -1;

    /**
     * Method that sets the name of the item that will be crafted
     *
     * @param itemName is the name of the item that will be set
     */
    public void setItemName(String itemName) {
        if (itemName != null)
            this.itemName = itemName;
        else
            throw new NullPointerException("Item name was null. Please try again. ");
    }

    /**
     * Method that sets the sell price of the item
     *
     * @param itemSellPrice is the sell price that will be set
     */
    public void setItemSellPrice(int itemSellPrice) {
        if (itemSellPrice >= 0)
            this.itemSellPrice = itemSellPrice;
        else
            System.out.println("Sell price can't be negative.");
    }

    /**
     * Method that sets the cost of the materials to craft an item
     *
     * @param matCost is the matCost that will be set
     */
    public void setMatCost(int matCost) {
        if (matCost >= 0)
            this.matCost = matCost;
        else
            System.out.println("You're not getting paid to get the materials");
    }

    /**
     * Method that sets the experience gained from crafting an item
     *
     * @param itemExp is the itemExp that will be set
     */
    public void setItemExp(int itemExp) {
        if (itemExp >= 0)
            this.itemExp = itemExp;
        else
            System.out.println("You can't lose experience from crafting an item.");
    }


/*
    public String getItemName() {
        return this.itemName;
    }
 */

/*
    public int getItemSellPrice() {
        return this.itemSellPrice;
    }
 */
/*
    public int getMatCost() {
        return this.matCost;
    }
 */
/*
    public int getItemExp() {
        return this.itemExp;
    }
 */

    /**
     * Method that calculates how many crafts need to be done to get to the goal
     *
     * @param exp variable for how much experience is needed until goal
     * @return returns crafts needed until goal
     */
    public double craftsToGoal(int exp) {
        return Math.ceil((double) exp / this.itemExp);
    }

    /**
     * Method that calculates how much it will cost to get to the goal
     *
     * @param crafts variable for how many crafts that needs to be done
     * @return returns cost to get to goal
     */
    public double totalCost(double crafts) {
        return crafts * (itemSellPrice - matCost);
    }

    /**
     * Method used for printing variables from ItemInfo
     *
     * @return variables from ItemInfo
     */
    @Override
    public String toString() {
        return String.format("\n*** Item Info ***" +
                        "\nItem name: %s" +
                        "\nMaterial cost: %,d" +
                        "\nExperience for crafting: %,d" +
                        "\nItem sell price: %,d" +
                        "\n---------------------------------------------------"
                , this.itemName, this.matCost, this.itemExp, this.itemSellPrice);
    }

}
