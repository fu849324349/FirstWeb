package com.fuy.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Shop implements Serializable {

    private int shop_id;

    private String shop_Name;

    private String shop_des;

    private String shop_img;

    private BigDecimal shop_price;

    private int shop_Cate_id;

    private int shop_Stock;

    public Shop()
    {

    }

    public Shop(int shop_id, String shop_Name, String shop_des, String shop_img, BigDecimal shop_price, int shop_Cate_id, int shop_Stock) {
        this.shop_id = shop_id;
        this.shop_Name = shop_Name;
        this.shop_des = shop_des;
        this.shop_img = shop_img;
        this.shop_price = shop_price;
        this.shop_Cate_id = shop_Cate_id;
        this.shop_Stock = shop_Stock;
    }
    //未给shop_id赋值的有参构造
    public Shop(String shop_Name, String shop_des, String shop_img, BigDecimal shop_price, int shop_Cate_id, int shop_Stock) {
        this.shop_Name = shop_Name;
        this.shop_des = shop_des;
        this.shop_img = shop_img;
        this.shop_price = shop_price;
        this.shop_Cate_id = shop_Cate_id;
        this.shop_Stock = shop_Stock;
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public String getShop_Name() {
        return shop_Name;
    }

    public void setShop_Name(String shop_Name) {
        this.shop_Name = shop_Name;
    }

    public String getShop_des() {
        return shop_des;
    }

    public void setShop_des(String shop_des) {
        this.shop_des = shop_des;
    }

    public String getShop_img() {
        return shop_img;
    }

    public void setShop_img(String shop_img) {
        this.shop_img = shop_img;
    }

    public BigDecimal getShop_price() {
        return shop_price;
    }

    public void setShop_price(BigDecimal shop_price) {
        this.shop_price = shop_price;
    }

    public int getShop_Cate_id() {
        return shop_Cate_id;
    }

    public void setShop_Cate_id(int shop_Cate_id) {
        this.shop_Cate_id = shop_Cate_id;
    }

    public int getShop_Stock() {
        return shop_Stock;
    }

    public void setShop_Stock(int shop_Stock) {
        this.shop_Stock = shop_Stock;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "shop_id=" + shop_id +
                ", shop_Name='" + shop_Name + '\'' +
                ", shop_des='" + shop_des + '\'' +
                ", shop_img='" + shop_img + '\'' +
                ", shop_price=" + shop_price +
                ", shop_Cate_id=" + shop_Cate_id +
                ", shop_Stock=" + shop_Stock +
                '}';
    }
}
