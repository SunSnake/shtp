package com.shtp.search.mapper;

import com.shtp.product.bean.ProductUnit;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchMapper {
    List<ProductUnit> searchProduct(String words);
}
