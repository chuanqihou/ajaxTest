package com.chuanqihou.stu.homework.dao;

import com.chuanqihou.stu.homework.bean.Category;
import com.chuanqihou.stu.homework.bean.RootCategory;
import com.chuanqihou.stu.util.BaseDao;

import java.util.List;

/**
 * @author 传奇后
 * @date 2023/3/31 16:12
 * @description
 */
public class CategoryDao extends BaseDao {

    public List<RootCategory> getAllRootCategory() {
        String sql = "select * from root_category";
        return this.queryByAnnotation(sql, RootCategory.class);
    }

    public List<Category> getCategoryByRootId(Integer rootId) {
        String sql = "select * from category where root_category_id=?";
        return this.queryByAnnotation(sql, Category.class, rootId);
    }

}
