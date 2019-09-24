package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.dao.SetUserDao;
import com.entity.User;

public class RegisterServlet extends HttpServlet {
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
        String password123 = req.getParameter("password123");
        String sex = req.getParameter("sex");
        String hobbys = req.getParameter("hobbys");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String addrs = req.getParameter("addrs");
        String flag = req.getParameter("flag");
        if (username!=null&&username!=""&&password!=null&&password!=""&&password.equals(password123)) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setSex(sex);
            user.setHobbys(hobbys);
            user.setPhone(phone);
            user.setEmail(email);
            user.setAddrs(addrs);
            user.setFlag(flag);
            SetUserDao dao = new SetUserDao();
            if (dao.addUser(user)) {
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            } else {
                req.setAttribute("errMsg", "注册失败");
                req.getRequestDispatcher("register.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("errMsg", "两次密码不相同");
            req.setAttribute("errMsg", "用户名和密码不能为空");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        }
    }
}
