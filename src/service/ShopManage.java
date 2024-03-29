package service;

import bean.Merchant;
import bean.Shop;
import dao.ShopDao;

import java.util.LinkedList;
import java.util.List;

public class ShopManage {
    ShopDao dao;

    public boolean addShop(Shop shop) {
        dao = new ShopDao();
        return dao.add(shop);
    }

    /**
     * @param id 商铺id
     * @return
     */
    public Shop getShopById(String id) {
        dao = new ShopDao();
        return (Shop) dao.search(id);
    }

    /**
     * 返回系统的所有商铺
     *
     * @return
     */
    public List<Shop> getAllShop() {
        dao = new ShopDao();
        List<Shop> shopList = new LinkedList<>();
        List<Object> list = dao.search();

        if (list != null) {
            for (Object o : list) {
                shopList.add((Shop) o);
            }
        }

        return shopList;
    }

    /**
     * 返回商家的所有商铺
     *
     * @param merchant
     * @return
     */
    public List<Shop> getAllShop(Merchant merchant) {
        dao = new ShopDao();
        List<Shop> shopList = new LinkedList<>();
        List<Object> list = dao.search();

        if (list != null) {
            for (Object o : list) {
                if (merchant.getId().equals(((Shop) o).getId_merchant())) {
                    shopList.add((Shop) o);
                }
            }
        }

        return shopList;
    }

    /**
     * 查询是否存在商铺
     *
     * @param id 商铺id
     * @return
     */
    public boolean isExist(String id) {
        return getShopById(id) != null;
    }
}
