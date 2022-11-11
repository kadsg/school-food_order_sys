package bean;

import java.util.List;

public class CuisineOrderList {
    private Shop shop;
    private List<CuisineOrder> cuisineOrderList;

    public CuisineOrderList(Shop shop, List<CuisineOrder> cuisineOrderList) {
        this.shop = shop;
        this.cuisineOrderList = cuisineOrderList;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public List<CuisineOrder> getCuisineOrderList() {
        return cuisineOrderList;
    }

    public void setCuisineOrderList(List<CuisineOrder> cuisineOrderList) {
        this.cuisineOrderList = cuisineOrderList;
    }
}
