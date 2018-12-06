package com.fuy.controller;

import com.fuy.bussiness.ShopBusiness;
import com.fuy.bussiness.ShopBusinessImpl;
import com.fuy.bussiness.UserBusinneseImpl;
import com.fuy.dao.ShopDao;
import com.fuy.dao.ShopDaoImpl;
import com.fuy.entity.Shop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 修改商品里的查询，查询一条商品的Servlet
 */
@WebServlet(name = "QueryOneServlet",value="/QueryOneServlet")
public class QueryOneServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String shop_id = req.getParameter("shop_id");
        int i = Integer.parseInt(shop_id);
        //实例话商品业务层实现类
        ShopBusiness shopBusiness = new ShopBusinessImpl();
        //调用商品业务层查询一条商品的方法
        Shop shop = shopBusiness.queryOneShop(i);
        //将返回的结果，即一条商品,设置进请求域，起名为updateShop
        req.setAttribute("updateShop",shop);
        //查询出所有结果
        //因为未用iframe所以需要查出所有的商品
        ShopDao shopDao = new ShopDaoImpl();
        List<Shop> allShop = shopDao.getAllShop();
        //将结果放入请求域，取名为shops
        req.setAttribute("shops",allShop);
        //转向后台管理系统
        req.getRequestDispatcher("PageServlet").forward(req,resp);


    }
}
