package dao;

import bean.Cuisine;
import bean.Shop;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CuisineDao implements Dao, AllCuisineDao {
    Connection con;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    String sql;

    public CuisineDao() {
        con = DBUtil.getConnection();
    }

    @Override
    public boolean add(Object o) {
        sql = "insert into cuisine values(?,?,?,?,?)";
        Cuisine cuisine = (Cuisine) o;

        try {
            preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, cuisine.getId_cuisine());
            preparedStatement.setString(2, cuisine.getId_shop());
            preparedStatement.setString(3, cuisine.getName());
            preparedStatement.setDouble(4, cuisine.getPrice());
            preparedStatement.setString(5, cuisine.getPic());

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
        sql = "delete from cuisine where id_cuisine = ?";
        Cuisine cuisine = (Cuisine) o;

        try {
            preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, cuisine.getId_cuisine());

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
        sql = "update cuisine set id_cuisine=?, id_shop=?, name=?, price=?, pic=? where id_cuisine=?";
        Cuisine cuisine = (Cuisine) o;

        try {
            preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, cuisine.getId_cuisine());
            preparedStatement.setString(2, cuisine.getId_shop());
            preparedStatement.setString(3, cuisine.getName());
            preparedStatement.setDouble(4, cuisine.getPrice());
            preparedStatement.setString(5, cuisine.getPic());
            preparedStatement.setString(6, cuisine.getId_cuisine());

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
     * 根据菜品id查找菜品
     * @param id
     * @return
     */
    @Override
    public Object search(String id) {
        Cuisine cuisine = null;
        sql = "select id_cuisine, id_shop, name, price, pic from cuisine where id_cuisine=?";

        try {
            preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, id);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                cuisine = new Cuisine(resultSet.getString("id_cuisine"),
                        resultSet.getString("id_shop"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price"),
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

        return cuisine;
    }

    @Override
    public List<Object> search() {
        // TODO 暂时不做，没有使用场景
        return null;
    }

    @Override
    public List<Cuisine> search(Shop shop) {
        List<Cuisine> cuisineList = new LinkedList<>();
        sql = "select id_cuisine, id_shop, name, price, pic from cuisine where id_shop=?";

        try {
            preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, shop.getId_shop());

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Cuisine cuisine = new Cuisine(resultSet.getString("id_cuisine"),
                        resultSet.getString("id_shop"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price"),
                        resultSet.getString("pic"));
                cuisineList.add(cuisine);
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
        return (cuisineList.size() == 0) ? null:cuisineList;
    }
}
