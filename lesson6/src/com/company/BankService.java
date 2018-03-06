package com.company;

public class BankService {
    public static void confirmPin(String pin) throws Exception {
        if (!pin.equals("1234")){
            throw new Exception("Неверный пин-код");
        }
    }
    public static int balance = 10000;
    public static int getBalance() {
        return balance;
    }

    public static void getCash(int sum) throws Exception {
        if (sum > balance){
            throw new Exception("Недостаточно средств");
        }
        balance -= sum; //balance == balance - sum.
    }
}

