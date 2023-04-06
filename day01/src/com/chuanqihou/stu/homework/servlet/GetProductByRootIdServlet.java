package com.chuanqihou.stu.homework.servlet; /**
 * @author 传奇后
 * @date 2023/3/31 16:21
 * @description
 */

import com.chuanqihou.stu.homework.bean.Product;
import com.chuanqihou.stu.homework.dao.ProductDao;
import net.sf.json.JSONArray;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetProductByRootIdServlet", value = "/getProByRootId")
public class GetProductByRootIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=utf-8");
        ProductDao productDao = new ProductDao();
        String rootId = request.getParameter("rootId");
        List<Product> proByRootCateId = productDao.getProByRootCateId(Integer.valueOf(rootId));
        JSONArray json = JSONArray.fromObject(proByRootCateId);
        response.getWriter().print(json);
    }
}
