package com.springproject.taco.services;

import com.springproject.taco.models.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    Product getProductBasedOnName(String name);
    Product getProductBasedOnProductId(Long id);
    Product getProductBasedOnUnitPrice(Double id);
    Long  getNumberOfProducts();
//    Product deleteProductById(Long productId);

    List getByPageAndSize(Integer page, Integer Size);

    public List<Object [] > getTheItemValue ();
}
