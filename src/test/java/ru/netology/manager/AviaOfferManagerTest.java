package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import ru.netology.domain.AviaOffer;
import ru.netology.domain.AviaOfferByPriceAscComparator;
import ru.netology.repository.AviaOfferRepository;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

class AviaOfferManagerTest {
/*    @Mock
    AviaOfferRepository repository = Mockito.mock(AviaOfferRepository.class);
    @InjectMocks
    private AviaOfferManager aviaOfferManager= new AviaOfferManager(repository);*/

    private final AviaOfferRepository repository = new AviaOfferRepository();
    private final AviaOfferManager aviaOfferManager = new AviaOfferManager(repository);

    private final AviaOffer first = new AviaOffer(1, 14363, "SVO", "WAW", 140);
    private final AviaOffer second = new AviaOffer(2, 15329, "SVO", "WAW", 140);
    private final AviaOffer third = new AviaOffer(3, 18692, "SVO", "WAW", 140);
    private final AviaOffer fourth = new AviaOffer(4, 14363, "WAW", "SVO", 140);
    private final AviaOffer fifth = new AviaOffer(5, 10000, "SVO", "WAW", 100);

    @BeforeEach
    public void setUp() {
        aviaOfferManager.add(first);
        aviaOfferManager.add(second);
        aviaOfferManager.add(third);
    }

    @Test
    void shouldGetAll() {
        AviaOffer[] expected = new AviaOffer[] { first, second, third };
        AviaOffer[] actual = aviaOfferManager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAdd() {
        AviaOffer[] expected = new AviaOffer[] { first, second, third, fourth };
        aviaOfferManager.add(fourth);
        AviaOffer[] actual = aviaOfferManager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindSameAirportsExist() {
        aviaOfferManager.add(fourth);
        AviaOffer[] expected = new AviaOffer[] { fourth };
        AviaOffer[] actual = aviaOfferManager.findSameAirports("WAW", "SVO");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindSameAirportsExistSort() {
        aviaOfferManager.add(fifth);
        AviaOffer[] expected = new AviaOffer[] { fifth, first, second, third };
        AviaOffer[] actual = aviaOfferManager.findSameAirports("SVO", "WAW");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindSameAirportsNotExist() {
        AviaOffer[] actual = aviaOfferManager.findSameAirports("WAW", "WAW");
        assertNull(actual);
    }

    @Test
    void shouldSearchByExist() {
        aviaOfferManager.add(fourth);
        AviaOffer[] expected = new AviaOffer[] { first, fourth, second, third };
        AviaOffer[] actual = aviaOfferManager.searchBy("WAW");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNotExist() {
        AviaOffer[] actual = aviaOfferManager.searchBy("VKO");
        assertNull(actual);
    }

    @Test
    void shouldFindSameAirportsComparator() {
        aviaOfferManager.add(fourth);
        aviaOfferManager.add(fifth);
        AviaOffer[] expected = new AviaOffer[] { fifth, first, second, third };
        AviaOffer[] actual = aviaOfferManager.findSameAirportsComparator("SVO", "WAW");
        assertArrayEquals(expected, actual);
    }
}