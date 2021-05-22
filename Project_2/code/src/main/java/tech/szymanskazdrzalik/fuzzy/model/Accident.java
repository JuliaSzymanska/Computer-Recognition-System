package tech.szymanskazdrzalik.fuzzy.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import tech.szymanskazdrzalik.fuzzy.dao.AccidentDTO;

import java.sql.Timestamp;

public class Accident {
    private String ID;
    private Timestamp startTime;
    private Timestamp endTime;
    private Integer severity;
    private Double distance;
    private Double temperature;
    private Double windChill;
    private Double humidity;
    private Double pressure;
    private Double visibility;
    private Double windSpeed;
    private Double precipitation;

    public Accident(
            String id,
            Timestamp startTime,
            Timestamp endTime,
            Integer severity,
            Double distance,
            Double temperature,
            Double windChill,
            Double humidity,
            Double pressure,
            Double visibility,
            Double windSpeed,
            Double precipitation) {
        this.ID = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.severity = severity;
        this.distance = distance;
        this.temperature = temperature;
        this.windChill = windChill;
        this.humidity = humidity;
        this.pressure = pressure;
        this.visibility = visibility;
        this.windSpeed = windSpeed;
        this.precipitation = precipitation;
    }

    public Accident(AccidentDTO accidentDTO) {
        this.ID = accidentDTO.getID();
        this.startTime = accidentDTO.getStartTime();
        this.endTime = accidentDTO.getEndTime();
        this.severity = accidentDTO.getSeverity();
        this.distance = accidentDTO.getDistance();
        this.temperature = accidentDTO.getTemperature();
        this.windChill = accidentDTO.getWindChill();
        this.humidity = accidentDTO.getHumidity();
        this.pressure = accidentDTO.getPressure();
        this.visibility = accidentDTO.getVisibility();
        this.windSpeed = accidentDTO.getWindSpeed();
        this.precipitation = accidentDTO.getPrecipitation();
    }

    public Accident() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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

    public Integer getSeverity() {
        return severity;
    }

    public void setSeverity(Integer severity) {
        this.severity = severity;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("ID", ID)
                .append("startTime", startTime)
                .append("endTime", endTime)
                .append("severity", severity)
                .append("distance", distance)
                .append("temperature", temperature)
                .append("windChill", windChill)
                .append("humidity", humidity)
                .append("pressure", pressure)
                .append("visibility", visibility)
                .append("windSpeed", windSpeed)
                .append("precipitation", precipitation)
                .toString();
    }

    public Double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(Double precipitation) {
        this.precipitation = precipitation;
    }
}
