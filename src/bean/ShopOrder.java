package bean;

public class ShopOrder {
    private String id_order;
    private String id_shop;
    private String name_shop;
    private int count;
    private double total;
    private String time_order;
    private int flag;

    public ShopOrder(String id_order, String id_shop, String name_shop,
                     int count, double total, String time_order, int flag) {
        this.id_order = id_order;
        this.id_shop = id_shop;
        this.name_shop = name_shop;
        this.count = count;
        this.total = total;
        this.time_order = time_order;
        this.flag = flag;
    }

    public String getId_order() {
        return id_order;
    }

    public void setId_order(String id_order) {
        this.id_order = id_order;
    }

    public String getId_shop() {
        return id_shop;
    }

    public void setId_shop(String id_shop) {
        this.id_shop = id_shop;
    }

    public String getName_shop() {
        return name_shop;
    }

    public void setName_shop(String name_shop) {
        this.name_shop = name_shop;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getTime_order() {
        return time_order;
    }

    public void setTime_order(String time_order) {
        this.time_order = time_order;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
