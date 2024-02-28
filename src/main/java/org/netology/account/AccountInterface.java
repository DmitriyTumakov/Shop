package org.netology.account;

import java.util.List;

public interface AccountInterface { // Использование принципа сегрегации интерфейсов
    AccountInterface auth(AccountList accounts);

    void showBasket();

    String getName();

    List<String> getBasket();

    int getBasketPrice();

    void setBasketPrice(int i);

    int getPassword();
}
