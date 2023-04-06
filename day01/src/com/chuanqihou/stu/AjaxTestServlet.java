package com.chuanqihou.stu; /**
 * @author 传奇后
 * @date 2023/3/31 9:33
 * @description
 */

import com.chuanqihou.stu.bean.Product;
import com.chuanqihou.stu.util.BaseDao;
import net.sf.json.JSONArray;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "AjaxTestServlet", value = "/testAjax")
public class AjaxTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=utf-8");

        BaseDao baseDao = new BaseDao();
        String sql = "select * from product";
        List<Product> products = baseDao.queryByAnnotation(sql, Product.class);

        JSONArray json = JSONArray.fromObject(products);

        PrintWriter pw = response.getWriter();

        pw.print(json);
    }
}
