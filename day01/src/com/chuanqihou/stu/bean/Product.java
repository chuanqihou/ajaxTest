package com.chuanqihou.stu.bean;

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

    @Override
    public String toString() {
        return "Product{" +
                "proId=" + proId +
                ", proName='" + proName + '\'' +
                ", proPrice=" + proPrice +
                ", proImg='" + proImg + '\'' +
                ", content='" + content + '\'' +
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

    public Product() {
    }

    public Product(Integer proId, String proName, Double proPrice, String proImg, String content) {
        this.proId = proId;
        this.proName = proName;
        this.proPrice = proPrice;
        this.proImg = proImg;
        this.content = content;
    }
}
