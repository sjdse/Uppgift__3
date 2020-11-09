public class ItemInfo {
    private String itemName;
    private int matCost = -1;
    private int itemSellPrice = -1;
    private int itemExp = -1;


    public void setItemName(String itemName) {
        if (itemName != null)
            this.itemName = itemName;
        else
            throw new NullPointerException("Item name was null. Please try again. ");
    }

    public void setItemSellPrice(int itemSellPrice) {
        if (itemSellPrice >= 0)
            this.itemSellPrice = itemSellPrice;
        else
            System.out.println("Sell price can't be negative.");
    }

    public void setMatCost(int matCost) {
        if (matCost >= 0)
            this.matCost = matCost;
        else
            System.out.println("You're not getting paid to get the materials");
    }

    public void setItemExp(int itemExp) {
        if (itemExp >= 0)
            this.itemExp = itemExp;
        else
            System.out.println("You can't lose experience from crafting an item.");
    }

    public String getItemName() {
        return this.itemName;
    }


    public int getItemSellPrice() {
        return this.itemSellPrice;
    }
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

    public double craftsToGoal(int exp){
        return Math.ceil((double)exp/this.itemExp);
    }
    public double totalCost(double crafts){
        return crafts * (itemSellPrice - matCost);
    }

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
