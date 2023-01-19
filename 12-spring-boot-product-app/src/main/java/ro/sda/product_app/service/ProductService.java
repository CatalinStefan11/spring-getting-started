package ro.sda.product_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.product_app.model.Product;
import ro.sda.product_app.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  public void addProduct(Product p) {
    productRepository.addProduct(p.getName(), p.getDescription());
  }

  public List<Product> findAllProducts() {
    return productRepository.getAllProducts();
  }

  public Product findById(int id) {
    return productRepository.getById(id);
  }
}