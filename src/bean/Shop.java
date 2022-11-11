package bean;

import java.util.List;

public class Shop {
    private String id_shop;
    private String id_merchant;
    private String name;
    private String pic;
    List<Cuisine> cuisineList;

    /**
     * 带菜单的构造函数
     * @param id_shop
     * @param id_merchant
     * @param name
     * @param pic
     * @param cuisineList
     */
    public Shop(String id_shop, String id_merchant, String name, String pic, List<Cuisine> cuisineList) {
        this.id_shop = id_shop;
        this.id_merchant = id_merchant;
        this.name = name;
        this.pic = pic;
        this.cuisineList = cuisineList;
    }

    public Shop(String id_shop, String id_merchant, String name, String pic) {
        this.id_shop = id_shop;
        this.id_merchant = id_merchant;
        this.name = name;
        this.pic = pic;
        this.cuisineList = null;
    }

    public String getId_shop() {
        return id_shop;
    }

    public void setId_shop(String id_shop) {
        this.id_shop = id_shop;
    }

    public String getId_merchant() {
        return id_merchant;
    }

    public void setId_merchant(String id_merchant) {
        this.id_merchant = id_merchant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public List<Cuisine> getCuisineList() {
        return cuisineList;
    }

    public void setCuisineList(List<Cuisine> cuisineList) {
        this.cuisineList = cuisineList;
    }
}
