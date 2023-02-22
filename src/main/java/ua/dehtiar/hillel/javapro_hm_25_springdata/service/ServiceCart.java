package ua.dehtiar.hillel.javapro_hm_25_springdata.service;

import java.util.ArrayList;
import java.util.List;
import lombok.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ua.dehtiar.hillel.javapro_hm_25_springdata.model.Product;
import ua.dehtiar.hillel.javapro_hm_25_springdata.repository.ProductRepository;

/**
 * @author Yaroslav Dehtiar on 10.02.2023
 */
@Value
@Service
@Scope("prototype")
public class ServiceCart {

  ProductRepository productRepository;
  List<Product> products = new ArrayList<>();

  public void addProduct(Integer id) {
    products.add(productRepository.getProductById(id));
  }

  public void removeProduct(Integer id) {
    products.remove(productRepository.getProductById(id));
  }

  public Double totalPrice() {
    return products.stream()
        .map(Product::getCost)
        .reduce(0.0, Double::sum);
  }
}
