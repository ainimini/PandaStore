package com.ps.service.product;

import com.ps.model.product.Category;
import com.ps.model.product.Product;

import java.util.List;

/**
 * @ClassName 查询产品种类信息
 * @Author X
 * @Data 2019/7/22
 * @Version 1.0
 * @Description TOOD
 **/
public interface ProductCategoryInfoService {
    /**
     * 查询产品种类
     * @return
     */
    List<Category> queryProductCategory();
}
