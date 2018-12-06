package com.fuy.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet(name = "ImgUploadServlet",urlPatterns = "/ImgUploadServlet")
public class ImgUploadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建FileItem 对象的工厂类，这个工厂类在jar包中
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        // 负责处理上传的文件数据，并将表单中每个输入项封装成一个FileItem 对象中，那所有的上传的东西
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        //防止乱码
        servletFileUpload.setHeaderEncoding("utf-8");
        try {
            List<FileItem> fileItems = servletFileUpload.parseRequest(req);
            for (FileItem f:fileItems) {//foreach循环遍历fileItems集合
                //f.getname拿的是文件的名字
                //f.getFileName拿的是input中name的值
                if (!f.isFormField())//判断是不是Field文件
                {
                    //所有文件的名字转为小写
                    String s = f.getName().toLowerCase();
                    //判断文件格式是否为图片
                    if (s.endsWith(".jpg")||s.endsWith(".jpeg")||s.endsWith(".png"))
                    {
                        //拿到文件的输入流
                        InputStream inputStream = f.getInputStream();
                        //输出流写出文件，可以传字符串或是file类型
                        FileOutputStream fileOutputStream = new FileOutputStream("E://photos//"+f.getName());
                        byte[] bytes = new byte[1024];
                        //定义一个变量，这个变量是用来计数的
                        int len = 0;
                        //len不赋值就会出不来东西
                        while((len = inputStream.read(bytes))!= -1)
                        {
                            //从0 开始读，读到最后不够1024的时候，直接到len的长度就停了
                            //不然回你本来要传的内容要大，以内最后没到1024也按1024传的
                            fileOutputStream.write(bytes,0,len);
                        }
                        req.getRequestDispatcher("page/look.jsp").forward(req,resp);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        inputStream.close();
                    }else
                    {
                        req.setAttribute("message","不支持此格式，请重新上传");
                        req.getRequestDispatcher("page/FileUpLoad.jsp").forward(req,resp);
                    }

                }else
                {
                    if ("username".equals(f.getFieldName()))
                    {
                        System.out.println("用户名"+f.getString());//获取非form域的值
                    }
                    if ("psw".equals(f.getFieldName()))
                    {
                        System.out.println("密码"+f.getString());//获取非form域的值
                    }
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }
}
