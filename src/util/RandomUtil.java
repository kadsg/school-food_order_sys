package util;

import dao.ShopDao;
import service.ShopManage;

import java.util.Random;

/**
 * 随机数
 */
public class RandomUtil {
    /**
     * 获取n位随机数
     * @param n
     * @return
     */
    public static String getRandom(int n) {
        Random random = new Random();
        String random_number = "";
        for (int i = 1; i <= n; ++i) {
           random_number += String.valueOf(random.nextInt(9));
        }
        return random_number;
    }

    public static String getRandomIdOfShop() {
        ShopManage shopManage = new ShopManage();
        final int length = 6;
        String id_shop;
        // 获取长度为length的随机数（String）类型
        do {
            id_shop = RandomUtil.getRandom(length);
        } while (shopManage.isExist(id_shop));
        return id_shop;
    }
}
