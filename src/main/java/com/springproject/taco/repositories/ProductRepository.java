package com.springproject.taco.repositories;

import com.springproject.taco.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    Product getProductByName(String productName);

    Product getProductByProductId(Long id);

    Product getProductByUnitPrice(Double price);

//    @Transactional
//    Product deleteByProductId(Long id);

    @Query(value = "select * from products  limit :page,:size", nativeQuery = true)
    List<Product> getByPage( @Param("page") Integer page, @Param("size") Integer size);

    // This query gets the QuantityStock and unitPrice to calculate the value of each product in stock
    @Query(value = "SELECT name, quantity_in_stock * unit_price AS market_value FROM products order by market_value DESC LIMIT 5", nativeQuery = true)
    List<Object[]> getItemsValue();




















//    List<Product> getProductGreaterThan();

//    Long  getNumberOfProducts();
}
