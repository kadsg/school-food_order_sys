package dao;

import bean.User;
import bean.UserOrder;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UserOrderDao implements Dao, OrderDao {
    Connection con;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    String sql;

    public UserOrderDao() {
        con = DBUtil.getConnection();
    }

    @Override
    public boolean add(Object o) {
        sql = "insert into order_user(id_order, id_user, id_shop, name_shop, count, total, time_order, time_scheduled, flag) values(?,?,?,?,?,?,?,?,?)";
        UserOrder userOrder = (UserOrder) o;

        try {
            preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, userOrder.getId_order());
            preparedStatement.setString(2, userOrder.getId_user());
            preparedStatement.setString(3, userOrder.getId_shop());
            preparedStatement.setString(4, userOrder.getName_shop());
            preparedStatement.setInt(5, userOrder.getCount());
            preparedStatement.setDouble(6, userOrder.getTotal());
            preparedStatement.setString(7, userOrder.getTime_order());
            preparedStatement.setString(8, userOrder.getTime_scheduled());
            preparedStatement.setInt(9, userOrder.getFlag());

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
        sql = "delete from order_user where id_order = ?";
        UserOrder userOrder = (UserOrder) o;

        try {
            preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, userOrder.getId_order());

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
        sql = "update order_user set id_order=?, id_user=?, id_shop=?, name_shop=?, count=?, total=?," +
                " time_order=?, time_scheduled=?, flag=? where id_order=?";
        UserOrder userOrder = (UserOrder) o;

        try {
            preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, userOrder.getId_order());
            preparedStatement.setString(2, userOrder.getId_user());
            preparedStatement.setString(3, userOrder.getId_shop());
            preparedStatement.setString(4, userOrder.getName_shop());
            preparedStatement.setInt(5, userOrder.getCount());
            preparedStatement.setDouble(6, userOrder.getTotal());
            preparedStatement.setString(7, userOrder.getTime_order());
            preparedStatement.setString(8, userOrder.getTime_scheduled());
            preparedStatement.setInt(9, userOrder.getFlag());
            preparedStatement.setString(10, userOrder.getId_order());

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
        UserOrder userOrder = null;
        sql = "select id_order, id_shop, name_shop, count, total," +
                " time_order, time_scheduled, flag from order_user where id_order=?";

        try {
            preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, id);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                userOrder = new UserOrder(resultSet.getString("id_order"),
                        id,
                        resultSet.getString("id_shop"),
                        resultSet.getString("name_shop"),
                        resultSet.getInt("count"),
                        resultSet.getDouble("total"),
                        resultSet.getString("time_order"),
                        resultSet.getString("time_scheduled"),
                        resultSet.getInt("flag")
                        );
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

        return userOrder;
    }

    @Override
    public List<Object> search() {
        // TODO 暂时不做，没有使用场景
        return null;
    }

    @Override
    public List<Object> search(Object o) {
        User user = (User) o;
        List<Object>userOrderList = new LinkedList<>();
        sql = "select id_order, id_user, id_shop, name_shop, count, total," +
                " time_order, time_scheduled, flag from order_user where id_user=?";

        try {
            preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, user.getId());

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                UserOrder userOrder;
                userOrder = new UserOrder(resultSet.getString("id_order"),
                        resultSet.getString("id_user"),
                        resultSet.getString("id_shop"),
                        resultSet.getString("name_shop"),
                        resultSet.getInt("count"),
                        resultSet.getDouble("total"),
                        resultSet.getString("time_order"),
                        resultSet.getString("time_scheduled"),
                        resultSet.getInt("flag"));
                userOrderList.add(userOrder);
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

        return (userOrderList.size() == 0) ? null : userOrderList;
    }
}
