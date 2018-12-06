package com.fuy.controller;

import com.fuy.dao.SignInDao1;
import com.fuy.dao.SignInDaoImpl;
import com.fuy.entity.User;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

@WebServlet(name = "SignIn",value ="/signIn")
public class SignIn extends HttpServlet {
    public SignIn()
    {
        System.out.println("构造方法");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("init初始化方法");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String user_id = req.getParameter("User_id");
        int i = Integer.parseInt(user_id);

        String user_name = req.getParameter("User_name");

        String user_psw = req.getParameter("User_psw");

        String user_email = req.getParameter("User_email");

        String user_telPhone = req.getParameter("User_telPhone");

        String user_regDate = req.getParameter("User_regDate");

        System.out.println("jkj"+user_id+user_psw+user_email +user_telPhone);
        //构建一个user对象
        User users = new User(i,user_name,user_psw,user_email,user_telPhone,user_regDate);
        SignInDao1 signInDao1 = new SignInDaoImpl();
        boolean b = signInDao1.addOneUser(users);
        if (b == true)
        {
            req.getRequestDispatcher("login.jsp").forward(req,res);
            return;
        }else
        {
            req.setAttribute("message","注册失败");
            req.getRequestDispatcher("signIn.jsp").forward(req,res);
        }
    }

    @Override
    public void destroy() {
        System.out.println("销毁方法");
    }
}
