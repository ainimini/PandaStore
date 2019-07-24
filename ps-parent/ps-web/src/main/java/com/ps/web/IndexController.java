package com.ps.web;

import com.google.gson.Gson;
import com.ps.common.constant.Constants;
import com.ps.model.product.Category;
import com.ps.model.product.Product;
import com.ps.service.product.ProductCategoryInfoService;
import com.ps.service.product.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.lang.model.element.NestingKind;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName dell
 * @Description TOOD
 * @Author X
 * @Data 2019/7/23
 * @Version 1.0
 **/

@Controller
public class IndexController {

    @Autowired
    ProductCategoryInfoService productCategoryInfoService;

    @Autowired
    ProductInfoService productInfoService;

    @RequestMapping(value = "/index")

    public String index(HttpServletRequest request, Model model){
        //产品种类 (导航栏)
        List<Category> productCategory = productCategoryInfoService.queryProductCategory();
        model.addAttribute(Constants.PRODUCT_CATEGORY, productCategory);

        //热门商品
        List<Product> hotProductList = productInfoService.queryHotProductList();
        model.addAttribute(Constants.HOT_PRODUCT_LIST, hotProductList);
        //最新商品
        List<Product> newProductList = productInfoService.queryNewProductList();
        model.addAttribute(Constants.NEW_PRODUCT_LIST,newProductList);




        //查询产品种类
        /*List<Category> categoryList = productCategoryInfoService.queryProductCategory();

        Gson gson = new Gson();
        String json = gson.toJson(categoryList);
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(json);
        model.addAttribute(Constants.PRODUCT_CATEGORY, json);*/

        return "index";
    }
}
