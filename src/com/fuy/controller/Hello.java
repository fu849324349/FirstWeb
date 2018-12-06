package com.fuy.controller;

import com.fuy.dao.UserDao;
import com.fuy.dao.UserDaoImpl;
import com.fuy.dao.UserDaoImpl2;
import com.fuy.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Hello",urlPatterns = "/helloSer")
public class Hello extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String psw = req.getParameter("psw");
        User user = new User();
        user.setUser_name(username);
        user.setUser_psw(psw);
        System.out.println("用户名："+username+"密码："+psw);
        UserDao userDao = new UserDaoImpl2();
        boolean exists = userDao.isExists(user);
        if (exists == true)
        {
            req.getRequestDispatcher("/PageServlet").forward(req,resp);
            return;
        }else
        {
            System.out.println("没找到");
            req.getRequestDispatcher("page/login.jsp").forward(req,resp);

        }

    }

}
