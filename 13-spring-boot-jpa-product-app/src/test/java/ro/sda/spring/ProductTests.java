package ro.sda.spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.sda.product_app.dto.Product;
import ro.sda.product_app.repository.ProductRepository;
import ro.sda.product_app.service.ProductService;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ProductTests {

  @Mock
  private ProductRepository productRepository;

  @InjectMocks
  private ProductService productService;

  @Test
  public void testFindById() {
    Product product = new Product();
    product.setId(1);
    product.setName("Test Product");
    product.setPrice(10);
    product.setInStock(true);

    Mockito.when(productRepository.findById(1)).thenReturn(Optional.of(product));

    Product result = productService.findById(1);

    Assertions.assertEquals(1, result.getId());
    Assertions.assertEquals("Test Product", result.getName());
    Assertions.assertEquals(10, result.getPrice());
    Assertions.assertTrue(result.isInStock());
  }


}