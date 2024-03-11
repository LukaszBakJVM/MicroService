package org.example.rent.Rent;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentRepository extends JpaRepository<Rent,Long> {
    List<Rent>findAllByCarId(long id);
    List<Rent>findAllByClientId(long id);
}
