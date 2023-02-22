package ua.dehtiar.hillel.javapro_hm_25_springdata.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.util.List;
import ua.dehtiar.hillel.javapro_hm_25_springdata.model.Product;

/**
 * @author Yaroslav Dehtiar on 10.02.2023
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoOrder {

  private Integer id;

  @JsonSerialize(using = LocalDateSerializer.class)
  @JsonDeserialize(using = LocalDateDeserializer.class)
  private LocalDate date;

  private Double cost;

  private List<Product> products;

}
