package org.example.rent.Rent;

import java.math.BigDecimal;

public record RentDto(long carId, long clientId, BigDecimal price ) {
}
