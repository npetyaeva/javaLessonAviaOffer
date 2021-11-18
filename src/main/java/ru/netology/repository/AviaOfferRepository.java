package ru.netology.repository;

import ru.netology.domain.AviaOffer;

public class AviaOfferRepository {
    AviaOffer[] items = new AviaOffer[0];

    public void save(AviaOffer item) {
        int length = items.length + 1;
        AviaOffer[] tmp = new AviaOffer[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        tmp[length - 1] = item;
        items = tmp;
    }

    public AviaOffer[] findAll() {
        return items;
    }

    public AviaOffer findById(int id) {
        for (AviaOffer item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) {
        AviaOffer itemExists = findById(id);
        if (itemExists != null) {
            int length = items.length - 1;
            AviaOffer[] tmp = new AviaOffer[length];
            int index = 0;
            for (AviaOffer item : items) {
                if (item.getId() != id) {
                    tmp[index] = item;
                    index++;
                }
            }
            items = tmp;
        }
    }
}
