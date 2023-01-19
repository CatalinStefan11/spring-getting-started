package ro.sda.database_layer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.sda.database_layer.config.ProjectConfig;
import ro.sda.database_layer.model.Product;
import ro.sda.database_layer.service.ProductService;

public class Main {


  public static void main(String[] args) {


    try (AnnotationConfigApplicationContext context =
             new AnnotationConfigApplicationContext(ProjectConfig.class)) {


      ProductService productService = context.getBean(ProductService.class);
      productService.addProduct(new Product("product 1"));
      productService.addProduct(new Product("product 2"));
      productService.addProduct(new Product("product 3"));

      
      try{
        productService.addProductExWithoutTx(new Product("product 4"));
      } catch (RuntimeException e){
        System.out.println("Exception occurred from non transaction code");
      }

      try{
        productService.addProductExWithTransaction(new Product("product 5"));
      } catch (RuntimeException e){
        System.out.println("Exception occurred from transaction code");
      }

      System.out.println(productService.getAllProducts());
      
      
    }
  }

}
