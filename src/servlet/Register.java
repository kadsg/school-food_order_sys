package servlet;

import bean.User;
import service.UserManage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Register", value = "/Register")
public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = "";

        // TODO 验证码，输入校验
        UserManage userManage = new UserManage();
        if (userManage.isExist(id)) {
            // TODO 提示用户已经存在
        } else {
            User user = new User(id, password, name, phone, address);
            userManage.addUser(user);
            request.getSession().setAttribute("user", user);
            response.sendRedirect("/view/index_user.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
