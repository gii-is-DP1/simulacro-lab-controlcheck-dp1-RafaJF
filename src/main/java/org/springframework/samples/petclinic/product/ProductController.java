package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

public class ProductController {

    private static final String view = "products/createOrUpdateProductForm";

	private final ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@GetMapping(value = "/product/create")
	public String initCreationForm(Map<String, Object> model) {
		Product product = new Product();
		model.put("product", product);
        model.put("tipeList", List.of("Food", "Accessories"));
		return view;
	}
    // @PostMapping(value = "/product/create")
	// public String processCreationForm(@Valid Product product, BindingResult result) {
	// 	if (result.hasErrors()) {
	// 		return view;
	// 	}
	// 	else {
	// 		this.productService.save(product);
			
	// 		return "redirect:/product/" + product.getId();
	// 	}
	// }

    
	
    
}
