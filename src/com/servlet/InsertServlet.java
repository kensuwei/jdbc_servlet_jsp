package com.servlet;

import com.dao.SetGoodsDao;
import com.entity.Goods;
import com.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class InsertServlet extends HttpServlet {
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
        String goodsInfoPic = req.getParameter("goodsInfoPic");
        String goodsInfoPrice = req.getParameter("goodsInfoPrice");
        String goodsInfoDescription = req.getParameter("goodsInfoDescription");
        String goodsStock = req.getParameter("goodsStock");
        String flag = req.getParameter("flag");
        String user =(String)req.getSession().getAttribute("username");
        Goods goods = new Goods();
        goods.setGoodsInfoName(goodsInfoName);
        goods.setGoodsInfoPic(goodsInfoPic);
        goods.setGoodsInfoPrice(goodsInfoPrice);
        goods.setGoodsInfoDescription(goodsInfoDescription);
        goods.setGoodsStock(goodsStock);
        goods.setFlag(flag);
        goods.setCreated(user);
        SetGoodsDao dao = new SetGoodsDao();
        dao.addGoods(goods);
        req.getRequestDispatcher("showServlet").forward(req,resp);
    }
}
