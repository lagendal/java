package com.company11;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        /* int age = 15;
        if (age >= 16){
            System.out.println ("Вы можете получить права");
        }
        else {
            System.out.println("Не можете сдать на права");
        }
    } */
        int month = 13;
        switch (month) {
            case 1:
                System.out.println("Январь");
                break;
            case 2:
                System.out.println("Февраль");
                break;
            case 3:
                System.out.println("Март");
                break;
            case 4:
                System.out.println("Апрель");
                break;
            case 5:
                System.out.println("Май");
                break;
            case 6:
                System.out.println("Июнь");
                break;
            case 7:
                System.out.println("Июль");
                break;
            case 8:
                System.out.println("Август");
                break;
            case 9:
                System.out.println("Сентябрь");
                break;
            case 10:
                System.out.println("Октябрь");
                break;
            case 11:
                System.out.println("Ноябрь");
                break;
            case 12:
                System.out.println("Декабрь");
                break;
                  default:
                    System.out.println("Нет такого месяца");
                    break;

        }
      /*  int i=0;
        while (i<10){
            i = i+1;
            System.out.println(i);
            if (i==5){
                break;
            }
             }*/

            int a=11;
            do {
                System.out.println("Бред");
            }
            while (a<7);
            for (int i=0;i<10;i=i+1){
                System.out.println(i*i);
            }
        // чтение данных
        Scanner s = new
                Scanner (System.in);
            System.out.println("Введите рост в метрах");
            float height = s.nextFloat();
            System.out.print ("Рост в дюймах: ");
            System.out.println(100*height/2.54);

        Scanner s = new
                Scanner (System.in);
        System.out.println("Введите год");
        int year = s();

        if (s%4=0)

        float usd=convertBYNtoUSD (10.5f);
        System.out.println(usd);
    }
    static float convertBYNtoUSD
            (float sum){
        float usd=sum/1.96f;
        return usd;
    }

    }



