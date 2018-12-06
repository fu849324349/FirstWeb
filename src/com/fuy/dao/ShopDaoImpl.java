package com.fuy.dao;

import com.fuy.DBUtils.DBUtil;
import com.fuy.entity.Shop;


import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShopDaoImpl implements ShopDao {
    //查询全部商品
    @Override
    public List<Shop> getAllShop() {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        List<Shop> list = new ArrayList<>();
        ResultSet rs = null;
        try {
            preparedStatement = connection.prepareStatement("select * from shop");
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int shop_id = rs.getInt("Shop_id");
                String shop_name = rs.getString("Shop_Name");
                String shop_des = rs.getString("Shop_des");
                String shop_img = rs.getString("Shop_img");
                BigDecimal shop_price1 = rs.getBigDecimal("Shop_price");
                int shop_cate_id = rs.getInt("Shop_Cate_id");
                int shop_stock = rs.getInt("Shop_Stock");
                Shop shop = new Shop(shop_id,shop_name,shop_des,shop_img,shop_price1,shop_cate_id,shop_stock);
                list.add(shop);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResource(connection, preparedStatement, rs);
        }

        return list;
    }
        //删除一条商品
    @Override
    public void deleteOneShop(int Shop_id)
        {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement =null;
            try {
                preparedStatement = connection.prepareStatement("delete from shop where Shop_id = ?");
                preparedStatement.setInt(1,Shop_id);
                int i = preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                DBUtil.closeResource(connection,preparedStatement,null);
            }
        }
    //添加一条商品
    @Override
    public boolean addOneShop(Shop shops)
    {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement =null;
        try {
            preparedStatement = connection.prepareStatement("insert into shop(Shop_Name,Shop_des,Shop_img,Shop_price,Shop_Cate_id,Shop_Stock)values (?,?,?,?,?,?)");
            preparedStatement.setString(1,shops.getShop_Name());
            preparedStatement.setString(2,shops.getShop_des());
            preparedStatement.setString(3,shops.getShop_img());
            preparedStatement.setBigDecimal(4,shops.getShop_price());
            preparedStatement.setInt(5,shops.getShop_Cate_id());
            preparedStatement.setInt(6,shops.getShop_Stock());
            int i = preparedStatement.executeUpdate();
            System.out.println("添加商品");
            if(i != 0)
            {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeResource(connection,preparedStatement,null);
        }
        return false;
    }
    //查询一条商品
    @Override
    public Shop queryOneShop(int shop_id ) {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            preparedStatement = connection.prepareStatement("select * from shop where shop_id=?");
            preparedStatement.setInt(1,shop_id);
            rs = preparedStatement.executeQuery();
            while(rs.next())
            {
                int shop_id1 = rs.getInt("Shop_id");
                String shop_name = rs.getString("Shop_Name");
                String shop_des = rs.getString("Shop_des");
                String shop_img = rs.getString("Shop_img");
                BigDecimal shop_price1 = rs.getBigDecimal("Shop_price");
                int shop_cate_id = rs.getInt("Shop_Cate_id");
                int shop_stock = rs.getInt("Shop_Stock");
                Shop shop = new Shop(shop_id1,shop_name,shop_des,shop_img,shop_price1,shop_cate_id,shop_stock);
                return shop;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally
        {
            DBUtil.closeResource(connection,preparedStatement,rs);
        }
        return null;


    }
    //修改一条商品
    @Override
    public boolean updateOneShop(Shop shop) {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("UPDATE shop SET shop_name=?,shop_des=?,shop_img=?,shop_price=?,shop_cate_id=?,shop_stock=? where shop_id=?");
            preparedStatement.setString(1,shop.getShop_Name());
            preparedStatement.setString(2,shop.getShop_des());
            preparedStatement.setString(3,shop.getShop_img());
            preparedStatement.setBigDecimal(4,shop.getShop_price());
            preparedStatement.setInt(5,shop.getShop_Cate_id());
            preparedStatement.setInt(6,shop.getShop_Stock());
            preparedStatement.setInt(7,shop.getShop_id());
            int i = preparedStatement.executeUpdate();
            if(i>0)
            {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally
        {
            DBUtil.closeResource(connection,preparedStatement,null);
        }

        return false;
    }

    //查询所有记录数
    @Override
    public int getAllRecords() {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement =null;
        try {
            preparedStatement = connection.prepareStatement("select  count(*) count from shop");
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                return  resultSet.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeResource(connection,preparedStatement,null);
        }
        return 0;
    }

    //查询某一页的数据
    @Override
    public List<Shop> getShopByLImit(int startIndex, int pagesize) {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement =null;
        List<Shop> shop = new ArrayList<>();
        ResultSet resultSet =null;
        try {
            preparedStatement = connection.prepareStatement("select * from shop limit ?,?");
            preparedStatement.setInt(1,startIndex);
            preparedStatement.setInt(2,pagesize);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                int shop_id = resultSet.getInt("shop_id");
                String shop_name = resultSet.getString("shop_name");
                String shop_img = resultSet.getString("shop_img");
                String shop_des = resultSet.getString("shop_des");
                BigDecimal shop_price = resultSet.getBigDecimal("shop_price");
                int shop_cate_id = resultSet.getInt("shop_Cate_id");
                int shop_stock = resultSet.getInt("shop_Stock");
                Shop shop1 = new Shop(shop_id,shop_name,shop_des,shop_img,shop_price,shop_cate_id,shop_stock);
                shop.add(shop1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeResource(connection,preparedStatement,null);
        }
        return shop;
    }


}
