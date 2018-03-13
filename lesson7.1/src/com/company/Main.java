package com.company;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {
        int a = 1;
        int b = a++ + ++a + a++;
        System.out.println(b);
        System.out.println(a);

        /*
        Внутренний класс описывается внутри другого класса и должен быть статическим
        public static
         */
        /* тип данных перечисление, хранят в отдельном файле java
        enum Month {
        January,
        February,


        }
        Month m = Month.July;
        если в кейсе сравниваем
        switch(m){
        case Month.January;
        case Month.February;
        }

         */
        /*
        для работы с датами
        Date, Calendar, GregorianCalendar
         */
        Date d = new Date();
        System.out.println(d.getTime());
        Calendar c = Calendar.getInstance();
        System.out.println(c.get(Calendar.DAY_OF_YEAR));
        c.set(Calendar.MONTH,6);
        System.out.println(c.get(Calendar.MONTH));
        c.add(Calendar.YEAR,10);
        System.out.println(c.get(Calendar.YEAR));
        c.getTime();
        GregorianCalendar gc = (GregorianCalendar) GregorianCalendar.getInstance();
        if (gc.isLeapYear(2016)){
            System.out.println("Високосный");
        }
        else {
            System.out.println("Невисокосный");
        }
        DateFormat



    }
}
