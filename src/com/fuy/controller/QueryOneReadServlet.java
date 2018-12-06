package com.fuy.controller;

import com.fuy.bussiness.ShopBusiness;
import com.fuy.bussiness.ShopBusinessImpl;
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
 * 查看商品里的查询
 */
@WebServlet(name = "QueryOneReadServlet",value="/QueryOneReadServlet")
public class QueryOneReadServlet extends HttpServlet {
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
        //转向修改页面,updateOneRead.jsp
        req.getRequestDispatcher("page/updateOneRead.jsp").forward(req,resp);


    }


}
