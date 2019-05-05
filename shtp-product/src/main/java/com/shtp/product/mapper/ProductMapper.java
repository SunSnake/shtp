package com.shtp.product.mapper;

import com.shtp.product.bean.ProductUnit;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {
    void postProduct(ProductUnit productUnit);
    List<ProductUnit> getAllPruducts();
}
