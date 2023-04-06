package com.chuanqihou.stu.homework.bean;

import com.chuanqihou.stu.util.Column;

/**
 * @author 传奇后
 * @date 2023/3/31 16:13
 * @description
 */
public class Category {
    @Column("id")
    private Integer id;
    @Column("category_name")
    private String categoryName;
    @Column("root_category_id")
    private Integer rootCategoryId;

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", rootCategoryId=" + rootCategoryId +
                '}';
    }

    public Integer getRootCategoryId() {
        return rootCategoryId;
    }

    public void setRootCategoryId(Integer rootCategoryId) {
        this.rootCategoryId = rootCategoryId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Category() {
    }

    public Category(Integer id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }
}
