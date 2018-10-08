package com.gympass.app.api.models.dtos;

import lombok.Data;

/**
 * Created by Francislin Dos Reis on 06/10/18.
 */
@Data
public class PositionDTO {

    private int position;
    private String driverId;
    private String driverName;
    private String completedLaps;
    private String totalDuration;
    private String totalAverageSpeed;
    private LapRecordDTO bestLap;

    public PositionDTO(Builder builder) {
        this.position = builder.position;
        this.driverId = builder.driverId;
        this.driverName = builder.driverName;
        this.completedLaps = builder.completedLaps;
        this.totalDuration = builder.totalDuration;
        this.bestLap = builder.bestLap;
        this.totalAverageSpeed = builder.totalAverageSpeed;
    }

    public static class Builder {
        private int position;
        private String driverId;
        private String driverName;
        private String completedLaps;
        private String totalDuration;
        private LapRecordDTO bestLap;
        private String totalAverageSpeed;

        public Builder withPosition(int position) {
            this.position = position;
            return this;
        }

        public Builder withDriverId(String driverId) {
            this.driverId = driverId;
            return this;
        }

        public Builder withDriverName(String driverName) {
            this.driverName = driverName;
            return this;
        }

        public Builder withCompletedLaps(String completedLaps) {
            this.completedLaps = completedLaps;
            return this;
        }

        public Builder withTotalDuration(String totalDuration) {
            this.totalDuration = totalDuration;
            return this;
        }

        public Builder withTotalAverageSpeed(String totalAverageSpeed) {
            this.totalAverageSpeed = totalAverageSpeed;
            return this;
        }

        public Builder withBestLap(LapRecordDTO bestLap) {
            this.bestLap = bestLap;
            return this;
        }

        public PositionDTO build() {
            return new PositionDTO(this);
        }
    }
}
