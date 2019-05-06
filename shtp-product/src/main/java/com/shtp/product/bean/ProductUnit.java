package com.shtp.product.bean;

import org.springframework.stereotype.Component;

@Component
public class ProductUnit {
    private int id;
    private int userId;
    private Double price;
    private String description;
    private String imageUrl;

    public ProductUnit() {
    }


    public int getId() {
        return this.id;
    }

    public int getUserId() {
        return this.userId;
    }

    public Double getPrice() {
        return this.price;
    }

    public String getDescription() {
        return this.description;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ProductUnit)) return false;
        final ProductUnit other = (ProductUnit) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        if (this.getUserId() != other.getUserId()) return false;
        final Object this$price = this.getPrice();
        final Object other$price = other.getPrice();
        if (this$price == null ? other$price != null : !this$price.equals(other$price)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        final Object this$imageUrl = this.getImageUrl();
        final Object other$imageUrl = other.getImageUrl();
        if (this$imageUrl == null ? other$imageUrl != null : !this$imageUrl.equals(other$imageUrl)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ProductUnit;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getId();
        result = result * PRIME + this.getUserId();
        final Object $price = this.getPrice();
        result = result * PRIME + ($price == null ? 43 : $price.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        final Object $imageUrl = this.getImageUrl();
        result = result * PRIME + ($imageUrl == null ? 43 : $imageUrl.hashCode());
        return result;
    }

    public String toString() {
        return "ProductUnit(id=" + this.getId() + ", userId=" + this.getUserId() + ", price=" + this.getPrice() + ", description=" + this.getDescription() + ", imageUrl=" + this.getImageUrl() + ")";
    }
}
