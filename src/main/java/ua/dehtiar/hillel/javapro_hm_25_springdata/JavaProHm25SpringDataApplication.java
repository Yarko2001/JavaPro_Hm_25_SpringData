package ua.dehtiar.hillel.javapro_hm_25_springdata;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import ua.dehtiar.hillel.javapro_hm_25_springdata.dto.DtoProduct;
import ua.dehtiar.hillel.javapro_hm_25_springdata.service.ServiceCart;
import ua.dehtiar.hillel.javapro_hm_25_springdata.service.ServiceOrder;
import ua.dehtiar.hillel.javapro_hm_25_springdata.service.ServiceProduct;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class JavaProHm25SpringDataApplication {

  private final ServiceProduct serviceProduct;
  private final ServiceOrder serviceOrder;
  private final ServiceCart serviceCartOne;
  private final ServiceCart serviceCartTwo;
  private final ServiceCart serviceCartThree;

  public static void main(String[] args) {
    SpringApplication.run(JavaProHm25SpringDataApplication.class, args);
  }

  @EventListener(ApplicationReadyEvent.class)
  public void onInit() {

    DtoProduct bread = new DtoProduct(1, "Bread", 18.50);
    DtoProduct buckwheat = new DtoProduct(2, "Buckwheat", 80.99);
    DtoProduct chicken = new DtoProduct(3, "Chicken", 100.0);
    DtoProduct banana = new DtoProduct(4, "Banana", 40.0);
    DtoProduct cucumber = new DtoProduct(5, "Cucumber", 40.0);
    DtoProduct tomato = new DtoProduct(6, "Tomato", 50.0);

    serviceProduct.createProduct(bread);
    serviceProduct.createProduct(buckwheat);
    serviceProduct.createProduct(chicken);
    serviceProduct.createProduct(banana);
    serviceProduct.createProduct(cucumber);
    serviceProduct.createProduct(tomato);

    log.info("All products in repository : {}", serviceProduct.getAllProducts());

    serviceCartOne.addProduct(1);
    serviceCartOne.addProduct(2);
    serviceCartOne.addProduct(3);
    serviceOrder.addOrder(1, serviceCartOne);

    serviceCartTwo.addProduct(1);
    serviceCartTwo.addProduct(3);
    serviceCartTwo.addProduct(4);
    serviceCartTwo.addProduct(5);
    serviceCartTwo.addProduct(6);
    serviceOrder.addOrder(2, serviceCartTwo);
//    serviceOrder.removeOrder(1);

    serviceCartThree.addProduct(1);
    serviceCartThree.addProduct(2);
    serviceCartThree.addProduct(3);
    serviceCartThree.addProduct(4);
    serviceCartThree.addProduct(5);
    serviceCartThree.addProduct(6);
    serviceOrder.addOrder(3,serviceCartThree);


  }

}
