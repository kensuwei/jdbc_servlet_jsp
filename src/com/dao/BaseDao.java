package com.dao;
import java.sql.*;
public class BaseDao {
    private static String url = "jdbc:mysql://localhost:3306/mall?characterEncoding=utf8&useSSL=false&serverTimezone=CST";
    private static String userName = "root";
    private static String passWord = "root";
    private BaseDao(){}
    public static Connection getConnection(){
        Connection conn = null;
        if(null==conn){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(url,userName,passWord);
            }catch(Exception e ){
                e.printStackTrace();
            }
        }
        return conn;
    }
    public static void main(String[] args) {
        System.out.println("数据库连接成功"+getConnection());
    }
}
