package com.chuanqihou.stu.homework.servlet; /**
 * @author 传奇后
 * @date 2023/3/31 16:24
 * @description
 */

import com.chuanqihou.stu.homework.bean.Category;
import com.chuanqihou.stu.homework.bean.Product;
import com.chuanqihou.stu.homework.dao.CategoryDao;
import com.chuanqihou.stu.homework.dao.ProductDao;
import net.sf.json.JSONArray;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AllCategoryByRootIdServlet", value = "/showCategoryByRootId")
public class AllCategoryByRootIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rootId = request.getParameter("rootId");
        response.setContentType("text/json;charset=utf-8");

        CategoryDao categoryDao = new CategoryDao();
        List<Category> categories = categoryDao.getCategoryByRootId(Integer.valueOf(rootId));

        JSONArray json = JSONArray.fromObject(categories);
        response.getWriter().print(json);
    }
}
