package tech.szymanskazdrzalik.fuzzy.dao;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccidentDTO {
    @JsonProperty("ID")
    private String ID;
    @JsonProperty("Severity")
    private Integer severity;
    @JsonProperty("Start_Time")
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    private Timestamp startTime;

    @JsonProperty("End_Time")
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    private Timestamp endTime;

    @JsonProperty("Distance(mi)")
    private Double distance;

    @JsonProperty("Temperature(F)")
    private Double temperature;

    @JsonProperty("Wind_Chill(F)")
    private Double windChill;

    @JsonProperty("Humidity(%)")
    private Double humidity;

    @JsonProperty("Pressure(in)")
    private Double pressure;

    @JsonProperty("Visibility(mi)")
    private Double visibility;

    @JsonProperty("Wind_Speed(mph)")
    private Double windSpeed;
    @JsonProperty("Precipitation(in)")
    private Double precipitation;

    public AccidentDTO() {
    }

    public AccidentDTO(
            String ID,
            Integer severity,
            Timestamp startTime,
            Timestamp endTime,
            Double distance,
            Double temperature,
            Double windChill,
            Double humidity,
            Double pressure,
            Double visibility,
            Double windSpeed,
            Double precipitation) {
        this.ID = ID;
        this.severity = severity;
        this.startTime = startTime;
        this.endTime = endTime;
        this.distance = distance;
        this.temperature = temperature;
        this.windChill = windChill;
        this.humidity = humidity;
        this.pressure = pressure;
        this.visibility = visibility;
        this.windSpeed = windSpeed;
        this.precipitation = precipitation;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Integer getSeverity() {
        return severity;
    }

    public void setSeverity(Integer severity) {
        this.severity = severity;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getWindChill() {
        return windChill;
    }

    public void setWindChill(Double windChill) {
        this.windChill = windChill;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Double getVisibility() {
        return visibility;
    }

    public void setVisibility(Double visibility) {
        this.visibility = visibility;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(Double precipitation) {
        this.precipitation = precipitation;
    }


}
