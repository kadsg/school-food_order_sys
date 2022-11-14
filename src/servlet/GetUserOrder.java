package servlet;

import bean.Shop;
import bean.User;
import bean.UserOrder;
import service.OrderManage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetUserOrder", value = "/GetUserOrder")
public class GetUserOrder extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");
        List<UserOrder> userOrderList = new OrderManage().getAllOrderOfUser(user);

        session.setAttribute("userOrderList", userOrderList);

        response.sendRedirect("/view/display_order_user.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
