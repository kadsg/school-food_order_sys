package dao;

import bean.Shop;
import bean.CuisineOrder;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CuisineOrderDao implements Dao, OrderDao {
    Connection con;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    String sql;

    public CuisineOrderDao() {
        con = DBUtil.getConnection();
    }

    @Override
    public boolean add(Object o) {
        sql = "insert into order_cuisine(id_order, id_cuisine, name_cuisine, count, total, time_order, flag) values(?,?,?,?,?,?,?)";
        CuisineOrder cuisineOrder = (CuisineOrder) o;

        try {
            preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, cuisineOrder.getId_order());
            preparedStatement.setString(2, cuisineOrder.getId_cuisine());
            preparedStatement.setString(3, cuisineOrder.getName_cuisine());
            preparedStatement.setInt(4, cuisineOrder.getCount());
            preparedStatement.setDouble(5, cuisineOrder.getTotal());
            preparedStatement.setString(6, cuisineOrder.getTime_order());
            preparedStatement.setInt(7, cuisineOrder.getFlag());

            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                preparedStatement.close();
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        // TODO return false;
    }

    /**
     * 大概率不会用
     * @param o
     * @return
     */
    @Override
    public boolean delete(Object o) {
        sql = "delete from order_cuisine where id_order = ?";
        CuisineOrder cuisineOrder = (CuisineOrder) o;

        try {
            preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, cuisineOrder.getId_order());

            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                preparedStatement.close();
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        // TODO return false;
    }

    /**
     * 大概率不会用
     * @param o
     * @return
     */
    @Override
    public boolean update(Object o) {
        sql = "update order_cuisine set id_order=?, id_cuisine=?, name_cuisine=?, count=?, total=?," +
                " time_order=?, flag=? where id_order=?";
        CuisineOrder cuisineOrder = (CuisineOrder) o;

        try {
            preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, cuisineOrder.getId_order());
            preparedStatement.setString(2, cuisineOrder.getId_cuisine());
            preparedStatement.setString(3, cuisineOrder.getName_cuisine());
            preparedStatement.setInt(4, cuisineOrder.getCount());
            preparedStatement.setDouble(5, cuisineOrder.getTotal());
            preparedStatement.setString(6, cuisineOrder.getTime_order());
            preparedStatement.setInt(7, cuisineOrder.getFlag());

            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                preparedStatement.close();
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        // TODO return false;
    }

    @Override
    public Object search(String id) {
        CuisineOrder cuisineOrder = null;
        sql = "select id_order, id_cuisine, name_cuisine, count, total," +
                " time_order, flag from order_cuisine where id_order=?";

        try {
            preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, id);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                cuisineOrder = new CuisineOrder(resultSet.getString("id_order"),
                        resultSet.getString("id_cuisine"),
                        resultSet.getString("name_cuisine"),
                        resultSet.getInt("count"),
                        resultSet.getDouble("total"),
                        resultSet.getString("time_order"),
                        resultSet.getInt("flag"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                preparedStatement.close();
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return cuisineOrder;
    }

    @Override
    public List<Object> search() {
        // TODO 暂时不做，没有使用场景
        return null;
    }

    /**
     *
     * @param o Shop类型
     * @return shop的所有cuisine订单
     */
    @Override
    public List<Object> search(Object o) {
        Shop shop = (Shop) o;
        List<Object>cuisineOrderList = new LinkedList<>();
        sql = "select id_order, id_cuisine, name_cuisine, count, total," +
                " time_order, flag from order_cuisine where id_order=?";

        try {
            preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, shop.getId_shop());

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                CuisineOrder cuisineOrder;
                cuisineOrder = new CuisineOrder(resultSet.getString("id_order"),
                        resultSet.getString("id_cuisine"),
                        resultSet.getString("name_cuisine"),
                        resultSet.getInt("count"),
                        resultSet.getDouble("total"),
                        resultSet.getString("time_order"),
                        resultSet.getInt("flag"));
                cuisineOrderList.add(cuisineOrder);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                preparedStatement.close();
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return (cuisineOrderList.size() == 0) ? null : cuisineOrderList;
    }
}
