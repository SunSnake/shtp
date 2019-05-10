package com.shtp.search.service;

import com.shtp.product.bean.ProductUnit;
import com.shtp.search.mapper.SearchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    @Autowired
    SearchMapper searchMapper;

    public List<ProductUnit> searchProduct(String words){
        return searchMapper.searchProduct(words);
    }
}
