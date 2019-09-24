package com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.entity.Goods;

public class SetGoodsDao {
    public List<Goods> getAllGoods() {
        List<Goods> list = new ArrayList();
        Connection conn = BaseDao.getConnection();
        String sql = "SELECT * FROM goodsinfo";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet res = pre.executeQuery();
            while (res.next()) {
                Goods goods = new Goods();
                goods.setId(res.getInt("id"));
                goods.setGoodsInfoName(res.getString("goodsInfoName"));
                goods.setGoodsInfoPic(res.getString("goodsInfoPic"));
                goods.setGoodsInfoPrice(res.getString("goodsInfoPrice"));
                goods.setGoodsInfoDescription(res.getString("goodsInfoDescription"));
                goods.setGoodsStock(res.getString("goodsStock"));
                goods.setCreated(res.getString("created"));
                goods.setCreatedDate(res.getString("createdDate"));
                goods.setFlag(res.getString("flag"));
                list.add(goods);
            }
            res.close();
            pre.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //临时加上的
    public Goods selectGoodsByname(String name) {
        Connection conn = BaseDao.getConnection();
        String sql = "SELECT * FROM goodsinfo g WHERE g.goodsInfoName=?;";
        Goods goods = null;
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,name);
            ResultSet res = pre.executeQuery();
            while (res.next()) {
                goods = new Goods();
                goods.setId(res.getInt("id"));
                goods.setGoodsInfoName(res.getString("goodsInfoName"));
                goods.setGoodsInfoPic(res.getString("goodsInfoPic"));
                goods.setGoodsInfoPrice(res.getString("goodsInfoPrice"));
                goods.setGoodsInfoDescription(res.getString("goodsInfoDescription"));
                goods.setGoodsStock(res.getString("goodsStock"));
                goods.setFlag(res.getString("flag"));
                System.out.println(goods.getFlag());
                goods.setCreated(res.getString("created"));
                goods.setCreatedDate(res.getString("createdDate"));
            }
            res.close();
            pre.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goods; // 返回
    }
    /**后续修改，条件查询时需要用多条件查询的方法
     * 多条件查询
     * @param stu
     * @return*/
    /*public List<Student> findByStu(Student stu){
        Connection conn = null;
        PreparedStatement prs = null;
        ResultSet rs = null;
        List<Student> list = new ArrayList<>();
        try {
            // 1、获得连接对象
            conn = this.getConnection();

            // 2、获得sql语句
            StringBuffer sf = new StringBuffer();
            sf.append(" select stuNo,stuName,stuSex,stuAge from a_student where 1=1 ");
            List paramList = new ArrayList();
            if(stu!=null){
                if(stu.getStuNo()>0){
                    sf.append(" and stuNo = ? ");
                    paramList.add(stu.getStuNo());
                }
                if(stu.getStuName()!=null){
                    sf.append(" and stuName like ? ");
                    paramList.add(stu.getStuName());
                }
                if(stu.getStuSex()!=null){
                    sf.append(" and stuSex = ? ");
                    paramList.add(stu.getStuSex());
                }
                if(stu.getAge()>0){
                    sf.append(" and stuAge = ? ");
                    paramList.add(stu.getAge());
                }
            }
            // 3、获得预编译语句集
            prs = conn.prepareStatement(sf.toString());
            // 4、设置占位符的值
            if(paramList!=null && paramList.size()>0){
                for(int i=0;i<paramList.size();i++){
                    prs.setObject(i+1,paramList.get(i));
                }
            }
            // 5、执行sql语句并获得结果集
            rs = prs.executeQuery();
            // 6、遍历
            while(rs.next()){
                Student entity = new Student();
                entity.setStuNo(rs.getInt("stuNo"));
                entity.setStuName(rs.getString("stuName"));
                entity.setStuSex(rs.getString("stuSex"));
                entity.setAge(rs.getInt("stuAge"));
                list.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 7、关闭资源
            this.closeAll(conn,prs,rs);
        }
        return list;
    }*/

    public boolean addGoods(Goods goods) {
        String sql = "INSERT INTO goodsinfo(goodsInfoName,goodsInfoPic,goodsInfoPrice,goodsInfoDescription,goodsStock,flag,created,createdDate)values(?,?,?,?,?,?,?,now())";
        try {
            Connection conn = BaseDao.getConnection();
            PreparedStatement pre = conn.prepareStatement(sql);
//            pre.setInt(1, goods.getId());
            pre.setString(1, goods.getGoodsInfoName());
            pre.setString(2, goods.getGoodsInfoPic());
            pre.setString(3, goods.getGoodsInfoPrice());
            pre.setString(4, goods.getGoodsInfoDescription());
            pre.setString(5, goods.getGoodsStock());
            pre.setString(6, goods.getFlag());
            pre.setString(7, goods.getCreated());
//            pre.setString(8, goods.getCreatedDate());
            int count = pre.executeUpdate();
            pre.close();
            return count > 0 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateGoods(Goods goods) {
        String sql = "UPDATE goodsinfo SET goodsInfoName=?,goodsInfoPic=?,goodsInfoPrice=?,goodsInfoDescription=?,goodsStock=?,flag=?,created=? WHERE id=?";
        Connection conn = BaseDao.getConnection();
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, goods.getGoodsInfoName());
            pre.setString(2, goods.getGoodsInfoPic());
            pre.setString(3, goods.getGoodsInfoPrice());
            pre.setString(4, goods.getGoodsInfoDescription());
            pre.setString(5, goods.getGoodsStock());
            pre.setString(6, goods.getFlag());
            pre.setString(7, goods.getCreated());
            pre.setInt(8, goods.getId());
            int count = pre.executeUpdate();
            pre.close();
            return count > 0 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteGoods(int id) {
        String sql = "DELETE FROM goodsinfo WHERE id = ?";
        Connection conn = BaseDao.getConnection();
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            int count = pre.executeUpdate();
            pre.close();
            return count > 0 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Goods selectGoodsById(int id) { // 根据ID进行查询
        Connection conn = BaseDao.getConnection();
        String sql = "SELECT * FROM goodsinfo WHERE id=?";
        Goods goods = null;
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet res = pre.executeQuery();
            while (res.next()) {
                goods = new Goods();
                goods.setId(res.getInt("id"));
                goods.setGoodsInfoName(res.getString("goodsInfoName"));
                goods.setGoodsInfoPic(res.getString("goodsInfoPic"));
                goods.setGoodsInfoPrice(res.getString("goodsInfoPrice"));
                goods.setGoodsInfoDescription(res.getString("goodsInfoDescription"));
                goods.setGoodsStock(res.getString("goodsStock"));
                goods.setFlag(res.getString("flag"));
                System.out.println(goods.getFlag());
                goods.setCreated(res.getString("created"));
                goods.setCreatedDate(res.getString("createdDate"));

            }
            res.close();
            pre.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goods; // 返回
    }

}
