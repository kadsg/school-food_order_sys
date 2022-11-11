package dao;

import bean.User;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDao implements Dao {
    Connection con;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    String sql;

    public UserDao() {
        con = DBUtil.getConnection();
    }

    @Override
    public boolean add(Object o) {
        sql = "insert into users values(?,?,?,?,?)";
        User user = (User) o;

        try {
            preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, user.getId());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getName());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setString(5, user.getAddress());

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
        sql = "delete from users where id = ?";
        User user = (User) o;

        try {
            preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, user.getId());

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
        sql = "update users set id=?, password=?, name=?, phone=?, address=? where id=?";
        User user = (User) o;

        try {
            preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, user.getId());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getName());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setString(5, user.getAddress());
            preparedStatement.setString(6, user.getId());

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
        User user = null;
        sql = "select id, password, name, phone, address from users where id=?";

        try {
            preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, id);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User(resultSet.getString("id"),
                                resultSet.getString("password"),
                                resultSet.getString("name"),
                                resultSet.getString("phone"),
                                resultSet.getString("address"));
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

        return user;
    }

    @Override
    public List<Object> search() {
        // TODO 暂时不做，没有使用场景
        return null;
    }
}
