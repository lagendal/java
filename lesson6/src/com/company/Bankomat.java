package com.company;

import java.util.Scanner;

public class Bankomat {

    public static boolean checkPin(String pin){
        try {
            BankService.confirmPin(pin);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static void showMainMenu() {

        Scanner s = new Scanner(System.in);
        System.out.println("Добро пожаловать.");
        while (true) {
            System.out.println("1. Вставить карточку ");
            System.out.println("2. Услуги банка ");
            System.out.print("Ваш выбор: ");
            int choice;
            try {
                choice = s.nextInt();
            } catch (Exception e) {
                System.out.println("Неверный выбор, повторите попытку");
                s.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("Введите пин-код: ");
                    String pin = s.next();
                    s.nextLine();
                    if (checkPin(pin)){
                        showCardActionsMenu();
                        return;
                    }
                case 2:
                showBankServicesMenu();
                return;
                default:
                    System.out.println("Неверный выбор, повторите попытку");
            }
        }
    }

    public static void showCardActionsMenu() {

        Scanner s = new Scanner(System.in);
        int choice = 0;
        while (true) {
            if (choice == 0) {
                System.out.println("1. Баланс ");
                System.out.println("2. Выдача наличных ");
                System.out.println("3. Назад ");
                System.out.print("Ваш выбор: ");
                try {
                    choice = s.nextInt();
                    s.nextLine();
                } catch (Exception e) {
                    System.out.println("Неверный выбор, повторите попытку");
                    s.nextLine();
                    continue;
                }
            }

            switch (choice) {
                case 1:
                    int balance;
                    balance = BankService.getBalance();
                    System.out.print("Ваш баланс составляет");
                    System.out.print(balance);
                    break;
                case 2:
                   System.out.println("Введите сумму: ");
                        int sum;
                        try {
                            sum = s.nextInt();
                        } catch (Exception e) {
                            System.out.println("Некоректная сумма");
                            s.nextLine();
                            continue;
                        }

                    try {
                        BankService.getCash(sum);
                        System.out.println("Ваш баланс: ");
                        System.out.println(BankService.getBalance());
                    } catch (Exception e) {
                            System.out.println(e.getMessage());
                            break;
                    }

                case 3:
                    showMainMenu();
                    return;

                default:
                    System.out.println("Неверный выбор, повторите попытку");
            }

            choice = 0;
        }


    }

    public static void showBankServicesMenu(){
        System.out.println("123");
        System.out.println("Для возврата нажмите любую кнопку");
        Scanner s = new Scanner(System.in);
        s.next();
        showMainMenu();
    }
}