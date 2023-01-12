package ro.sda.database_layer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.database_layer.model.Product;
import ro.sda.database_layer.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void addProduct(Product p) {
        productRepository.addProduct(p.getName());
    }

    public void addProductExWithoutTx(Product p){
        productRepository.addProductExceptionWithoutTransaction(p.getName());
    }

    public void addProductExWithTransaction(Product p){
        productRepository.addProductExceptionWithTx(p.getName());
    }
    
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }
//
//    @Transactional
//    public void addTenProducts() throws Exception {
//        for (int i = 1; i <= 10; i++) {
//            productRepository.addProduct("Product " + i);
//            //if (i == 5) throw new RuntimeException(":(");
//        }
//    }
    

}
