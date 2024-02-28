package org.netology;


import org.netology.account.AccountList;
import org.netology.account.AccountInterface;
import org.netology.account.AccountService;
import org.netology.catalogue.CatalogueInterface;
import org.netology.catalogue.CatalogueService;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static AccountList accounts = new AccountList();
    private static AccountInterface account; // Принцип инверсии зависимостей
    private static CatalogueInterface catalogue = new CatalogueService(); // Принцип инверсии зависимостей

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в наш магазин!");
        while (true) {
            menu();
        }
    }

    private static void menu() {
        System.out.println("----------------------------------");
        System.out.println("1. Авторизация");
        System.out.println("2. Регистрация");
        System.out.println("3. Корзина");
        System.out.println("4. Каталог товаров");
        System.out.println("0. Выйти");
        int menu = scanner.nextInt();
        if (menu == 0) {
            System.exit(0);
        }
        switch (menu) {
            case 1:
                AccountInterface accountTemp = account.auth(accounts);
                if (accountTemp != null) {
                    account = accountTemp;
                }
                break;
            case 2:
                account = register(accounts);
                break;
            case 3:
                if (account != null) {
                    account.showBasket();
                } else {
                    System.out.println("Пожалуйста, авторизируйтесь, чтобы воспользоваться корзиной.");
                }
                break;
            case 4:
                catalogue.showCatalogue();
                if (account != null) {
                    catalogue.addToBasket(account);
                } else {
                    System.out.println("Пожалуйста, авторизируйтесь, чтобы воспользоваться корзиной.");
                }
                break;
            default:
                System.out.println("Простите, данная команда недоступна.");
        }
    }

    public static AccountInterface register(AccountList accounts) {
        System.out.print("Введите имя пользователя: ");
        String name = scanner.next();
        System.out.print("Введите пароль: ");
        int password = scanner.nextInt();
        accounts.addAccount(name, new AccountService(name, password));
        System.out.printf("Аккаунт %s зарегистрирован! Пожалуйста, авторизуйтесь.\n", name);
        return accounts.getAccount(name);
    }
}