package ro.sda.spring;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ro.sda.product_app.controller.ProductController;
import ro.sda.product_app.dto.Product;
import ro.sda.product_app.service.ProductService;

//@ExtendWith(SpringExtension.class)
//@WebMvcTest(ProductController.class)
//@AutoConfigureMockMvc
//@SpringBootTest
//public class ProductControllerTests {
//
//  @Autowired
//  private MockMvc mockMvc;
//
//  @MockBean
//  private ProductService productService;
//
//  @Test
//  public void testFindById() throws Exception {
//    // Create a dummy product
//    Product product = new Product();
//    product.setId(1);
//    product.setName("Test Product");
//    product.setPrice(10);
//    product.setInStock(true);
//
//    // Mock the service's findById method
//    Mockito.when(productService.findById(1)).thenReturn(product);
//
//    // Perform GET request to /product/{id}
//    mockMvc.perform(MockMvcRequestBuilders.get("/product/{id}", 1))
//        .andExpect(MockMvcResultMatchers.status().isOk())
//        .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
//        .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Test Product"))
//        .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(10))
//        .andExpect(MockMvcResultMatchers.jsonPath("$.isInStock").value(true));
//  }
//}