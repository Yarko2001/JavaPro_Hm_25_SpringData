package ua.dehtiar.hillel.javapro_hm_25_springdata.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.dehtiar.hillel.javapro_hm_25_springdata.model.Order;
import ua.dehtiar.hillel.javapro_hm_25_springdata.service.ServiceOrder;

/**
 * @author Yaroslav Dehtiar on 10.02.2023
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class OrderController {
    private final ServiceOrder orderService;

    @GetMapping(value = "/order/{id}")
    public Order getOrder(@PathVariable Integer id) {
      return orderService.getOrder(id);
    }

    @GetMapping(value = "/orders")
    public List<Order> getAllOrders() {
      return orderService.getAllOrders();
    }
}
