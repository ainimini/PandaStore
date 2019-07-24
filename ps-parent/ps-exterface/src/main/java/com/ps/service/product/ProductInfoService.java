package com.ps.service.product;

import com.ps.model.product.Product;

import java.util.List;

/**
 * @ClassName 产品信息
 * @Description TOOD
 * @Author X
 * @Data 2019/7/23
 * @Version 1.0
 **/
public interface ProductInfoService {

    /**
     * 查询热门产品
     * @return
     */
    List<Product> queryHotProductList();

    /**
     * 查询最新产品
     * @return
     */
    List<Product> queryNewProductList();
}
