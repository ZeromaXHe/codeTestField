package cn.zeromax.gameComponent;

import java.util.LinkedList;

public class ItemPackage extends Item{
    private int[] capacity; // capacity[0] x, capacity[1] y
    private int weightLimit;
    private LinkedList<ItemWrapperForPackage> itemList;

    public int[] getCapacity() {
        return capacity;
    }

    public void setCapacity(int[] capacity) {
        this.capacity = capacity;
    }

    public int getWeightLimit() {
        return weightLimit;
    }

    public void setWeightLimit(int weightLimit) {
        this.weightLimit = weightLimit;
    }

    public LinkedList<ItemWrapperForPackage> getItemList() {
        return itemList;
    }

    public void setItemList(LinkedList<ItemWrapperForPackage> itemList) {
        this.itemList = itemList;
    }
}
