package com.shtp.product.controller;

import com.shtp.product.bean.ProductUnit;
import com.shtp.product.service.ProductService;
import com.shtp.product.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/unit")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductUnit productUnit;

    @RequestMapping("/submit")
    public void handleFileUpload(@RequestParam("userId") int userId,
                                 @RequestParam("description") String description,
                                 @RequestParam("price") Double price,
                                 @RequestParam("file") MultipartFile file) {
        String localPath="E:/IDEA/project/shtp/shtp-web/static";
        String fileName=file.getOriginalFilename();
        FileUtils.upload(file, localPath, fileName);

        String imgUrl = "http://localhost:8080/static" + "/"+ fileName;

        /*System.out.println(userId + description + price +imgUrl);*/

        productUnit.setUserId(userId);
        productUnit.setDescription(description);
        productUnit.setPrice(price);
        productUnit.setImageUrl(imgUrl);

        productService.postProduct(productUnit);
    }

    @RequestMapping(value = "/load", method = RequestMethod.GET)
    public List<ProductUnit> getProduct(){
        return productService.getAllPruducts();
    }
}
