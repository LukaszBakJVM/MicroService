package com.example.carRent.Car;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findAllByAvailable(boolean available);
    List<Car>findAll();
}
