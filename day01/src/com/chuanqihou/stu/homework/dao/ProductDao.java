package com.chuanqihou.stu.homework.dao;

import com.chuanqihou.stu.homework.bean.Product;
import com.chuanqihou.stu.util.BaseDao;

import java.util.List;

/**
 * @author 传奇后
 * @date 2023/3/31 15:55
 * @description
 */
public class ProductDao extends BaseDao {

    public List<Product> queryAllProduct() {
        String sql = "select * from product2";
        return this.queryByAnnotation(sql, Product.class);
    }

    public Product getProductById(Integer proId) {
        String sql = "select * from product2 where pro_id=?";
        return this.queryOneByAnnotation(sql, Product.class, proId);
    }

    public List<Product> getProByRootCateId(Integer rootCategoryId) {
        String sql = "select * from product2 where pro_root_category_id=?";
        return this.queryByAnnotation(sql, Product.class, rootCategoryId);
    }

    public List<Product> getProByRootAndCate(Integer rootId,Integer categoryId) {
        String sql = "select * from product2 where pro_root_category_id=? and pro_category_id=?";
        return this.queryByAnnotation(sql, Product.class, rootId, categoryId);
    }

}
