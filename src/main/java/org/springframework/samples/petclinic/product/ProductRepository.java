package org.springframework.samples.petclinic.product;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;



public interface ProductRepository extends CrudRepository<Product,Integer>{
    
    List<Product> findAll();
    
    @Query("SELECT pt FROM ProductType pt")
    List<ProductType> findAllProductTypes();
    
    Optional<Product> findById(int id);
    Product findByName(String name);
    Product save(Product p); 

    @Query("SELECT pt FROM ProductType pt WHERE pt.name LIKE :name")
    ProductType getProductType(@Param("name") String name);

    @Query("SELECT ps FROM Product ps WHERE ps.price < :price")
    List <Product> findByPriceLessThan(@Param("price") Double price);



}
