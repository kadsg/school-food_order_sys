package servlet;

import service.CuisineManage;
import util.DBUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "DeleteCuisine", value = "/DeleteCuisine")
public class DeleteCuisine extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection con = DBUtil.getConnection();

        try {
            // 开启事务
            con.setAutoCommit(false);

            // 获取勾选的菜品id
            String[] id_cuisines = request.getParameterValues("cuisine");

            for (String s : id_cuisines) {
                new CuisineManage().delete(s);
            }

            // 提交事务
            con.commit();

            // TODO 跳转
            response.sendRedirect("/view/index_shop_merchant.jsp?id_shop=" + request.getParameter("id_shop"));

        } catch (SQLException e) {
            try {
                // 回滚
                con.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
