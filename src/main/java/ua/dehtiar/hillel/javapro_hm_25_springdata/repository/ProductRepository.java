package ua.dehtiar.hillel.javapro_hm_25_springdata.repository;

import org.springframework.data.repository.CrudRepository;
import ua.dehtiar.hillel.javapro_hm_25_springdata.model.Product;

/**
 * @author Yaroslav Dehtiar on 10.02.2023
 */
public interface ProductRepository extends CrudRepository<Product, Integer> {

  Product getProductById(Integer id);

}
