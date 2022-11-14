package servlet;

import bean.*;
import service.CuisineManage;
import service.OrderManage;
import service.ShopManage;
import util.DBUtil;
import util.RandomUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "Buy", value = "/Buy")
public class Buy extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection con = DBUtil.getConnection();

        try {
            // 开启事务
            con.setAutoCommit(false);

            // 获取勾选的菜品id
            String[] id_cuisines = request.getParameterValues("cuisine");

            // 获取当前时间
            LocalDateTime dateTime = LocalDateTime.now(); // get the current date and time
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String time_order = dateTime.format(formatter);

            // 获取用户的预定时间
            String temp = request.getParameter("time");
            String time_schedule = temp.substring(0, 10) + " " + temp.substring(10 + 1);

            // 获取订单的详情
            String id_shop = request.getParameter("id_shop");
            Shop shop = new ShopManage().getShopById(id_shop);
            User user = (User) request.getSession().getAttribute("user");
            int count = 0;
            double total = 0;
            String id_order = RandomUtil.getRandomOfOrder();

            for (String s : id_cuisines) {
                Cuisine cuisine = new CuisineManage().search(s);
                CuisineOrder cuisineOrder = new CuisineOrder(id_order, cuisine.getId_cuisine(), cuisine.getName(),
                        1, 1 * cuisine.getPrice(), time_order, 1);
                ++count;
                total += cuisine.getPrice();
                new OrderManage().addCusineOrder(cuisineOrder);
            }

            ShopOrder shopOrder = new ShopOrder(id_order, shop.getId_shop(), shop.getName(),
                    count, total, time_order, 1);
            new OrderManage().addShopOrder(shopOrder);

            UserOrder userOrder = new UserOrder(id_order, user.getId(), shop.getId_shop(),
                    shop.getName(), count, total,
                    time_order, time_schedule, 1);
            new OrderManage().addUserOrder(userOrder);

            // 提交事务
            con.commit();

//            HttpSession session = request.getSession();
//            session.setAttribute("userOrder", userOrder);
            response.sendRedirect("/view/display_order_after_buy.jsp?id_order=" + id_order);

            // TODO 订单跳转
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
}
