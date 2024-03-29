package org.springframework.samples.petclinic.product;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class ProductTypeFormatter implements Formatter<ProductType>{
    
    @Autowired
    ProductService productService;

    @Override
    public String print(ProductType object, Locale locale) {

        return object.getName();
    }

    @Override
    public ProductType parse(String text, Locale locale) throws ParseException {
        
        ProductType findProductType = this.productService.getProductType(text);

        try {
   
            if(findProductType.getName().equals(text)){
                return findProductType;
            }
            
        } catch (NullPointerException e) {
            throw new ParseException("This is not a product type", 0);
        }
        return findProductType;

        

        
    }
    
}
