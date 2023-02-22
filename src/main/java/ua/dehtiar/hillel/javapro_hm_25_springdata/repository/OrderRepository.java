package ua.dehtiar.hillel.javapro_hm_25_springdata.repository;

import org.springframework.data.repository.CrudRepository;
import ua.dehtiar.hillel.javapro_hm_25_springdata.model.Order;

/**
 * @author Yaroslav Dehtiar on 10.02.2023
 */
public interface OrderRepository extends CrudRepository<Order, Integer> {

  Order getOrderById(Integer id);

}
