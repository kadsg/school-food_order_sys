package util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUtil {
    private Context context, contextNeeded;
    private DataSource ds;
    private Connection con;
    private static DBUtil dbUtil = new DBUtil();

    private DBUtil() {
        try {
            context = new InitialContext();
            contextNeeded = (Context) context.lookup("java:comp/env");
            ds = (DataSource) contextNeeded.lookup("rj20");
            con = ds.getConnection();
        } catch (NamingException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        return dbUtil.con;
    }

    public static PreparedStatement getPrepareStatment(String sql) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return preparedStatement;
    }

}
