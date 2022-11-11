package bean;

import java.util.List;

/**
 * 用户查询订单时的单条记录
 * @author MingJie
 */
public class UserOrder {
    private String id_order;
    private String id_user;
    private String id_shop;
    private String name_shop;
    private int count;
    private double total;
    private String time_order;
    private String time_scheduled;
    private int flag;
    private List<Cuisine> cuisineList;

    public UserOrder(String id_order, String id_user, String id_shop,
                     String name_shop, int count, double total,
                     String time_order, String time_scheduled, int flag,
                     List<Cuisine> cuisineList) {
        this.id_order = id_order;
        this.id_user = id_user;
        this.id_shop = id_shop;
        this.name_shop = name_shop;
        this.count = count;
        this.total = total;
        this.time_order = time_order;
        this.time_scheduled = time_scheduled;
        this.flag = flag;
        this.cuisineList = cuisineList;
    }

    public UserOrder(String id_order, String id_user, String id_shop,
                     String name_shop, int count, double total,
                     String time_order, String time_scheduled, int flag) {
        this.id_order = id_order;
        this.id_user = id_user;
        this.id_shop = id_shop;
        this.name_shop = name_shop;
        this.count = count;
        this.total = total;
        this.time_order = time_order;
        this.time_scheduled = time_scheduled;
        this.flag = flag;
        cuisineList = null;
    }

    public String getId_order() {
        return id_order;
    }

    public void setId_order(String id_order) {
        this.id_order = id_order;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
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

    public String getTime_scheduled() {
        return time_scheduled;
    }

    public void setTime_scheduled(String time_scheduled) {
        this.time_scheduled = time_scheduled;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public List<Cuisine> getCuisineList() {
        return cuisineList;
    }

    public void setCuisineList(List<Cuisine> cuisineList) {
        this.cuisineList = cuisineList;
    }

}
