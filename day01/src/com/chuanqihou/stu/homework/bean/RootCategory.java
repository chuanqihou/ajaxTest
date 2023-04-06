package com.chuanqihou.stu.homework.bean;

import com.chuanqihou.stu.util.Column;

/**
 * @author 传奇后
 * @date 2023/3/31 16:13
 * @description
 */
public class RootCategory {
    @Column("id")
    private Integer id;
    @Column("category_name")
    private String categoryName;

    @Override
    public String toString() {
        return "RootCategory{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                '}';
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

    public RootCategory() {
    }

    public RootCategory(Integer id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }
}
