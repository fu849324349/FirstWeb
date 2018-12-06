package com.fuy.controller;

import com.fuy.dao.CookieD;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "CookieServlet",urlPatterns = "/CookieServlet")
public class CookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("psw");

        //判断username前端是否为空
        if(username!=null && !"".equals(username)){
            CookieD cookieD = new CookieD();
            boolean have = cookieD.isHave(username, password);
            if(have==true)
            {
                Cookie cookie = new Cookie("username",username);
                cookie.setMaxAge(100);
                resp.addCookie(cookie);
                //通过request得到session
                HttpSession session = req.getSession();
                //给session设置值，并把username带值到前端
                session.setAttribute("username",username);
                System.out.println("添加cookie");
                resp.sendRedirect("PageServlet");
                /*req.getRequestDispatcher("page/look.jsp").forward(req,resp);*/
                return;
            }else
            {
                req.getRequestDispatcher("page/signIn.jsp").forward(req,resp);
                return;
            }
        }else{
            Cookie[] cookies = req.getCookies();
            if (cookies != null&&cookies.length>0) {
                for(int i=0;i<cookies.length;i++){
                    if("username".equals(cookies[i].getName())){
                        req.getRequestDispatcher("PageServlet").forward(req,resp);
                        return;
                    }
                }
                req.getRequestDispatcher("page/login.jsp").forward(req,resp);
                return;
            }else{
                req.getRequestDispatcher("page/login.jsp").forward(req,resp);
                return;
            }
        }

        //重定向转到look页面
//        resp.sendRedirect("page/look.jsp");
    }
}
