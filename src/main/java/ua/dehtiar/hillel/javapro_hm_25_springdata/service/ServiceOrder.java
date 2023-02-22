package ua.dehtiar.hillel.javapro_hm_25_springdata.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;
import ua.dehtiar.hillel.javapro_hm_25_springdata.dto.DtoOrder;
import ua.dehtiar.hillel.javapro_hm_25_springdata.model.Order;
import ua.dehtiar.hillel.javapro_hm_25_springdata.repository.OrderRepository;

/**
 * @author Yaroslav Dehtiar on 10.02.2023
 */
@Service
@RequiredArgsConstructor
public class ServiceOrder {

  private final OrderRepository orderRepository;
  private final ObjectMapper objectMapper;

  public DtoOrder createOrder(DtoOrder orderDto) {

    Order order = objectMapper.convertValue(orderDto, Order.class);
    orderRepository.save(order);
    orderDto.setId(order.getId());

    return orderDto;
  }

  public Order getOrder(Integer id) {
    return orderRepository.getOrderById(id);
  }

  public List<Order> getAllOrders() {
    return (List<Order>) orderRepository.findAll();
  }

  public void addOrder(Integer id, ServiceCart cartService) {
    createOrder(
        new DtoOrder(id, LocalDate.now(), cartService.totalPrice(), cartService.getProducts()));
  }

  public void removeOrder(Integer id) {
    orderRepository.deleteById(id);
  }
}
