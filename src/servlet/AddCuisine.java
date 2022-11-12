package servlet;

import bean.Cuisine;
import bean.Shop;
import dao.CuisineDao;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import util.RandomUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddCuisine", value = "/AddCuisine")
public class AddCuisine extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 不允许使用get方式提交
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_cuisine = RandomUtil.getRandomIdOfCuisine();
        Shop shop = (Shop) request.getSession().getAttribute("shop");

        // 创建工厂类
        FileItemFactory factory = new DiskFileItemFactory();
        // 创建解析器
        ServletFileUpload fileUpload = new ServletFileUpload(factory);
        // 使用解析器解析request对象，保存在FileItem集合中
        List<FileItem> fileItemList = null;
        try {
            fileItemList = fileUpload.parseRequest(request);
        } catch (FileUploadException e) {
            throw new RuntimeException(e);
        }
        // 循环遍历FileItem对象
        String name_cuisine = null;
        String price = null;
        String oldName;
        String newName;

        for (FileItem fileItem : fileItemList) {
            if (fileItem.isFormField()) {
                // 如果是普通的表单对象
                if (fileItem.getFieldName().equals("name_cuisine")) {
                    name_cuisine = fileItem.getString("UTF-8");
                }

                if (fileItem.getFieldName().equals("price")) {
                    price = fileItem.getString("UTF-8");
                }
            } else {
                // 如果是文件对象
                // 获取文件名
                oldName = fileItem.getName();
                // 文件重命名，以菜品的id进行命名
                newName = id_cuisine + FilenameUtils.getExtension(oldName);
                // 获取保存文件的路径
                String path = (String) getServletContext().getAttribute("path");
                path += "/image/shop/" + shop.getId_shop() + "/" + id_cuisine;

                // 判断是否有该文件夹（应该是没有的）
                File file = new File(path);
                if (!file.exists()) {
                    file.mkdir();
                }

                try {
                    fileItem.write(new File(path, newName));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        Cuisine cuisine = new Cuisine(id_cuisine, shop.getId_shop(), name_cuisine,
                Double.parseDouble(price), id_cuisine);
        CuisineDao cuisineDao = new CuisineDao();

        if (cuisineDao.add(cuisine)) {
            // TODO 成功
            // TODO 页面重定向
        } else {
            // TODO 失败
            // TODO 页面重定向
        }
    }
}
