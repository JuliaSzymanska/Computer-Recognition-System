package tech.szymanskazdrzalik.fuzzy.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import tech.szymanskazdrzalik.fuzzy.dao.AccidentDTO;

import java.sql.Timestamp;

public class Wypadek {
    private String ID;
    private Timestamp czasRozpoczecia;
    private Timestamp czasZakonczenia;
    private Integer dotkliwosc;
    private Double odleglosc;
    private Double temperatura;
    private Double temperaturaOdczuwalna;
    private Double wilgotnosc;
    private Double cisnienie;
    private Double widocznosc;
    private Double predkoscWiatru;
    private Double iloscOpadow;

    public Wypadek(
            String id,
            Timestamp czasRozpoczecia,
            Timestamp czasZakonczenia,
            Integer dotkliwosc,
            Double odleglosc,
            Double temperatura,
            Double temperaturaOdczuwalna,
            Double wilgotnosc,
            Double cisnienie,
            Double widocznosc,
            Double predkoscWiatru,
            Double iloscOpadow) {
        this.ID = id;
        this.czasRozpoczecia = czasRozpoczecia;
        this.czasZakonczenia = czasZakonczenia;
        this.dotkliwosc = dotkliwosc;
        this.odleglosc = odleglosc;
        this.temperatura = temperatura;
        this.temperaturaOdczuwalna = temperaturaOdczuwalna;
        this.wilgotnosc = wilgotnosc;
        this.cisnienie = cisnienie;
        this.widocznosc = widocznosc;
        this.predkoscWiatru = predkoscWiatru;
        this.iloscOpadow = iloscOpadow;
    }

    public Wypadek(AccidentDTO accidentDTO) {
        this.ID = accidentDTO.getID();
        this.czasRozpoczecia = accidentDTO.getStartTime();
        this.czasZakonczenia = accidentDTO.getEndTime();
        this.dotkliwosc = accidentDTO.getSeverity();
        this.odleglosc = accidentDTO.getDistance();
        this.temperatura = accidentDTO.getTemperature();
        this.temperaturaOdczuwalna = accidentDTO.getWindChill();
        this.wilgotnosc = accidentDTO.getHumidity();
        this.cisnienie = accidentDTO.getPressure();
        this.widocznosc = accidentDTO.getVisibility();
        this.predkoscWiatru = accidentDTO.getWindSpeed();
        this.iloscOpadow = accidentDTO.getPrecipitation();
    }

    public Wypadek() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Timestamp getCzasRozpoczecia() {
        return czasRozpoczecia;
    }

    public void setCzasRozpoczecia(Timestamp czasRozpoczecia) {
        this.czasRozpoczecia = czasRozpoczecia;
    }

    public Timestamp getCzasZakonczenia() {
        return czasZakonczenia;
    }

    public void setCzasZakonczenia(Timestamp czasZakonczenia) {
        this.czasZakonczenia = czasZakonczenia;
    }

    public Integer getDotkliwosc() {
        return dotkliwosc;
    }

    public void setDotkliwosc(Integer dotkliwosc) {
        this.dotkliwosc = dotkliwosc;
    }

    public Double getOdleglosc() {
        return odleglosc;
    }

    public void setOdleglosc(Double odleglosc) {
        this.odleglosc = odleglosc;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public Double getTemperaturaOdczuwalna() {
        return temperaturaOdczuwalna;
    }

    public void setTemperaturaOdczuwalna(Double temperaturaOdczuwalna) {
        this.temperaturaOdczuwalna = temperaturaOdczuwalna;
    }

    public Double getWilgotnosc() {
        return wilgotnosc;
    }

    public void setWilgotnosc(Double wilgotnosc) {
        this.wilgotnosc = wilgotnosc;
    }

    public Double getCisnienie() {
        return cisnienie;
    }

    public void setCisnienie(Double cisnienie) {
        this.cisnienie = cisnienie;
    }

    public Double getWidocznosc() {
        return widocznosc;
    }

    public void setWidocznosc(Double widocznosc) {
        this.widocznosc = widocznosc;
    }

    public Double getPredkoscWiatru() {
        return predkoscWiatru;
    }

    public void setPredkoscWiatru(Double predkoscWiatru) {
        this.predkoscWiatru = predkoscWiatru;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("ID", ID)
                .append("startTime", czasRozpoczecia)
                .append("endTime", czasZakonczenia)
                .append("severity", dotkliwosc)
                .append("distance", odleglosc)
                .append("temperature", temperatura)
                .append("windChill", temperaturaOdczuwalna)
                .append("humidity", wilgotnosc)
                .append("pressure", cisnienie)
                .append("visibility", widocznosc)
                .append("windSpeed", predkoscWiatru)
                .append("precipitation", iloscOpadow)
                .toString();
    }

    public Double getIloscOpadow() {
        return iloscOpadow;
    }

    public void setIloscOpadow(Double iloscOpadow) {
        this.iloscOpadow = iloscOpadow;
    }
}
