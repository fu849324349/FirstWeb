package com.fuy.controller;

import com.fuy.bussiness.ShopBusiness;
import com.fuy.bussiness.ShopBusinessImpl;
import com.fuy.dao.ShopDao;
import com.fuy.dao.ShopDaoImpl;
import com.fuy.entity.Shop;
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
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.List;

@WebServlet(name = "AddShopServlet",urlPatterns = "/AddShopServlet")
public class AddShopServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        //创建FileItem 对象的工厂类，这个工厂类在jar包中
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        // 负责处理上传的文件数据，并将表单中每个输入项封装成一个FileItem 对象中，那所有的上传的东西
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        //防止乱码
        servletFileUpload.setHeaderEncoding("utf-8");
        String shop_name = null;
        String shop_stock = null;
        String shop_price = null;
        String shop_cate_id = null;
        String shop_des = null;
        InputStream inputStream1 = null;
        FileOutputStream fileOutputStream =  null;
        String shop_img=null;
        try {
            List<FileItem> fileItems = servletFileUpload.parseRequest(req);
            for (FileItem f : fileItems) {
                //f.getname拿的是文件的名字
                //f.getFileName拿的是input中name的值
                if (!f.isFormField())//判断是不是Field文件
                {

//                    System.out.println(f.getName());
                    //所有文件的名字转为小写
                    shop_img = f.getName().toLowerCase();
                    //判断文件格式是否为图片
                    if (shop_img.endsWith(".jpg") || shop_img.endsWith(".jpeg") || shop_img.endsWith(".png")) {
                        //拿到文件的输入流
                        inputStream1 = f.getInputStream();
                        //输出流写出文件，可以传字符串或是file类型
                        fileOutputStream = new FileOutputStream("E://photos//" + f.getName());
                        byte[] bytes = new byte[1024];
                        //定义一个变量，这个变量是用来计数的
                        int len = 0;
                        //len不赋值就会出不来东西
                        while ((len = inputStream1.read(bytes)) != -1) {
                            //从0 开始读，读到最后不够1024的时候，直接到len的长度就停了
                            //不然回你本来要传的内容要大，以内最后没到1024也按1024传的
                            fileOutputStream.write(bytes, 0, len);
                        }
//                        req.getRequestDispatcher("PageServlet").forward(req, resp);

                    } else {
                        req.setAttribute("message", "不支持此格式，请重新上传");
                    }
                }else
                {
                    if("Shop_Name".equals(f.getFieldName()))
                    {
                        shop_name = f.getString("utf-8");
                        System.out.println("ming"+shop_name);
                    }
                    if("Shop_Stock".equals(f.getFieldName()))
                    {
                        shop_stock = f.getString();
                        System.out.println("shu"+shop_stock);
                    }
                    if("Shop_price".equals(f.getFieldName()))
                    {
                        shop_price = f.getString();
                        System.out.println("qian" +shop_price);
                    }
                    if("Shop_Cate_id".equals(f.getFieldName()))
                    {
                        shop_cate_id = f.getString();
                        System.out.println("hao"+shop_cate_id);
                    }
                    if("Shop_des".equals(f.getFieldName()))
                    {
                        shop_des = f.getString("utf-8");
                        System.out.println("miao"+shop_des);
                    }
                    /*if("Shop_id".equals(f.getFieldName()))
                    {
                        shop_id = f.getString();
                        System.out.println("id"+shop_id);
                    }*/
                }
            }
            BigDecimal shop_price1 = new BigDecimal(shop_price);
            int shop_stock1 = Integer.parseInt(shop_stock);
            int shop_cate_id1 = Integer.parseInt(shop_cate_id);
            /*int i = Integer.parseInt(shop_id);*/
            //多态创建一个shaoBusinessImpl的实现类
            ShopBusiness shopBusiness = new ShopBusinessImpl();
            Shop shop = new Shop(shop_name,shop_des,shop_img,shop_price1,shop_cate_id1,shop_stock1);
//            ShopDao shopDao = new ShopDaoImpl();
            boolean b = shopBusiness.addOneShop(shop);
//            boolean b = shopDao.addOneShop(shop);
            if(b == true)
            {
                System.out.println("添加成功");
            } else
            {
                System.out.println("添加失败");
            }
            System.out.println("重定向");
            req.getRequestDispatcher("PageServlet").forward(req,resp);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }finally
        {
            if(null != fileOutputStream)
            {
                fileOutputStream.close();
            }
            if(null != inputStream1)
            {
                inputStream1.close();
            }
        }
    }
}
