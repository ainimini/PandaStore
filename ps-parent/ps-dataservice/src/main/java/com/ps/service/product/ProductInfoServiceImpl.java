package com.ps.service.product;

import com.ps.mapper.product.ProductMapper;
import com.ps.model.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName dell
 * @Description TOOD
 * @Author X
 * @Data 2019/7/24
 * @Version 1.0
 **/

@Service("productInfoServiceImpl")

public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    ProductMapper productMapper;

    /**
     * 最新产品
     * @return
     */
    @Override
    public List<Product> queryNewProductList() {

        //从数据库中查询
       List<Product> newProduct = productMapper.selctNewProductByPage();
        return newProduct;
    }

    /**
     * 热门产品
     * @return
     */
    @Override
    public List<Product> queryHotProductList() {

        //从数据库中查询
        List<Product> hotProduct = productMapper.selectHotProductByPage();
        return hotProduct;
    }
}
