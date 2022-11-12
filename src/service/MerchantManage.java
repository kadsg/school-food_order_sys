package service;

import bean.Merchant;
import dao.MerchantDao;

import java.util.LinkedList;
import java.util.List;

public class MerchantManage {
    MerchantDao dao = new MerchantDao();

    public boolean addMerchant(Merchant merchant) {
        return dao.add(merchant);
    }

    /**
     *
     * @param id 商家id
     * @return
     */
    public Merchant getMerchantById(String id) {
        return (Merchant) dao.search(id);
    }

    /**
     * 返回系统的所有商家
     * @return
     */
    public List<Merchant> getAllMerchant() {
        List<Merchant> merchantList = new LinkedList<>();
        List<Object> list = dao.search();

        for (Object o : list) {
            merchantList.add((Merchant) o);
        }
        return merchantList;
    }

    /**
     * 查询是否存在商家
     * @param id 商家id
     * @return
     */
    public boolean isExist(String id) {
        return getMerchantById(id) != null;
    }
}
