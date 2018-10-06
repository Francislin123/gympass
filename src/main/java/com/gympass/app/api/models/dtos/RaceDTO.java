package com.gympass.app.api.models.dtos;

import com.gympass.app.api.models.LapRecord;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Duration;

/**
 * Created by Francislin Dos Reis on 06/10/18.
 */
@Data
public class RaceDTO {

    private LapRecord lapRecord;
    private Duration totalDuration;
    private LapRecordDTO bestLap;
    private BigDecimal totalAverageSpeed;
    private Duration delayAfterWinner;

    public RaceDTO(Builder builder){
        this.lapRecord = builder.lapRecord;
        this.totalDuration = builder.totalDuration;
        this.bestLap = builder.bestLap;
        this.totalAverageSpeed = builder.totalAverageSpeed;
        this.delayAfterWinner = builder.delayAfterWinner;
    }

    public static class Builder{
        private LapRecord lapRecord;
        private Duration totalDuration;
        private LapRecordDTO bestLap;
        private BigDecimal totalAverageSpeed;
        private Duration delayAfterWinner;

        public Builder withLapRecord (LapRecord lapRecord){
            this.lapRecord = lapRecord;
            return this;
        }

        public Builder withTotalDuration(Duration totalDuration){
            this.totalDuration = totalDuration;
            return this;
        }

        public Builder withBestLap(LapRecordDTO bestLap) {
            this.bestLap = bestLap;
            return this;
        }

        public Builder withTotalAverageSpeed(BigDecimal totalAverageSpeed){
            this.totalAverageSpeed = totalAverageSpeed;
            return this;
        }

        public Builder withDelayAfterWinner(Duration delayAfterWinner){
            this.delayAfterWinner = delayAfterWinner;
            return this;
        }

        public RaceDTO build(){
            return new RaceDTO(this);
        }
    }
}
