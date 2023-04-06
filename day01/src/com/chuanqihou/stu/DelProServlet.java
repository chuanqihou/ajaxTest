package com.chuanqihou.stu; /**
 * @author 传奇后
 * @date 2023/3/31 11:43
 * @description
 */

import com.chuanqihou.stu.util.BaseDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DelProServlet", value = "/delPro")
public class DelProServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String proIdObj = request.getParameter("proId");
        PrintWriter writer = response.getWriter();
        BaseDao baseDao = new BaseDao();
        String sql = "delete from product where pro_id=?";
        int i = baseDao.insertDeleteUpdate(sql, Integer.valueOf(proIdObj));
        if (i > 0) {
            writer.print("[编号："+proIdObj+"]删除成功！");
        }else{
            writer.print("删除失败");
        }

    }
}
