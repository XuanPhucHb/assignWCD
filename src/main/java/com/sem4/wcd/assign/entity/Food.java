package com.sem4.wcd.assign.entity;

import java.util.Date;

public class Food {

    private Long id;
    private String foodCode;
    private String foodName;
    private String categoryCode;
    private String description;
    private String avatar;
    private int price;
    private int status;
    private Date createDate;
    private Date startSellDate;
    private Date updateDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFoodCode() {
        return foodCode;
    }

    public void setFoodCode(String foodCode) {
        this.foodCode = foodCode;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getStartSellDate() {
        return startSellDate;
    }

    public void setStartSellDate(Date startSellDate) {
        this.startSellDate = startSellDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", foodCode='" + foodCode + '\'' +
                ", foodName='" + foodName + '\'' +
                ", categoryCode='" + categoryCode + '\'' +
                ", description='" + description + '\'' +
                ", avatar='" + avatar + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", createDate=" + createDate +
                ", startSellDate=" + startSellDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
