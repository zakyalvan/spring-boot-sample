package sample.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sample.entity.Product;
import sample.repo.ProductRepository;

@RestController
@RequestMapping(value="/products")
public class ProductController {
	@Autowired
	private ProductRepository products;
	
	@RequestMapping(method=RequestMethod.GET)
	public Page<Product> listProducts(Pageable pageable) {
		return products.findAll(pageable);
	}
	
	@RequestMapping(value="/{id}/related-products", method=RequestMethod.PUT)
	public HttpEntity<Product> updateRelatedProducts(@PathVariable Long id, @RequestBody Set<Product> relatedProducts, BindingResult bindings) {
		if(!products.exists(id)) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
		
		Product target = products.findOne(id);
		List<Product> currentRelatedProducts = new ArrayList<>(target.getRelatedProducts());
		
		Set<Product> updatedRelatedProducts = new HashSet<>();
		for(Product relatedProduct : relatedProducts) {
			if(currentRelatedProducts.size() > 0 && currentRelatedProducts.contains(relatedProduct)) {
				updatedRelatedProducts.add(currentRelatedProducts.get(currentRelatedProducts.indexOf(relatedProduct)));
			}
			else {
				updatedRelatedProducts.add(products.findOne(relatedProduct.getId()));
			}
		}
		target.setRelatedProducts(updatedRelatedProducts);
		target = products.save(target);
		return new ResponseEntity<Product>(target, HttpStatus.OK);
	}
}
