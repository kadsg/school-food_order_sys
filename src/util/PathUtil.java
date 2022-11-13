package util;

import bean.Cuisine;
import bean.Shop;

import java.io.File;

/**
 * 显示图片所在路径
 * @author MingJie
 */
public class PathUtil {
    final static String path = "/image/shop/";
    public static String getPath(Shop shop) {
        return  path + shop.getId_shop() + "/" + shop.getPic();
    }

    public static String getPath(Cuisine cuisine) {
        return path + cuisine.getId_shop() + "/" + cuisine.getPic();
    }
}
