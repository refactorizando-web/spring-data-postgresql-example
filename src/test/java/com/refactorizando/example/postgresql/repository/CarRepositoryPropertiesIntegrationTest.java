package com.refactorizando.example.postgresql.repository;

import com.refactorizando.example.postgresql.entity.Car;
import java.util.List;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.testcontainers.containers.PostgreSQLContainer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;


import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CarRepositoryPropertiesIntegrationTest {

  @Autowired
  private CarRepository carRepository;


  @DynamicPropertySource
  static void postgresqlProperties(DynamicPropertyRegistry registry) {
    registry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
    registry.add("spring.datasource.password", postgreSQLContainer::getPassword);
    registry.add("spring.datasource.username", postgreSQLContainer::getUsername);
  }

  @Container
  public static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer("postgres:11-alpine")
      .withDatabaseName("integration-tests-db")
      .withPassword("inmemory")
      .withUsername("inmemory");


  @Test
  public void save_and_read_car() {
    Car car = new Car();
    car.setDescription("New car");

    carRepository.save(car);

    List<Car> allCars = carRepository.findAll();

    assert !allCars.isEmpty();
    assert allCars.get(0).getDescription().equalsIgnoreCase("New car");
    assert allCars.size() == 1;
  }



}

