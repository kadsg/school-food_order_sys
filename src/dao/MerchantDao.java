package dao;

import bean.Merchant;
import bean.User;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MerchantDao implements Dao {
    Connection con;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    String sql;

    public MerchantDao() {
        con = DBUtil.getConnection();
    }

    @Override
    public boolean add(Object o) {
        sql = "insert into merchant values(?,?,?,?)";
        Merchant merchant = (Merchant) o;

        try {
            preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, merchant.getId());
            preparedStatement.setString(2, merchant.getPassword());
            preparedStatement.setString(3, merchant.getName());
            preparedStatement.setString(4, merchant.getPhone());

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
        sql = "delete from merchant where id = ?";
        Merchant merchant = (Merchant) o;

        try {
            preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, merchant.getId());

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
        sql = "update merchant set id=?, password=?, name=?, phone=?, where id=?";
        Merchant merchant = (Merchant) o;

        try {
            preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, merchant.getId());
            preparedStatement.setString(2, merchant.getPassword());
            preparedStatement.setString(3, merchant.getName());
            preparedStatement.setString(4, merchant.getPhone());
            preparedStatement.setString(5, merchant.getId());

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
        Merchant merchant = null;
        sql = "select id, password, name, phone from merchant where id=?";

        try {
            preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, id);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                merchant = new Merchant(resultSet.getString("id"),
                        resultSet.getString("password"),
                        resultSet.getString("name"),
                        resultSet.getString("phone"));
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

        return merchant;
    }

    @Override
    public List<Object> search() {
        // TODO 暂时不做，没有使用场景
        return null;
    }
}
