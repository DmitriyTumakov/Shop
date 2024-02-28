package org.netology.catalogue;

import org.netology.account.AccountInterface;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Использование принципа единственной ответственности
public class CatalogueService implements CatalogueInterface { // Использование принципа открытости/закрытости
    private static final int BREAD_PRICE = 20; // Избегание магических чисел путём создания переменных
    private static final int MILK_PRICE = 35;
    private static final int COOKIE_PRICE = 34;
    private static final int MEAT_PRICE = 76;
    private static final int BUTTER_PRICE = 65;
    private static final int SUGAR_PRICE = 43;
    private Scanner scanner = new Scanner(System.in);
    private HashMap<String, Integer> catalogueMap = new HashMap<>();

    public CatalogueService() {
        addToCatalogue("ХЛЕБ", BREAD_PRICE);
        addToCatalogue("МОЛОКО", MILK_PRICE);
        addToCatalogue("ПЕЧЕНЬЕ", COOKIE_PRICE);
        addToCatalogue("МЯСО", MEAT_PRICE);
        addToCatalogue("МАСЛО", BUTTER_PRICE);
        addToCatalogue("САХАР", SUGAR_PRICE);
    }

    @Override
    public void showCatalogue() { // Использование метода DRY
        int count = 1;
        for (Map.Entry<String, Integer> entry : catalogueMap.entrySet()) {
            System.out.printf("%d. %s. Цена: %d\n", count, entry.getKey(), entry.getValue());
            count++;
        }
    }

    public void addToBasket(AccountInterface account) {
        while (true) {
            System.out.println("Чтобы добавить товар в корзину введите название товара.");
            System.out.println("Чтобы выйти в меню введите 0.");
            String catalogue = scanner.next();
            if (catalogue.equals("0")) {
                return;
            }
            if (catalogueMap.containsKey(catalogue.toUpperCase())) {
                account.getBasket().add(catalogue);
                account.setBasketPrice(account.getBasketPrice() + catalogueMap.get(catalogue.toUpperCase()));
            } else {
                System.out.println("Извините, такого товара не существует.");
            }
            showCatalogue(); // Использование метода DRY
        }
    }

    @Override
    public Map<String, Integer> getCatalogue() {
        return catalogueMap;
    }

    @Override
    public void addToCatalogue(String name, int price) {
        if (price > 0) {
            catalogueMap.put(name, price);
        }
    }

    @Override
    public void removeFromCatalogue(String name) {
        if (catalogueMap.containsKey(name)) {
            catalogueMap.remove(name);
        }
    }
}
