package servlet;

import bean.Cuisine;
import bean.CuisineOrder;
import bean.User;
import bean.UserOrder;
import service.CuisineManage;
import service.OrderManage;
import service.UserManage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CheckOrderOfShop", value = "/CheckOrderOfShop")
public class CheckOrderOfShop extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String id_order = request.getParameter("id_order");
        User checkingUser = new OrderManage().getUserByIdOrder(id_order);

        session.setAttribute("checkingUser", checkingUser);
        // 寻找指定的订单
        List<UserOrder> checkingUserOrderList = new OrderManage().getAllOrderOfUser(checkingUser);
        UserOrder checkingUserOrder = null;
        for (UserOrder userOrder : checkingUserOrderList) {
            if (userOrder.getId_order().equals(id_order)) {
                checkingUserOrder = userOrder;
                break;
            }
        }
        // 寻找该订单的所有预定菜品
        List<CuisineOrder> checkingCuisineOrderList = new OrderManage().getAllCuisineOrderById(id_order);

        session.setAttribute("checkingUserOrder", checkingUserOrder);
        session.setAttribute("checkingCuisineOrderList", checkingCuisineOrderList);

        response.sendRedirect("/view/display_detail_order_shop.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
