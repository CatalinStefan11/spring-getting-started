package ro.sda.product_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ro.sda.product_app.model.Product;
import ro.sda.product_app.service.ProductService;

import java.util.List;

@RestController
public class ProductController {

  @Autowired
  private ProductService productService;

  @PostMapping("/product/add")
  public void addProduct(@RequestBody Product p) {
    productService.addProduct(p);
  }

  @GetMapping("/product/all")
  public List<Product> findAllProducts() {
    return productService.findAllProducts();
  }

  @GetMapping("/product/{id}")
  public Product findProduct(@PathVariable int id) {
    return productService.findById(id);
  }
}
