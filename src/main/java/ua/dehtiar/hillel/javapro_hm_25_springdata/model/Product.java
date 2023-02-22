package ua.dehtiar.hillel.javapro_hm_25_springdata.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Yaroslav Dehtiar on 10.02.2023
 */

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(schema = "my_store")
public class Product {

  @Id
  private Integer id;

  @Column
  private String name;

  @Column
  private Double cost;
}
