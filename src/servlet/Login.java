package servlet;

import util.LoginParse;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String identity = request.getParameter("identity");

        // TODO 验证码, 输入校验
        if (LoginParse.parse(id, password, identity)) {
            if (identity.equals("user")) {
                // TODO 重定向用户界面
            } else {
                // TODO 重定向商家界面
            }
        } else {
            // TODO 提示重新输入
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
