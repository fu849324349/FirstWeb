package com.fuy.dao;


import com.fuy.entity.Shop;

import java.util.List;

/**
 * 用来操作数据库
 */
public interface ShopDao {


    public List<Shop> getAllShop();// 接口中只有抽象方法，想写普通方法需要加default修饰
    //没有具体实现，谁继承这个接口，谁就实现这个方法
    public void deleteOneShop(int shop_id);

   public boolean addOneShop(Shop shops);
   //查询一条商品
    public Shop queryOneShop(int shop_id);
    //修改一条商品
    public boolean updateOneShop(Shop shop);
    //查询所有记录数
    public int getAllRecords();
    //查询某一页的数据
    public List<Shop> getShopByLImit(int startIndex,int pagesize);

}

