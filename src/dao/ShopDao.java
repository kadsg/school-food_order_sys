package dao;

import bean.Shop;
import util.DBUtil;

import java.sql.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ShopDao implements Dao {
    Connection con;
    Statement statement;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    String sql;

    public ShopDao() {
        con = DBUtil.getConnection();
    }

    @Override
    public boolean add(Object o) {
        sql = "insert into shop values(?,?,?,?)";
        Shop shop = (Shop) o;

        try {
            preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, shop.getId_shop());
            preparedStatement.setString(2, shop.getId_merchant());
            preparedStatement.setString(3, shop.getName());
            preparedStatement.setString(4, shop.getPic());

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
    public boolean delete(Object o) {
        sql = "delete from shop where id_shop = ?";
        Shop shop = (Shop) o;

        try {
            preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, shop.getId_shop());

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
    public boolean update(Object o) {
        sql = "update shop set id_shop=?, id_merchant=?, name=?, pic=? where id_shop=?";
        Shop shop = (Shop) o;

        try {
            preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, shop.getId_shop());
            preparedStatement.setString(2, shop.getId_merchant());
            preparedStatement.setString(3, shop.getName());
            preparedStatement.setString(4, shop.getPic());
            preparedStatement.setString(5, shop.getId_shop());

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
        Shop shop = null;
        sql = "select id_shop, id_merchant, name, pic from shop where id_shop=?";

        try {
            preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, id);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                shop = new Shop(resultSet.getString("id_shop"),
                        resultSet.getString("id_merchant"),
                        resultSet.getString("name"),
                        resultSet.getString("pic"));
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
        return shop;
    }

    @Override
    public List<Object> search() {
        List<Object> shopList = new LinkedList<>();
        sql = "select id_shop, id_merchant, name, pic from shop";

        try {
            statement = con.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Shop shop = new Shop(
                        resultSet.getString("id_shop"),
                        resultSet.getString("id_merchant"),
                        resultSet.getString("name"),
                        resultSet.getString("pic"));
                shopList.add(shop);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return (shopList.size() == 0) ? null : shopList;
    }
}
