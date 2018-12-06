package com.fuy.bussiness;

import com.fuy.entity.PageBean;
import com.fuy.entity.Shop;

import java.util.List;

/**
 * 商品操作业务层
 */
public interface ShopBusiness {
    public List<Shop> getAllShop();// 接口中只有抽象方法，想写普通方法需要加default修饰
    //没有具体实现，谁继承这个接口，谁就实现这个方法
    public void deleteOneShop(int shop_id);

    public boolean addOneShop(Shop shops);
    //查询一条商品
    public Shop queryOneShop(int shop_id);

    //修改一条商品
    public boolean updateOneShop(Shop shop);

    //根据当前页数和每页记录查询
    public PageBean getShopByPaging(int pageNum, int pageSize);


}
