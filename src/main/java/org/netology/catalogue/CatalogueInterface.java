package org.netology.catalogue;

import org.netology.account.AccountInterface;

import java.util.Map;

public interface CatalogueInterface { // Использование принципа сегрегации интерфейсов
    void showCatalogue();

    Map<String, Integer> getCatalogue();

    void addToCatalogue(String name, int price);

    void removeFromCatalogue(String name);

    void addToBasket(AccountInterface account);
}
