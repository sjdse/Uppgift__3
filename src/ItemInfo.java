public class ItemInfo {
    private String itemName;
    private int matCost;
    private int itemSellPrice;
    private double itemExp;

    //final static double TIMEPERITEM = 3.6; //main?

    public void setItemName(String itemName) {
        if (itemName != null)
            this.itemName = itemName;
        else
            throw new NullPointerException("Item name was null. Please try again. ");
    }

    public void setItemSellPrice(int itemSellPrice) {
        this.itemSellPrice = itemSellPrice;
    }

    public void setMatCost(int matCost) {
        this.matCost = matCost;
    }

    public void setItemExp(int itemExp) {
        this.itemExp = itemExp;
    }

    public String getItemName() {
        return this.itemName;
    }

    public int getItemSellPrice() {
        return this.itemSellPrice;
    }

    public int getMatCost() {
        return this.matCost;
    }

    public double getItemExp() {
        return this.itemExp;
    }

}
