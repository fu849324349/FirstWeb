package com.fuy.controller;

import com.fuy.dao.CookieD;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "SessionServlet",value = "/SessionServlet")
public class SessionServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //拿到表单传过来的用户名
        String username = req.getParameter("username");
        //get表单传过来的密码
        String password = req.getParameter("password");
        boolean have =false;
        if (username != null && !"".equals(username)&&password != null&&!"".equals(password)) {
            System.out.println("第一次判断也进入了");
            //调业务层的方法
            CookieD cookieD = new CookieD();
            //创建一个要比较的对象

            have = cookieD.isHave(username, password);
        }
            if (have) {
                System.out.println("进入二次判断了");
                Cookie cookie = new Cookie("denglu",username);
                cookie.setMaxAge(60);
                resp.addCookie(cookie);
                resp.sendRedirect("/SessionDemo.jsp");
                return;
            } else {
                Cookie[] cookies = req.getCookies();
                if (cookies != null) {
                    System.out.println("进入三次判断了");
                    for (Cookie c : cookies) {
                        if ("denglu".equals(c.getName())) {
                            resp.sendRedirect("/SessionDemo.jsp");
                        } else {
                            req.getRequestDispatcher("index.jsp").forward(req, resp);
                        }
                    }
                } else {
                    req.getRequestDispatcher("index.jsp").forward(req, resp);
                }

                System.out.println("asdfghjkl");
                HttpSession session = req.getSession();
                session.setAttribute("cookies", cookies);
                resp.sendRedirect("/shouye.jsp");
            }
    }
}
