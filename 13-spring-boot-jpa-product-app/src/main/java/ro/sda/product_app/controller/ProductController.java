package ro.sda.product_app.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ro.sda.product_app.dto.Product;
import ro.sda.product_app.service.ProductService;

import java.util.List;

@RestController
public class ProductController {

  @Autowired
  private ProductService productService;

  @PostMapping("/product/add")
  public void addProduct(@Valid @RequestBody Product p) {
    productService.addProduct(p);
  }

  @GetMapping("/products/all")
  public List<Product> findAllProducts() {
    return productService.findAllProducts();
  }

  @GetMapping("/product/{id}")
  public Product findById(@PathVariable int id) {
    return productService.findById(id);
  }
  
  @GetMapping("/product")
  public List<Product> productsWithGreaterPrice(@RequestParam int price){ 
    return productService.findProductsWithPriceGreaterThen(price);
  }
}

