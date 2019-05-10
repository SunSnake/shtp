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

    public void postProduct(ProductUnit productUnit){productMapper.postProduct(productUnit);}

    public List<ProductUnit> getAllPruducts() {
        return productMapper.getAllPruducts();
    }

    public void updateProduct(ProductUnit productUnit){
        productMapper.updateProduct(productUnit);
    }

    public void deleteProductUnit(int id){
        productMapper.deleteProductUnit(id);
    }
}
