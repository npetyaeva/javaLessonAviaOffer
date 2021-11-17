package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AviaOffer implements Comparable<AviaOffer> {
    private int id;
    private int price;
    private String departureAirport;
    private String arrivalAirport;
    private int flightTime;

    @Override
    public int compareTo(AviaOffer o) {
        AviaOffer aviaOffer = (AviaOffer) o;
        return this.price - aviaOffer.price;
    }
}
