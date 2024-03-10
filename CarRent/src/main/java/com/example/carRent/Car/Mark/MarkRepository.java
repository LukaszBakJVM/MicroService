package com.example.carRent.Car.Mark;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MarkRepository extends JpaRepository<Mark, Long> {
    Optional<Mark> findByMarkAndModel(String mark, String model);

}
