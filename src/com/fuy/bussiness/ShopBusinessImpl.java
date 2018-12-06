package com.fuy.bussiness;

import com.fuy.dao.ShopDao;
import com.fuy.dao.ShopDaoImpl;
import com.fuy.entity.PageBean;
import com.fuy.entity.Shop;

import java.util.List;

/**
 * 商品操作业务层实现类
 */
public class ShopBusinessImpl implements ShopBusiness {
    //实例化商品dao实现类
    ShopDao shopDao = new ShopDaoImpl();

    @Override
    public List<Shop> getAllShop() {
        return null;
    }

    @Override
    public void deleteOneShop(int shop_id) {

    }

    @Override
    public boolean addOneShop(Shop shops) {
        return shopDao.addOneShop(shops);
    }

    @Override
    public Shop queryOneShop(int shop_id) {
        return shopDao.queryOneShop(shop_id);
    }

    @Override
    public boolean updateOneShop(Shop shop) {
        return shopDao.updateOneShop(shop);
    }

    @Override
    public PageBean getShopByPaging(int pageNum, int pageSize) {
        //查询所有记录
        int allRecords = shopDao.getAllRecords();
        //构建PageBean对象
        PageBean pageBean = new PageBean(pageNum, pageSize, allRecords);
        //拿到所有PageBean中的开始索引
        Integer startIndex = pageBean.getStartIndex();
        //根据索引和页面数量查询商品
        List<Shop> shopByLImit = shopDao.getShopByLImit(startIndex, pageSize);
        pageBean.setShops(shopByLImit);
        return pageBean;
    }


}
