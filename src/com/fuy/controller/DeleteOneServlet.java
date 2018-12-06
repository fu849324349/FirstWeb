package com.fuy.controller;

import com.fuy.dao.ShopDao;
import com.fuy.dao.ShopDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteOneServlet",value = "/shopServlet1")
public class DeleteOneServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String shop_id = req.getParameter("shop_id");
        ShopDao shopDao = new ShopDaoImpl();
        int i = Integer.parseInt(shop_id);
        shopDao.deleteOneShop(i);
        resp.sendRedirect("/PageServlet");
    }
}
