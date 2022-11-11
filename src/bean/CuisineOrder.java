package bean;

public class CuisineOrder {
    private String id_order;
    private String id_cuisine;
    private String name_cuisine;
    private int count;
    private double total;
    private String time_order;
    private int flag;

    public CuisineOrder(String id_order, String id_cuisine, String name_cuisine,
                        int count, double total, String time_order,
                        int flag) {
        this.id_order = id_order;
        this.id_cuisine = id_cuisine;
        this.name_cuisine = name_cuisine;
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

    public String getId_cuisine() {
        return id_cuisine;
    }

    public void setId_cuisine(String id_cuisine) {
        this.id_cuisine = id_cuisine;
    }

    public String getName_cuisine() {
        return name_cuisine;
    }

    public void setName_cuisine(String name_cuisine) {
        this.name_cuisine = name_cuisine;
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
