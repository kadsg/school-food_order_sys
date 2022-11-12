package util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUtil {
    private final Context context;
    private final Context contextNeeded;
    private final DataSource ds;
    private final Connection con;
    private static DBUtil dbUtil = new DBUtil();

    private DBUtil() {
        try {
            context = new InitialContext();
            contextNeeded = (Context) context.lookup("java:comp/env");
            ds = (DataSource) contextNeeded.lookup("group");
            con = ds.getConnection();
        } catch (NamingException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        /*if (dbUtil == null) {
            dbUtil = new DBUtil();
        }
        return dbUtil.con;*/
        try {
            return dbUtil.ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
