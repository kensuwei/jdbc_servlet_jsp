package com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.entity.User;


/*public class SetUserDao {
    //    public boolean login(String username, String password) {
    public boolean login(String username,String password) {
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet res = null;
        boolean isLogin = false;
        String sql = "SELECT * FROM tb_user WHERE username=? and password=?";
        try {
            conn = BaseDao.getConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, username);
            pre.setString(2, password);
            System.out.println(username);
            System.out.println(password);
            res = pre.executeQuery();
            if (res!=null) {
                isLogin = true;
            }
//            pre.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, pre, res);
        }
        return isLogin;
    }*/

public class SetUserDao {
    public User login(String username,String password) {
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet res = null;
        User user = null;
//        boolean isLogin = false;
        String sql = "SELECT * FROM tb_user WHERE username=? and password=?";
        try {
            conn = BaseDao.getConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, username);
            pre.setString(2, password);
            res = pre.executeQuery();
            while (res.next()){
                user = new User();
                user.setUsername(res.getString("username"));
                user.setPassword(res.getString("password"));
            }
            /*if (res!=null) {
                return user;
            }*/
//            pre.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, pre, res);
        }
        return user;
    }

    public boolean addUser(User user) {
        Connection conn = null;
        PreparedStatement pre = null;
        String sql = "INSERT INTO tb_user(username,password,sex,hobbys,phone,email,addrs,flag)values(?,?,?,?,?,?,?,?)";
        try {
            conn = BaseDao.getConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, user.getUsername());
            pre.setString(2, user.getPassword());
            pre.setString(3, user.getSex());
            pre.setString(4, user.getHobbys());
            pre.setString(5, user.getPhone());
            pre.setString(6, user.getEmail());
            pre.setString(7, user.getAddrs());
            pre.setString(8, user.getFlag());
            int count = pre.executeUpdate();
            return count > 0 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(conn,pre,null);
        }
        return false;
    }

    public void closeAll(Connection connection, Statement statement, ResultSet res) {
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (res != null) {
                res.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
