package com.chuanqihou.stu.homework.servlet;
/**
 * @author 传奇后
 * @date 2023/3/31 16:15
 * @description
 */

import com.chuanqihou.stu.homework.bean.Product;
import com.chuanqihou.stu.homework.bean.RootCategory;
import com.chuanqihou.stu.homework.dao.CategoryDao;
import com.chuanqihou.stu.homework.dao.ProductDao;
import net.sf.json.JSONArray;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AllRootCategoryServlet", value = "/showAllRootCategory")
public class AllRootCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=utf-8");
        CategoryDao categoryDao = new CategoryDao();
        List<RootCategory> allRootCategory = categoryDao.getAllRootCategory();
        JSONArray json = JSONArray.fromObject(allRootCategory);
        response.getWriter().print(json);
    }
}
