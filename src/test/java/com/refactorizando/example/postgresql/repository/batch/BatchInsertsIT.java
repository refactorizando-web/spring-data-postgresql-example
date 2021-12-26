package com.refactorizando.example.postgresql.repository.batch;

import com.refactorizando.example.postgresql.SpringDataPostgresqlExampleApplication;
import com.refactorizando.example.postgresql.entity.batch.CarBatch;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = SpringDataPostgresqlExampleApplication.class)
public class BatchInsertsIT {

  @PersistenceContext
  private EntityManager entityManager;

  @Autowired
  private CarBatchRepository carBatchRepository;

  @Test
  @Transactional
  public void whenInsertACarLoop_thenSaveCarsInBatch() {

    for (int i = 0; i < 10; i++) {

      CarBatch car = createCar(i);

      entityManager.persist(car);
    }

    carBatchRepository.findAll();
  }

  @Test
  @Transactional
  public void whenInsertACarLoop_thenSaveCarwithRepositoryInBatch() {

    for (int i = 0; i < 10; i++) {

      CarBatch car = createCar(i);

      carBatchRepository.save(car);
    }

    carBatchRepository.findAll();
  }

  private static CarBatch createCar(int index) {
    CarBatch car = new CarBatch();
    car.setModel("Mustang " + (index + 1));

    return car;
  }

}
