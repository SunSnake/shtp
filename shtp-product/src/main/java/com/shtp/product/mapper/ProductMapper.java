package com.shtp.product.mapper;

import com.shtp.product.bean.ProductUnit;

import java.util.List;

public interface ProductMapper {
    void postProduct();
    List<ProductUnit> getAllPruducts();
}
