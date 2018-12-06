package com.fuy.controller;

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
 * 查询商品的servlet，转向后台系统look.jsp
 */
@WebServlet(name = "ShopServlet",urlPatterns ="/shopServlet" )
public class ShopServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("被访问啦");
        ShopDao shopDao = new ShopDaoImpl();
        List<Shop> allShop = shopDao.getAllShop();
        req.setAttribute("shops",allShop);
        req.getRequestDispatcher("PageServlet").forward(req,resp);
    }
}

