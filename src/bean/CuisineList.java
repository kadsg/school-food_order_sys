package bean;

import java.util.List;

public class CuisineList {
    Shop shop;
    private List<Cuisine> cuisineList;

    public CuisineList(Shop shop, List<Cuisine> cuisineList) {
        this.shop = shop;
        this.cuisineList = cuisineList;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public List<Cuisine> getCuisineList() {
        return cuisineList;
    }

    public void setCuisineList(List<Cuisine> cuisineList) {
        this.cuisineList = cuisineList;
    }
}
