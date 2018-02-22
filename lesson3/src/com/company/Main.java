package com.company;

import java.net.UnknownServiceException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
       /* Вискосный год или нет
       Scanner s = new
                Scanner (System.in);
        System.out.println("Введите год");
        double year = s.nextDouble();
        if ((year%4==0 && year%100!=0) || year%400==0){
        System.out.println("Високосный");} else{
            System.out.println("Невисокосный");
        }; */

 /*
  Массивы
 float ages [] = new float[5]; Создаем массив c 5 подпеременными типа float
 ages [0] = 12; Записывает в первую ячейку и работаем как с переменной
 ages [4] = 25;
 float avg = (ages[0] + ages[4])/2; Находим среднее значение между первой и последней ячейкой
  */
        float ages [] = new float[5];
        ages [0] = 12.f;
        ages [1] = 33.f;
        ages [2] = 45.f;
        ages [3] = 1.f;
        ages [4] = 7.f;
        /*
        float avg = (ages[0] + ages[1] + ages[2] + ages[3] + ages[4])/5;
        System.out.print("Среднее значение = "); Тупо и иррационально
        System.out.print(avg);
        */
        float sum = 0;
        for (int i=0; i<ages.length; i=i+1) {
            sum = sum + ages[i];
        }
        float avg = sum / ages.length;
        System.out.print("Среднее значение = ");
        System.out.print(avg);

        /*
        String fruits[] = {"Apple", "Orange", "Lemon", "Banana"}; Создается одномерный массив с тем количесвом
        переменных,которые мы ввели, меньше кода
        System.out.println(Arrays.toString(fruits)); Выводит на экран массив и преобразует его в строки
         */

        /*
        int matrix [][] = new int[][]; Создается двумерный массив, сначала строки, затем столбцы
       matrix [0][1] = 10; Задаем и обращаемся к переменной первой строки второго столбца
       int matrix [][] = {{1,2,5},{2,3,6]} Инициализация двумерного массива, создали массив с 2 строками и 3 столбцами,
        заполняется по строкам сверху вниз
         */
        /*
        Классы
        class User {
        int age;
        string name;
        bollean male;
        } Описываем свойства и методы класса
        void не возвращает функцию, не будет результата

        class User {
            void Say(){
                System.out.println("Hi!");
            }
        }
        */
        User u1 = new User();
        u1.age = 23;
        u1.name = "Igor";
        u1.male = true;
        u1.Say();
        u1.WhatIsYourName();
        User u2 = new User();
        u2.name = "Sasha";
        u2.WhatIsYourName();
        }
            }


