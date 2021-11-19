package ru.netology.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AviaOfferTest {
    private final AviaOffer first = new AviaOffer(1, 14363, "SVO", "WAW", 140);
    private final AviaOffer second = new AviaOffer(2, 15329, "SVO", "WAW", 140);
    private final AviaOffer third = new AviaOffer(3, 18692, "SVO", "WAW", 140);
    private final AviaOffer fourth = new AviaOffer(1, 14363, "SVO", "WAW", 140);
    private final Object fifth = new Object();

    @Test
    void shouldCompareTo() {
        AviaOffer[] expected = new AviaOffer[]{first, second, third};
        AviaOffer[] actual = new AviaOffer[]{third, second, first};
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetId() {
        int expected = 1;
        int actual = first.getId();
        assertEquals(expected, actual);
    }

    @Test
    void shouldGetPrice() {
        int expected = 14363;
        int actual = first.getPrice();
        assertEquals(expected, actual);
    }

    @Test
    void shouldGetDepartureAirport() {
        String expected = "SVO";
        String actual = first.getDepartureAirport();
        assertEquals(expected, actual);
    }

    @Test
    void shouldGetArrivalAirport() {
        String expected = "WAW";
        String actual = first.getArrivalAirport();
        assertEquals(expected, actual);
    }

    @Test
    void shouldGetFlightTime() {
        int expected = 140;
        int actual = first.getFlightTime();
        assertEquals(expected, actual);
    }

    @Test
    void shouldSetId() {
        int expected = 10;
        first.setId(10);
        int actual = first.getId();
        assertEquals(expected, actual);
    }

    @Test
    void shouldSetPrice() {
        int expected = 100000;
        first.setPrice(100000);
        int actual = first.getPrice();
        assertEquals(expected, actual);
    }

    @Test
    void shouldSetDepartureAirport() {
        String expected = "VKO";
        first.setDepartureAirport("VKO");
        String actual = first.getDepartureAirport();
        assertEquals(expected, actual);
    }

    @Test
    void shouldSetArrivalAirport() {
        String expected = "KZN";
        first.setArrivalAirport("KZN");
        String actual = first.getArrivalAirport();
        assertEquals(expected, actual);
    }

    @Test
    void shouldSetFlightTime() {
        int expected = 360;
        first.setFlightTime(360);
        int actual = first.getFlightTime();
        assertEquals(expected, actual);
    }

    @Test
    void shouldTestEqualsTrue() {
        boolean actual = first.equals(fourth);
        assertTrue(actual);
    }

    @Test
    void shouldTestEqualsFalse() {
        boolean actual = first.equals(second);
        assertFalse(actual);
    }

    @Test
    void shouldCanEqual() {
        boolean actual = first.equals(fifth);
        assertFalse(actual);
    }
}