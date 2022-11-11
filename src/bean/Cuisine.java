package bean;

public class Cuisine {
    private String id_cuisine;
    private String id_shop;
    private String name;
    private double price;
    private String pic;

    public Cuisine(String id_cuisine, String id_shop, String name, double price, String pic) {
        this.id_cuisine = id_cuisine;
        this.id_shop = id_shop;
        this.name = name;
        this.price = price;
        this.pic = pic;
    }

    public String getId_cuisine() {
        return id_cuisine;
    }

    public void setId_cuisine(String id_cuisine) {
        this.id_cuisine = id_cuisine;
    }

    public String getId_shop() {
        return id_shop;
    }

    public void setId_shop(String id_shop) {
        this.id_shop = id_shop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
