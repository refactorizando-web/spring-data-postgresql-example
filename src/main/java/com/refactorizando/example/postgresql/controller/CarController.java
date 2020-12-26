package com.refactorizando.example.postgresql.controller;

import com.refactorizando.example.postgresql.entity.Car;
import com.refactorizando.example.postgresql.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carservice;

    @GetMapping()
    public ResponseEntity<List<Car>> getAllcars() {

        return new ResponseEntity<>(carservice.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable("id") String id) {

        return new ResponseEntity<>(carservice.findById(UUID.fromString(id)), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Car> createCar(@RequestBody Car car) {

        return new ResponseEntity<>(carservice.saveCar(car), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable("id") String id, @RequestBody Car car) {

        if (carservice.existById(UUID.fromString(id))) {
            return new ResponseEntity<>(carservice.saveCar(car), HttpStatus.ACCEPTED);
        }

        throw new IllegalArgumentException("Car with id " + id + "not found");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCar(@PathVariable("id") String id) {

        carservice.deleteCar(UUID.fromString(id));

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
