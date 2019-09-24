package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.dao.SetGoodsDao;

public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        if(idStr!=null && !idStr.equals("")){
            int id = Integer.parseInt(idStr);
            SetGoodsDao dao = new SetGoodsDao();
            dao.deleteGoods(id);
        }
        req.getRequestDispatcher("showServlet").forward(req,resp);
    }
}
