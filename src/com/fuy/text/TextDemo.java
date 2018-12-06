package com.fuy.text;

import com.fuy.bussiness.ShopBusiness;
import com.fuy.bussiness.ShopBusinessImpl;
import com.fuy.entity.PageBean;

public class TextDemo {
    public static void main(String[] args) {
        ShopBusiness shopBusiness = new ShopBusinessImpl();
        PageBean shopByPaging = shopBusiness.getShopByPaging(1, 2);
        System.out.println(shopByPaging.getShops());

    }
}
