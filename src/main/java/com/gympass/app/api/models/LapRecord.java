package com.gympass.app.api.models;

import lombok.Data;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

/**
 * Created by Francislin Dos Reis on 06/10/18.
 */
@Data
public class LapRecord {

    private LocalTime hour;
    private Driver driver;
    private Integer lapNumber;
    private Duration lapDuration;
    private BigDecimal averageLapSpeed;

    private LapRecord(Builder builder) {
        this.hour = builder.hour;
        this.driver = builder.driver;
        this.lapNumber = builder.lapNumber;
        this.lapDuration = builder.lapDuration;
        this.averageLapSpeed = builder.averageLapSpeed;
    }

    public static class Builder {

        private LocalTime hour;
        private Driver driver;
        private Integer lapNumber;
        private Duration lapDuration;
        private BigDecimal averageLapSpeed;

        public Builder() {
        }

        public Builder withHour(LocalTime hour) {
            this.hour = hour;
            return this;
        }

        public Builder withDriver(Driver driver) {
            this.driver = driver;
            return this;
        }

        public Builder withLapNumber(Integer lapNumber) {
            this.lapNumber = lapNumber;
            return this;
        }

        public Builder withLapDuration(Duration lapDuration) {
            this.lapDuration = lapDuration;
            return this;
        }

        public Builder withAverageLapSpeed(BigDecimal averageLapSpeed) {
            this.averageLapSpeed = averageLapSpeed;
            return this;
        }

        public LapRecord build() {
            return new LapRecord(this);
        }
    }
}
