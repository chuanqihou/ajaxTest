package com.chuanqihou.stu.homework.servlet; /**
 * @author 传奇后
 * @date 2023/3/31 16:07
 * @description
 */

import com.chuanqihou.stu.homework.bean.Product;
import com.chuanqihou.stu.homework.dao.ProductDao;
import net.sf.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProductDetailServlet", value = "/getProDetail")
public class ProductDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=utf-8");
        ProductDao productDao = new ProductDao();
        String proIdStr = request.getParameter("proId");
        Product productById = productDao.getProductById(Integer.valueOf(proIdStr));
        JSONObject json = JSONObject.fromObject(productById);
        response.getWriter().print(json);
    }

}
