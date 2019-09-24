package com.entity;

import java.io.Serializable;
public class Goods implements Serializable{

    private int id;
    private String goodsInfoName;
    private String goodsInfoPic;
    private String goodsInfoPrice;
    private String goodsInfoDescription;
    private String goodsStock;
    private String flag;
    private String created;
    private String createdDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodsInfoName() {
        return goodsInfoName;
    }

    public void setGoodsInfoName(String goodsInfoName) {
        this.goodsInfoName = goodsInfoName;
    }

    public String getGoodsInfoPic() {
        return goodsInfoPic;
    }

    public void setGoodsInfoPic(String goodsInfoPic) {
        this.goodsInfoPic = goodsInfoPic;
    }

    public String getGoodsInfoPrice() {
        return goodsInfoPrice;
    }

    public void setGoodsInfoPrice(String goodsInfoPrice) {
        this.goodsInfoPrice = goodsInfoPrice;
    }

    public String getGoodsInfoDescription() {
        return goodsInfoDescription;
    }

    public void setGoodsInfoDescription(String goodsInfoDescription) {
        this.goodsInfoDescription = goodsInfoDescription;
    }

    public String getGoodsStock() {
        return goodsStock;
    }

    public void setGoodsStock(String goodsStock) {
        this.goodsStock = goodsStock;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", goodsInfoName='" + goodsInfoName + '\'' +
                ", goodsInfoPic='" + goodsInfoPic + '\'' +
                ", goodsInfoPrice='" + goodsInfoPrice + '\'' +
                ", goodsInfoDescription='" + goodsInfoDescription + '\'' +
                ", goodsStock='" + goodsStock + '\'' +
                ", flag='" + flag + '\'' +
                ", created='" + created + '\'' +
                ", createdDate='" + createdDate + '\'' +
                '}';
    }
}
