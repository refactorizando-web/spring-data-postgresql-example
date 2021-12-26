package com.refactorizando.example.postgresql.repository;

import com.refactorizando.example.postgresql.CommonPostgresqlContainer;
import com.refactorizando.example.postgresql.entity.Car;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.PostgreSQLContainer;

@SpringBootTest
public class CarRepositorySharedIntegrationTest {

  @Autowired
  private CarRepository carRepository;

  public static PostgreSQLContainer postgreSQLContainer = CommonPostgresqlContainer.getInstance();

  @Test
  public void save_and_read_Car() {
    Car car = new Car();
    car.setDescription("New car");

    carRepository.save(car);

    List<Car> allCars = carRepository.findAll();

    assert !allCars.isEmpty();
    assert allCars.get(0).getDescription().equalsIgnoreCase("New car");
    assert allCars.size() == 1;
  }


}
