package ru.netology.domain;

import java.util.Comparator;

public class AviaOfferByPriceAscComparator implements Comparator<AviaOffer> {
    @Override
    public int compare(AviaOffer o1, AviaOffer o2) {
        return o1.getPrice() - o2.getPrice();
    }
}
