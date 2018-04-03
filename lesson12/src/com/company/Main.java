package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
	/* Коллекция позволяет хранить любое количество элементов
	ArrayList - массив в виде списка
	ArrayList < тип данных указываем >
	Integer, Float, Boolean
	a.parseInt("10.5") преобразовывает строку в число
	ArrayList < Integer > list = new ArrayList < Integer > ( );
	HashMap - словари, где значения хранятся в виде ключ: значение (key1: )
	HashMap < String, Integer > значение ключей, сами значения


	 */
        ArrayList list = new ArrayList < Integer > ();
        list.add(20);
        list.add(33);
        list.add(55);
        list.add(77);

        //list.get(2);
        Integer a = 33;
        list.remove(0);
        list.remove(a);
        list.set(1,88);
        System.out.println(list);

        HashMap contacts = new HashMap < Integer, String >();
        contacts.put(253595, "Василий Петрович");
        contacts.put(221133, "Антон Николаевич");
        contacts.put(724061, "Мария Александровна");
        System.out.println(contacts);
        System.out.println(contacts.get(221133));
        contacts.remove(253595);





    }
}
