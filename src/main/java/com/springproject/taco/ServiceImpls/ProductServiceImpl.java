package com.springproject.taco.ServiceImpls;

import com.springproject.taco.dto.ProductValueDTO;
import com.springproject.taco.models.Product;
import com.springproject.taco.repositories.ProductRepository;
import com.springproject.taco.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    /**
     *  These set of endpoints are the basic ones using the class(Product) properties to query the database.
     */

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductBasedOnName(String name){
        return productRepository.getProductByName(name);
    }

    public Product getProductBasedOnProductId(Long id){
        return productRepository.getProductByProductId(id);
    }

    public Product getProductBasedOnUnitPrice(Double id){
        return productRepository.getProductByUnitPrice( id);
    }

    /**
     * These are the endpoints that helps to query the database using the default JPA methods.
     *         productRepository.count();
     *         productRepository.delete();  still unable to actualize this
     *         productRepository.exists();
     */

    public Long getNumberOfProducts() {
        Long numberOfProducts = productRepository.count();
        return numberOfProducts;
    }


//    public Product deleteProductById(Long productId) {
//        if (productRepository.existsById(productId)){
//            Product toBeDeleted = productRepository.deleteByProductId(productId);
//            return toBeDeleted;
//        }
//        else {
//            return new Product();
//        }
//    }
    public List getByPageAndSize (Integer page, Integer size) {
        return productRepository.getByPage(page, size);

    }


//    public List<ProductValueDTO> getTheItemValue () {
////        ProductValueDTO dt = new ProductValueDTO();
////        List<Object [] > ls = productRepository.getItemsValue();
////        List<Object> pd = new ArrayList(Arrays.asList(ls));
////        pd.stream().collect(Collectors.toCollection((i) -> {
////            dt.setName(i.);
////        }))
//
//        for (int i = 0; )
//    }


    @Override
    public List<Object[]> getTheItemValue() {
        return productRepository.getItemsValue();
    }
}
