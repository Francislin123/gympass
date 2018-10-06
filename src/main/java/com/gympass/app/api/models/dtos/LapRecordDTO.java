package com.gympass.app.api.models.dtos;

import lombok.Data;

/**
 * Created by Francislin Dos Reis on 06/10/18.
 */
@Data
public class LapRecordDTO {

    private String hour;
    private String driverId;
    private String driverName;
    private String lapNumber;
    private String lapDuration;
    private String averageLapSpeed;

    private LapRecordDTO(Builder builder){

        this.hour = builder.hour;
        this.driverId = builder.driverId;
        this.driverName = builder.driverName;
        this.lapNumber = builder.lapNumber;
        this.lapDuration = builder.lapDuration;
        this.averageLapSpeed = builder.averageLapSpeed;
    }

    public static class Builder{

        private String hour;
        private String driverId;
        private String driverName;
        private String lapNumber;
        private String lapDuration;
        private String averageLapSpeed;

        public Builder(){}

        public Builder withHour(String hour){
            this.hour = hour;
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

        public Builder withLapNumber(String lapNumber){
            this.lapNumber = lapNumber;
            return this;
        }

        public Builder withlapDuration(String lapDuration){
            this.lapDuration = lapDuration;
            return this;
        }

        public Builder withAverageLapSpeed(String averageLapSpeed){
            this.averageLapSpeed = averageLapSpeed;
            return this;
        }

        public LapRecordDTO build(){
            return new LapRecordDTO(this);
        }
    }
}
