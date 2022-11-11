package bean;

import java.util.List;

/**
 * 用户查询订单的所有记录
 * @author MingJie
 */
public class UserOrderList {
    User user;
    private List<UserOrder> userOrderList;

    public UserOrderList(User user, List<UserOrder> userOrderList) {
        this.user = user;
        this.userOrderList = userOrderList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<UserOrder> getUserOrderList() {
        return userOrderList;
    }

    public void setUserOrderList(List<UserOrder> userOrderList) {
        this.userOrderList = userOrderList;
    }
}
