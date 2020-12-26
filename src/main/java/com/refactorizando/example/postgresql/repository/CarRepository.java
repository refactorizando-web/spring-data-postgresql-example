package com.refactorizando.example.postgresql.repository;

import com.refactorizando.example.postgresql.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CarRepository extends JpaRepository<Car, UUID> {

}
