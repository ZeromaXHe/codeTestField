package cn.zeromax.gameComponent;

public class ItemWrapperForPackage {
    private Item item;
    private int[] place; // 物品左上角所处位置

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int[] getPlace() {
        return place;
    }

    public void setPlace(int[] place) {
        this.place = place;
    }
}
