package service;

import bean.Cuisine;
import bean.Shop;
import dao.CuisineDao;

import java.util.List;

public class CuisineManage {
    CuisineDao dao;

    public boolean addCuisine(Cuisine cuisine) {
        dao = new CuisineDao();
        return dao.add(cuisine);
    }

    /**
     * 根据菜品id查找菜品
     * @param id
     * @return
     */
    public Cuisine search(String id) {
        dao = new CuisineDao();
        return (Cuisine) dao.search(id);
    }

    /**
     * 根据商铺查找菜品
     * @param shop
     * @return
     */
    public List<Cuisine> search(Shop shop) {
        dao = new CuisineDao();
        return dao.search(shop);
    }

    public boolean isExist(String id_cuisine) {
        return search(id_cuisine) != null;
    }
}
