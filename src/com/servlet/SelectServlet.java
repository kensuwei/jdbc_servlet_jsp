package com.servlet;

import com.dao.SetGoodsDao;
import com.entity.Goods;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String idStr=req.getParameter("id");


//        goods.setId(Integer.parseInt(idStr));
        int id = Integer.valueOf(idStr);
        SetGoodsDao dao = new SetGoodsDao();
        Goods goods = dao.selectGoodsById(id);
        req.setAttribute("goods",goods);
        req.getRequestDispatcher("details.jsp").forward(req,resp);
    }
}
