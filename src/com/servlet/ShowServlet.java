package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.entity.Goods;
import com.dao.SetGoodsDao;

public class ShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SetGoodsDao dao = new SetGoodsDao();
       List<Goods> list = dao.getAllGoods();
       req.setAttribute("list",list);
       req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
