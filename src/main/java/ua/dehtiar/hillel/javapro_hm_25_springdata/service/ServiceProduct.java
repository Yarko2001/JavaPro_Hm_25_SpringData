package ua.dehtiar.hillel.javapro_hm_25_springdata.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.dehtiar.hillel.javapro_hm_25_springdata.dto.DtoProduct;
import ua.dehtiar.hillel.javapro_hm_25_springdata.model.Product;
import ua.dehtiar.hillel.javapro_hm_25_springdata.repository.ProductRepository;

/**
 * @author Yaroslav Dehtiar on 10.02.2023
 */
@Service
@RequiredArgsConstructor
public class ServiceProduct {

  private final ProductRepository productRepository;
  private final ObjectMapper objectMapper;

  public DtoProduct createProduct(DtoProduct productDto) {

    Product product = objectMapper.convertValue(productDto, Product.class);
    productRepository.save(product);
    productDto.setId(product.getId());

    return productDto;
  }

  public Product getProduct(Integer id) {
    return productRepository.getProductById(id);
  }

  public List<Product> getAllProducts() {
    return (List<Product>) productRepository.findAll();
  }

}
