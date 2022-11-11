package dao;

import java.util.List;

public interface OrderDao {
    /**
     * 查找对象o的所有订单；
     * o可以是user、merchant、shop、
     * @param o
     * @return
     */
    List<Object> search (Object o);
}
