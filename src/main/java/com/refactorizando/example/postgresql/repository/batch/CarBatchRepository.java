package com.refactorizando.example.postgresql.repository.batch;

import com.refactorizando.example.postgresql.entity.batch.CarBatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarBatchRepository extends JpaRepository<CarBatch, Long> {

}
