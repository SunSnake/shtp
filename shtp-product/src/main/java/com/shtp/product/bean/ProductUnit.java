package com.shtp.product.bean;

public class ProductUnit {
    int id;
    int userId;
    String pic_src;
    Double price;
    String dipction;

    public ProductUnit() {
    }

    public int getId() {
        return this.id;
    }

    public int getUserId() {
        return this.userId;
    }

    public String getPic_src() {
        return this.pic_src;
    }

    public Double getPrice() {
        return this.price;
    }

    public String getDipction() {
        return this.dipction;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setPic_src(String pic_src) {
        this.pic_src = pic_src;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setDipction(String dipction) {
        this.dipction = dipction;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ProductUnit)) return false;
        final ProductUnit other = (ProductUnit) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$pic_src = this.getPic_src();
        final Object other$pic_src = other.getPic_src();
        if (this$pic_src == null ? other$pic_src != null : !this$pic_src.equals(other$pic_src)) return false;
        final Object this$price = this.getPrice();
        final Object other$price = other.getPrice();
        if (this$price == null ? other$price != null : !this$price.equals(other$price)) return false;
        final Object this$dipction = this.getDipction();
        final Object other$dipction = other.getDipction();
        if (this$dipction == null ? other$dipction != null : !this$dipction.equals(other$dipction)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ProductUnit;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getId();
        final Object $pic_src = this.getPic_src();
        result = result * PRIME + ($pic_src == null ? 43 : $pic_src.hashCode());
        final Object $price = this.getPrice();
        result = result * PRIME + ($price == null ? 43 : $price.hashCode());
        final Object $dipction = this.getDipction();
        result = result * PRIME + ($dipction == null ? 43 : $dipction.hashCode());
        return result;
    }

    public String toString() {
        return "ProductUnit(id=" + this.getId() + ", pic_src=" + this.getPic_src() + ", price=" + this.getPrice() + ", dipction=" + this.getDipction() + ")";
    }
}
