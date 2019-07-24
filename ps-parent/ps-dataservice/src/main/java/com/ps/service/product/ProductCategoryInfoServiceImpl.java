package com.ps.service.product;

import com.alibaba.dubbo.common.json.JSONObject;
import com.google.gson.Gson;
import com.ps.common.constant.Constants;
import com.ps.mapper.product.CategoryMapper;
import com.ps.model.product.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName dell
 * @Description TOOD
 * @Author X
 * @Data 2019/7/22
 * @Version 1.0
 **/

@Service("productCategoryInfoServiceImpl")
public class ProductCategoryInfoServiceImpl implements ProductCategoryInfoService {

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    /*@Override
    public String queryProductCategory() {
        //先去redis缓存中获取数据 如果没有再去数据库中查询 并在存放到redis缓存中
        //修改redis中key值得序列化方式
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //从redis操作对象中 获取操作对象的key=value值
        //opsForValue 操作数据值   ops是operations
        String productCategory = (String) redisTemplate.opsForValue().get(Constants.PRODUCT_CATEGORY);
        //判断redis中是否有值
        if (null == productCategory) {
             //去数据库中查询
            productCategory = categoryMapper.selectProductCategory();
            //将查询出的数据存放到redis
            redisTemplate.opsForValue().set(Constants.PRODUCT_CATEGORY,productCategory,15, TimeUnit.MINUTES);
        }

        return productCategory;
    }*/

    @Override
    public List<Category> queryProductCategory() {

        //去数据库中查询
        List<Category> productCategory = categoryMapper.selectProductCategory();

        return productCategory;
    }
}
