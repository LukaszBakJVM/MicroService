package com.example.carRent.Car;

import java.time.LocalDateTime;

public record DtoRent(long id, LocalDateTime startRent, LocalDateTime endRent) {
}
