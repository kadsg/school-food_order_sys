package service;

import bean.Cuisine;
import bean.Shop;
import dao.CuisineDao;

import java.util.List;

public class CuisineManage {
    CuisineDao dao = new CuisineDao();

    public boolean addCuisine(Cuisine cuisine) {
        // TODO 在images/shop下上传菜品图片
        return dao.add(cuisine);
    }

    /**
     * 根据菜品id查找菜品
     * @param id
     * @return
     */
    public Cuisine search(String id) {
        return (Cuisine) dao.search(id);
    }

    /**
     * 根据商铺查找菜品
     * @param shop
     * @return
     */
    public List<Cuisine> search(Shop shop) {
        return dao.search(shop);
    }
}
