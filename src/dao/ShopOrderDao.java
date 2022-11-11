package dao;

import bean.Shop;
import bean.ShopOrder;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ShopOrderDao implements Dao, OrderDao {
    Connection con;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    String sql;

    public ShopOrderDao() {
        con = DBUtil.getConnection();
    }

    @Override
    public boolean add(Object o) {
        sql = "insert into order_shop values(?,?,?,?,?,?,?)";
        ShopOrder shopOrder = (ShopOrder) o;

        try {
            preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, shopOrder.getId_order());
            preparedStatement.setString(2, shopOrder.getId_shop());
            preparedStatement.setString(3, shopOrder.getName_shop());
            preparedStatement.setInt(4, shopOrder.getCount());
            preparedStatement.setDouble(5, shopOrder.getTotal());
            preparedStatement.setString(6, shopOrder.getTime_order());
            preparedStatement.setInt(7, shopOrder.getFlag());

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
        sql = "delete from order_shop where id_order = ?";
        ShopOrder shopOrder = (ShopOrder) o;

        try {
            preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, shopOrder.getId_order());

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
        sql = "update order_shop set id_order=?, id_shop=?, name_shop=?, count=?, total=?," +
                " time_order=?, flag=? where id_order=?";
        ShopOrder shopOrder = (ShopOrder) o;

        try {
            preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, shopOrder.getId_order());
            preparedStatement.setString(2, shopOrder.getId_shop());
            preparedStatement.setString(3, shopOrder.getName_shop());
            preparedStatement.setInt(4, shopOrder.getCount());
            preparedStatement.setDouble(5, shopOrder.getTotal());
            preparedStatement.setString(6, shopOrder.getTime_order());
            preparedStatement.setInt(7, shopOrder.getFlag());

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
        ShopOrder shopOrder = null;
        sql = "select id_order, id_shop, name_shop, count, total," +
                " time_order, flag from order_shop where id_order=?";

        try {
            preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, id);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                shopOrder = new ShopOrder(resultSet.getString("id_order"),
                resultSet.getString("id_shop"),
                resultSet.getString("name_shop"),
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

        return shopOrder;
    }

    @Override
    public List<Object> search() {
        // TODO 暂时不做，没有使用场景
        return null;
    }

    @Override
    public List<Object> search(Object o) {
        Shop shop = (Shop) o;
        List<Object>shopOrderList = new LinkedList<>();
        sql = "select id_order, id_shop, name_shop, count, total," +
                " time_order, flag from order_shop where id_order=?";

        try {
            preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, shop.getId_shop());

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ShopOrder shopOrder;
                shopOrder = new ShopOrder(resultSet.getString("id_order"),
                        resultSet.getString("id_shop"),
                        resultSet.getString("name_shop"),
                        resultSet.getInt("count"),
                        resultSet.getDouble("total"),
                        resultSet.getString("time_order"),
                        resultSet.getInt("flag"));
                shopOrderList.add(shopOrder);
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

        return (shopOrderList.size() == 0) ? null : shopOrderList;
    }
}
