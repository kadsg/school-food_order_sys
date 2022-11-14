package service;

import bean.*;
import dao.CuisineOrderDao;
import dao.ShopDao;
import dao.ShopOrderDao;
import dao.UserOrderDao;

import java.util.LinkedList;
import java.util.List;

public class OrderManage {

    /**
     * 添加UserOrder
     * @param userOrder
     * @return
     */
    public boolean addUserOrder(UserOrder userOrder) {
        return new UserOrderDao().add(userOrder);
    }

    /**
     * 添加ShopOrder
     * @param shopOrder
     * @return
     */
    public boolean addShopOrder(ShopOrder shopOrder) {
        return new ShopOrderDao().add(shopOrder);
    }

    /**
     * 添加CuisineOrder
     * @param cuisineOrder
     * @return
     */
    public boolean addCusineOrder(CuisineOrder cuisineOrder) {
        return new CuisineOrderDao().add(cuisineOrder);
    }

    public UserOrder getUserOrderById(String id) {
        return (UserOrder) new UserOrderDao().search(id);
    }

    public ShopOrder getShopOrderById(String id) {
        return (ShopOrder) new ShopOrderDao().search(id);
    }

    public CuisineOrder getCuisineOrder(String id) {
        return (CuisineOrder) new CuisineOrderDao().search(id);
    }

    /**
     * 获取订单号为id的用户订单
     * @param id
     * @return
     */
    public UserOrder getOrderofUser(String id) {
        return (UserOrder) new UserOrderDao().search(id);
    }

    /**
     * 取得用户user的所有订单
     * @param user
     * @return
     */
    public List<UserOrder> getAllOrderOfUser(User user) {
        List<UserOrder> userOrderList = null;
        List<Object> list = new UserOrderDao().search(user);

        if (list != null) {
            userOrderList = new LinkedList<>();
            for (Object o : list) {
                userOrderList.add((UserOrder) o);
            }
        }
        return userOrderList;
    }

    /**
     * 获取所有订单号为id_order的菜品订单
     * @param id_order
     * @return
     */
    public List<CuisineOrder> getAllCuisineOrderById(String id_order) {
        List<CuisineOrder> cuisineOrderList = null;
//        Shop shop = new ShopManage().getShopById(getUserOrderById(id_order).getId_shop());
        List<Object> tempList = new CuisineOrderDao().search();

        for (Object o : tempList) {
            if (((CuisineOrder) o).getId_order().equals(id_order)) {
                if (cuisineOrderList == null) {
                    cuisineOrderList = new LinkedList<>();
                }
                cuisineOrderList.add((CuisineOrder) o);
            }
        }
        return cuisineOrderList;
    }

    /**
     * 取得商铺的所有订单
     * @param shop
     * @return
     */
    public List<ShopOrder> getAllOrderOfShop(Shop shop) {
        List<ShopOrder> shopOrderList = null;
        List<Object> list = new ShopOrderDao().search(shop);

        if (list != null) {
            shopOrderList = new LinkedList<>();
            for (Object o : list) {
                shopOrderList.add((ShopOrder) o);
            }
        }
        return shopOrderList;
    }

    /**
     * 查询是否存在订单
     *
     * @param id 订单id
     * @return
     */
    public boolean isExist(String id) {
        return getUserOrderById(id) != null;
    }
}
