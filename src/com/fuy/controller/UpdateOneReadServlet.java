package com.fuy.controller;

import com.fuy.bussiness.ShopBusiness;
import com.fuy.bussiness.ShopBusinessImpl;
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
import java.math.BigDecimal;
import java.util.List;

/**
 * 查看商品里的修改
 */
@WebServlet(name = "UpdateOneReadServlet",value="/UpdateOneReadServlet")
public class UpdateOneReadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从请求域中把提交的数据拿过来
        String shop_id = req.getParameter("Shop_id");
        int shop_id1 = Integer.parseInt(shop_id);

        String shop_name = req.getParameter("Shop_Name");

        String shop_des = req.getParameter("Shop_des");

        String shop_img = req.getParameter("Shop_img");

        String shop_price = req.getParameter("Shop_price");
        BigDecimal shop_price1 = new BigDecimal(shop_price);

        String shop_cate_id = req.getParameter("Shop_Cate_id");
        int Shop_cate_id1 = Integer.parseInt(shop_cate_id);

        String shop_stock = req.getParameter("Shop_Stock");
        int shop_stock1 = Integer.parseInt(shop_stock);

        //new一个Shop,作为业务层的修改一条商品的形参
        Shop shop = new Shop(shop_id1,shop_name,shop_des,shop_img,shop_price1,Shop_cate_id1,shop_stock1);
        //实例化业务层
        ShopBusiness shopBusiness = new ShopBusinessImpl();
        //调用业务层的修改条商品的方法，
        boolean isUpdateSuccess = shopBusiness.updateOneShop(shop);
        //修改成功后去后台管理系统查看商品页面
        req.getRequestDispatcher("/PageServlet").forward(req,resp);
    }
}
