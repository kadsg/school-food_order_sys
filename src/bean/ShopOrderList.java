package bean;

import java.util.List;

public class ShopOrderList {
    private  Shop shop;
    private List<ShopOrder> shopOrderList;

    public ShopOrderList(Shop shop, List<ShopOrder> shopOrderList) {
        this.shop = shop;
        this.shopOrderList = shopOrderList;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public List<ShopOrder> getShopOrderList() {
        return shopOrderList;
    }

    public void setShopOrderList(List<ShopOrder> shopOrderList) {
        this.shopOrderList = shopOrderList;
    }
}
