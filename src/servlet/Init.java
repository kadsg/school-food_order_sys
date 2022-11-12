package servlet;

import bean.Shop;
import service.ShopManage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "Init", value = "/Init")
public class Init extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 项目的web路径
        String path = "D:/JavaWeb/school-food_order_sys/web";
        ServletContext application = request.getServletContext();
        application.setAttribute("path", path);

        // 获取系统的所有shop
        List<Shop> shopList = new ShopManage().getAllShop();
        if (shopList == null) {
            shopList = new LinkedList<>();
        }
        application.setAttribute("shopList", shopList);

        response.sendRedirect("/index.jsp");
    }
}
