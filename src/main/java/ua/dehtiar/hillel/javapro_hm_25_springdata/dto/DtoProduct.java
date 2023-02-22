package ua.dehtiar.hillel.javapro_hm_25_springdata.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Yaroslav Dehtiar on 10.02.2023
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoProduct {

  private Integer id;
  private String name;
  private double cost;

}
