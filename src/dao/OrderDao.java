package dao;

import java.util.List;

/**
 * @author MingJie
 */
public interface OrderDao {
    /**
     * ���Ҷ���o�����ж�����
     * o������user��merchant��shop��
     * @param o
     * @return
     */
    List<Object> search (Object o);
}
