package com.shtp.product.service;

import com.shtp.product.bean.ProductUnit;
import com.shtp.product.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService {
    @Autowired
    ProductMapper productMapper;

    public void postProduct(){productMapper.postProduct();}

    public List<ProductUnit> getAllPruducts() {
        return productMapper.getAllPruducts();
    }
}
