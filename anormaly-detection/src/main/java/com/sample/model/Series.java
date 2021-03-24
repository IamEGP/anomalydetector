package com.sample.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sample.dataProcessing.Anomaly;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Series {

   @JsonIgnoreProperties( value = "timeStamp")
   private ZonedDateTime timeStamp;

   @JsonIgnoreProperties( value = "value")
   private float  value;

   public Series(String timeStamp , String value ){
      this.value = Anomaly.fromString(value).integerValue;
      LocalTime time = LocalTime.parse(timeStamp);
     this.timeStamp = ZonedDateTime.of(LocalDate.now(), time, ZoneId.systemDefault());

   }

}
