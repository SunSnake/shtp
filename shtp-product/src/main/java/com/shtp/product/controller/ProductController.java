package com.shtp.product.controller;

import com.shtp.product.bean.ProductUnit;
import com.shtp.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/unit")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public void postProduct(ProductUnit productUnit){
        productService.postProduct(productUnit);
    }

    @RequestMapping(value = "/load", method = RequestMethod.GET)
    public List<ProductUnit> getProduct(){
        return productService.getAllPruducts();
    }
}
