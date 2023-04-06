package com.chuanqihou.stu.homework.bean;

import com.chuanqihou.stu.util.Column;

/**
 * @author 传奇后
 * @date 2023/3/28 17:01
 * @description
 */
public class Product {
    @Column("pro_id")
    private Integer proId;
    @Column("pro_name")
    private String proName;
    @Column("pro_price")
    private Double proPrice;
    @Column("pro_img")
    private String proImg;
    @Column("pro_content")
    private String content;
    @Column("pro_root_category_id")
    private Integer proRootCategory;
    @Column("pro_category_id")
    private Integer proCategoryId;


    @Override
    public String toString() {
        return "Product{" +
                "proId=" + proId +
                ", proName='" + proName + '\'' +
                ", proPrice=" + proPrice +
                ", proImg='" + proImg + '\'' +
                ", content='" + content + '\'' +
                ", proRootCategory=" + proRootCategory +
                ", proCategoryId=" + proCategoryId +
                '}';
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public Double getProPrice() {
        return proPrice;
    }

    public void setProPrice(Double proPrice) {
        this.proPrice = proPrice;
    }

    public String getProImg() {
        return proImg;
    }

    public void setProImg(String proImg) {
        this.proImg = proImg;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getProRootCategory() {
        return proRootCategory;
    }

    public void setProRootCategory(Integer proRootCategory) {
        this.proRootCategory = proRootCategory;
    }

    public Integer getProCategoryId() {
        return proCategoryId;
    }

    public void setProCategoryId(Integer proCategoryId) {
        this.proCategoryId = proCategoryId;
    }
}
