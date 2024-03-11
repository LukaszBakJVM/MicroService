package org.example.rent.Rent;

import java.util.List;

public record FindAllCars(long clientId, List<Long>allCars) {
}
