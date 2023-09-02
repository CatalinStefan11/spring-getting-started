package ro.sda.product_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.product_app.dto.Product;
import ro.sda.product_app.exception.ProductAppException;
import ro.sda.product_app.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  public void addProduct(Product p) {
    productRepository.save(p);
  }

  public List<Product> findAllProducts() {
    return productRepository.findAll();
  }
  
  public Product findById(int id) {

    Optional<Product> product = productRepository.findById(id);
    
    if(product.isPresent()){
      return product.get();
    }
    
    throw new ProductAppException("Product with id: " + id + " not found!");
  }
  
  public List<Product> findProductsWithPriceGreaterThen(int price){
    return productRepository.findProductsByPriceGreaterThan(price);
  }
  
}
