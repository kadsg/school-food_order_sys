package util;

import bean.Merchant;
import bean.User;
import dao.UserDao;
import service.MerchantManage;
import service.UserManage;

public class LoginParse {
    public static boolean parse(String id, String password, String identity) {
        if ("user".equals(identity)) {
            // 用户
            UserManage userManage = new UserManage();
            if (userManage.isExist(id)) {
                User user = userManage.getUserById(id);
                // 匹配
                return password.equals(user.getPassword());
            } else {
                // 账户不存在
                return false;
            }
        } else if ("merchant".equals(identity)) {
            // 商家
            MerchantManage merchantManage = new MerchantManage();
            if (merchantManage.isExist(id)) {
                Merchant merchant = merchantManage.getMerchantById(id);
                // 匹配
                return password.equals(merchant.getPassword());
            } else {
                // 账户不存在
                return false;
            }
        }
        // 不会走到这一步
        return false;
    }
}
