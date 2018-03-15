package com.company;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
	/*
	this - указатель на объект
	this.name = name;
	super - указатель на родительский объект, метод
	setName(String);
	@Override
	void setName(String name){
	super.setName(name);

	}

	 */
        // Клоннирование, как скопировать перебором методов
        User u1 = new User("user", "user@mail.ru");
        User u2 = new User(u1);
        System.out.println(u2.login + " " + u2.name);
        //Использование интерфейса Cloneable
        User u3 = null;
        u1.message = new Message();
        u1.message.text = "Hello";
        u1.message.time = new Date();
        try {
            u3 = u1.clone();
        } catch (CloneNotSupportedException e) {

        }

        System.out.println(u3.login + " " + u3.name + " " + u3.message.text);

    }
}


