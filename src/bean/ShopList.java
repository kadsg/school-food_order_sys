package bean;

import java.util.List;

public class ShopList {
    private List<Shop> shopList;

    public ShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }

    public List<Shop> getShopList() {
        return shopList;
    }

    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }
}
