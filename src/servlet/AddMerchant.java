package servlet;

import bean.Merchant;
import service.MerchantManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddMerchant", value = "/AddMerchant")
public class AddMerchant extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MerchantManager merchantManager = new MerchantManager();

        String id_merchant = request.getParameter("id_merchant");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");

        if (merchantManager.isExist(id_merchant)) {
            // TODO 存在，设置message
        } else {
            Merchant merchant = new Merchant(id_merchant, password, name, phone);
            merchantManager.addMerchant(merchant);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
