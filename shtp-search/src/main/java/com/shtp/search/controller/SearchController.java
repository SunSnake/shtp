package com.shtp.search.controller;

import com.shtp.product.bean.ProductUnit;
import com.shtp.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/unit")
@RestController
public class SearchController {

    @Autowired
    SearchService searchService;

    @RequestMapping(value = "/searchPost", method = RequestMethod.POST)
    public List<ProductUnit> searchProduct(String words){

        String key = "%" + words + "%";
        return searchService.searchProduct(key);
    }
}
