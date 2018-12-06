package com.fuy.controller;

import com.fuy.bussiness.ShopBusiness;
import com.fuy.bussiness.ShopBusinessImpl;
import com.fuy.entity.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PageServlet",urlPatterns = "/PageServlet")
public class PageServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageNum = req.getParameter("pageNum");
        int changePage = 0;
        if (pageNum == null|| "".equals(pageNum))
        {
            changePage = 1;
        }else
            {
                changePage = Integer.parseInt(pageNum);
            }
        ShopBusiness shopBusiness = new ShopBusinessImpl();
        PageBean shopByPaging = shopBusiness.getShopByPaging(changePage, 5);
        System.out.println(shopByPaging);
        req.setAttribute("pageBean",shopByPaging);
        req.getRequestDispatcher("page/look.jsp").forward(req,resp);
    }
}
