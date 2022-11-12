package service;

import bean.Shop;
import dao.ShopDao;

import java.util.LinkedList;
import java.util.List;

public class ShopManage {
    ShopDao dao = new ShopDao();

    public boolean addShop(Shop shop) {
        return dao.add(shop);
    }

    /**
     *
     * @param id 商铺id
     * @return
     */
    public Shop getShopById(String id) {
        return (Shop) dao.search(id);
    }

    /**
     * 返回系统的所有商铺
     * @return
     */
    public List<Shop> getAllShop() {
        List<Shop> shopList = new LinkedList<>();
        List<Object> list = dao.search();

        for (Object o : list) {
            shopList.add((Shop) o);
        }
        return shopList;
    }

    /**
     * 查询是否存在商铺
     * @param id 商铺id
     * @return
     */
    public boolean isExist(String id) {
        return getShopById(id) != null;
    }
}
