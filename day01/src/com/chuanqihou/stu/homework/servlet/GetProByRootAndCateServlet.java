package com.chuanqihou.stu.homework.servlet; /**
 * @author 传奇后
 * @date 2023/3/31 16:34
 * @description
 */

import com.chuanqihou.stu.homework.bean.Product;
import com.chuanqihou.stu.homework.dao.CategoryDao;
import com.chuanqihou.stu.homework.dao.ProductDao;
import net.sf.json.JSONArray;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetProByRootAndCateServlet", value = "/getProByRootAndCate")
public class GetProByRootAndCateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rootId = request.getParameter("rootId");
        String categoryId = request.getParameter("categoryId");

        response.setContentType("text/json;charset=utf-8");

        ProductDao productDao = new ProductDao();
        List<Product> proByRootAndCate = productDao.getProByRootAndCate(Integer.valueOf(rootId), Integer.valueOf(categoryId));
        JSONArray json = JSONArray.fromObject(proByRootAndCate);
        response.getWriter().print(json);
    }
}
