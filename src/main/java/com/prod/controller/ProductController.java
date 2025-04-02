
package com.prod.controller ;

import com.prod.entity.Product;
import com.prod.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(
            @RequestParam(name="page", defaultValue = "0") int page) {
        List<Product> products = productService.getAllProducts(page, 10);
        return ResponseEntity.ok(products);
    }

   
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    // 3️ Create a new product
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return ResponseEntity.ok(createdProduct);
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable Long id,
            @RequestBody Product updatedProduct) {
        Product product = productService.updateProduct(id, updatedProduct);
        return ResponseEntity.ok(product);
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
        Product deletedProduct = productService.deleteProduct(id);
        return ResponseEntity.ok(deletedProduct);
    }
    
    
    @GetMapping("/category/{id}")
    public List<Product> getProductsByCategory(@PathVariable  Long id)
    {
    	return this.productService.getProductsByCategory(id);
    }
    
}
