package com.example.carRent.Car;

import com.example.carRent.Car.Mark.Mark;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private BigDecimal price;
    private LocalDateTime startRent;
    private LocalDateTime endRent;
    private boolean available;
    @ManyToOne()
    private Mark mark;

    public Car() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getStartRent() {
        return startRent;
    }

    public void setStartRent(LocalDateTime startRent) {
        this.startRent = startRent;
    }

    public LocalDateTime getEndRent() {
        return endRent;
    }

    public void setEndRent(LocalDateTime endRent) {
        this.endRent = endRent;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }


}
