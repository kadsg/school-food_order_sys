package dao;

import bean.Cuisine;
import bean.Shop;

import java.util.List;

public interface AllCuisineDao {
    /**
     * 获取商铺的所有菜品
     * @param shop
     * @return
     */
    List<Cuisine> search(Shop shop);
}
