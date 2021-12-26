package com.refactorizando.example.postgresql.entity.batch;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Brand {

  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Id
  private long id;

  private String name;

  @OneToMany(mappedBy = "brand")
  private Set<CarBatch> cars;

}
