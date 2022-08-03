package com.springproject.taco.controller;

import com.springproject.taco.models.Product;
import com.springproject.taco.repositories.ProductRepository;
import com.springproject.taco.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/list_all")
    public ResponseEntity getAllInventoryProducts() {
        List<Product> ls = productService.getAllProducts();
        return ResponseEntity.ok(ls);
    }

    @GetMapping("/single")
    public ResponseEntity getProductFromName(@RequestParam("product-name") String name) {
        Product product = productService.getProductBasedOnName(name);
        return  ResponseEntity.ok(product);
    }

    @GetMapping("/id")
    public ResponseEntity getProductFromProductId(@RequestParam("id") Long productId) {
        Product product = productService.getProductBasedOnProductId(productId);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/unit_price")
    public ResponseEntity getProductFromProductId(@RequestParam("price") Double price) {
        Product product = productService.getProductBasedOnUnitPrice(price);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/count")
    public ResponseEntity getProductNumber() {
        Long productCount = productService.getNumberOfProducts();
        if (productCount == null || productCount == 0) {
            return ResponseEntity.ok(ResponseEntity.EMPTY);
        }
        else
            return ResponseEntity.ok(productCount);
    }

//    @DeleteMapping("/delete")
//    public ResponseEntity deleteProductById (@RequestParam("id") Long productId) {
//        Product pd = productService.deleteProductById(productId);
//        return ResponseEntity.ok(pd);
//    }



    @GetMapping("/paged")
    public ResponseEntity getListByPageAndSize (@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        List<Product> ls = productService.getByPageAndSize(page, size);
        return ResponseEntity.ok(ls);
    }

    @GetMapping("/value")
    public ResponseEntity getTheItemValue () {
        return ResponseEntity.ok(productService.getTheItemValue());
    }


}
