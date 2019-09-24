package com.servlet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.entity.Goods;
import com.dao.SetGoodsDao;

public class SelectGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String goodsInfoName = req.getParameter("goodsInfoName");
        SetGoodsDao dao = new SetGoodsDao();
        Goods goods = dao.selectGoodsByname(goodsInfoName);
        req.setAttribute("goods",goods);
        req.getRequestDispatcher("details.jsp").forward(req,resp);
    }
}
