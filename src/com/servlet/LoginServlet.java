package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;

import com.entity.User;
import com.dao.SetUserDao;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        SetUserDao dao = new SetUserDao();
        User user = dao.login(username, password);

//        if (dao.login(username, password)) {
        if (user!=null) {
            //req.setAttribute("errMsg","登录成功");
            HttpSession session = req.getSession();

            req.getRequestDispatcher("showServlet").forward(req, resp);
            req.getSession().setAttribute("isLogin", true);
            session.setAttribute("username",username);
        } else {
            req.getRequestDispatcher("login.jsp").forward(req, resp);

        }
    }
}
