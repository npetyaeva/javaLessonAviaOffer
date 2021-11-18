package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.AviaOffer;

import static org.junit.jupiter.api.Assertions.*;

class AviaOfferRepositoryTest {
    private AviaOfferRepository repository = new AviaOfferRepository();

    private final AviaOffer emptyItem = new AviaOffer();
    private final AviaOffer first = new AviaOffer(1, 14363, "SVO", "WAW", 140);
    private final AviaOffer second = new AviaOffer(2, 15329, "SVO", "WAW", 140);
    private final AviaOffer third = new AviaOffer(3, 18692, "SVO", "WAW", 140);
    private final AviaOffer fourth = new AviaOffer(1, 14363, "SVO", "WAW", 140);

    @Test
    void shouldSaveNoArg() {
        AviaOffer[] expected = { emptyItem };
        repository.save(emptyItem);
        AviaOffer[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSaveAllArg() {
        AviaOffer[] expected = { first };
        repository.save(first);
        AviaOffer[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAllEmptyRepo() {
        AviaOffer[] expected = {};
        AviaOffer[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAll() {
        AviaOffer[] expected = { first, second, third };
        repository.save(first);
        repository.save(second);
        repository.save(third);
        AviaOffer[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindByIdItemExists() {
        AviaOffer expected = second;
        repository.save(first);
        repository.save(second);
        repository.save(third);
        AviaOffer actual = repository.findById(2);
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindByIdItemNotExists() {
        AviaOffer expected = null;
        repository.save(first);
        repository.save(second);
        repository.save(third);
        AviaOffer actual = repository.findById(10);
        assertEquals(expected, actual);
    }

    @Test
    void shouldRemoveByIdItemExists() {
        AviaOffer[] expected = { first, second };
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.removeById(3);
        AviaOffer[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveByIdItemNotExists() {
        AviaOffer[] expected = { first, second, third };
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.removeById(-10);
        AviaOffer[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}