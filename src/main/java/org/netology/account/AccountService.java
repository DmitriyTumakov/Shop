package org.netology.account;

import java.util.*;

// Использование принципа единственной ответственности
public class AccountService implements AccountInterface { // Использование принципа открытости/закрытости
    private static Scanner scanner = new Scanner(System.in);
    private String name;
    private int password;
    private List<String> basket = new ArrayList<>();
    private int basketPrice = 0;

    public AccountService(String name, int password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public void showBasket() {
        System.out.printf("Ваша корзина: %s\n", getBasket().toString());
        System.out.printf("Сумма: %d\n", basketPrice);
    }

    @Override
    public AccountInterface auth(AccountList accounts) {
        System.out.print("Введите имя пользователя: ");
        String name = scanner.next();
        if (accounts.exists(name)) {
            System.out.print("Введите пароль: ");
            int password = scanner.nextInt();
            if (accounts.passwordCorrect(name, password)) {
                System.out.printf("Вы вошли как %s.\n", name);
                return accounts.getAccount(name);
            } else {
                System.out.println("Неверный пароль.");
            }
        } else {
            System.out.println("Данный аккаунт не существует.");
        }
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<String> getBasket() {
        return basket;
    }

    public int getPassword() {
        return password;
    }

    @Override
    public int getBasketPrice() {
        return basketPrice;
    }

    @Override
    public void setBasketPrice(int basketPrice) {
        this.basketPrice = basketPrice;
    }
}
