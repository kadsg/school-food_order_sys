package servlet;

import bean.Merchant;
import bean.User;
import service.MerchantManage;
import service.UserManage;
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

        HttpSession session = request.getSession();

        // TODO 验证码, 输入校验
        if (LoginParse.parse(id, password, identity)) {
            if (identity.equals("user")) {
                User user = new UserManage().getUserById(id);
                session.setAttribute("user", user);
                response.sendRedirect("/view/index_user.jsp");
            } else {
                Merchant merchant = new MerchantManage().getMerchantById(id);
                session.setAttribute("merchant", merchant);
                response.sendRedirect("/view/index_merchant.jsp");
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
