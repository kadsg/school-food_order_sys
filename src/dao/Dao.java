package dao;

import java.util.List;

/**
 * @author MingJie
 */
public interface Dao {
    boolean add(Object o);
    boolean delete(Object o);
    boolean update(Object o);
    Object search(String id);
    List<Object> search();
}
