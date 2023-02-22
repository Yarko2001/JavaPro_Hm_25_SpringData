package ua.dehtiar.hillel.javapro_hm_25_springdata.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Yaroslav Dehtiar on 10.02.2023
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(schema = "my_store")
public class Order {

  @Id
  private Integer id;
  @Column(name = "creation_date")
  @JsonSerialize(using = LocalDateSerializer.class)
  @JsonDeserialize(using = LocalDateDeserializer.class)
  private LocalDate date;

  @Column
  private Double cost;

  @OneToMany(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "order_id")
  private List<Product> products;

}
