package ru.netology.manager;

import ru.netology.domain.AviaOffer;
import ru.netology.repository.AviaOfferRepository;

import java.util.Arrays;

public class AviaOfferManager {
    private final AviaOfferRepository repository;

    public AviaOfferManager(AviaOfferRepository repository) {
        this.repository = repository;
    }

    public void add(AviaOffer item) {
        repository.save(item);
    }

    public AviaOffer[] getAll() {
        return repository.findAll();
    }

    public AviaOffer[] findSameAirports(String flightFrom, String flightTo) {
        AviaOffer[] result = new AviaOffer[0];
        for (AviaOffer item : repository.findAll()) {
            if (item.matchesAirports(flightFrom, flightTo)) {
                AviaOffer[] tmp = new AviaOffer[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = item;
                result = tmp;
            }
        }
        if (result.length == 0) {
            return null;
        }
        Arrays.sort(result);
        return result;
    }

    public AviaOffer[] searchBy(String text) {
        AviaOffer[] result = new AviaOffer[0];
        for (AviaOffer item : repository.findAll()) {
            if (item.matches(text)) {
                AviaOffer[] tmp = new AviaOffer[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = item;
                result = tmp;
            }
        }
        if (result.length == 0) {
            return null;
        }
        Arrays.sort(result);
        return result;
    }
}
