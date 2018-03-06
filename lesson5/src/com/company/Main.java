package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /* Метод toString,Выводит тоже самое при u и u.toString
        @Override
    public String toString(){
        String userInfo = String.format("User id: %d, login %s",id,login);
        return userInfo;
         */
	User u = new User();
        u.id = 1;
        u.login = "user@mail.ru";
	System.out.println(u);
	/* Метод iquals
	@Override
    public boolean equals (Object obj) {
        User user = (User) obj;
        if (user.id == id && user.login == login) {
            return true;
        }
        return false;
        Если проще
        User user = (User) obj;
        return user.id == id && user.login == login;
        Возвращает сразу true или false
    }
	 */
        User u2 = new User();
        u2.id = 1;
        u2.login = "user@mail.ru";
        if (u.equals(u2)){
            System.out.println("u = u2");
        } else {
            System.out.println("u != u2");
        }
        if (u == u2) {
            System.out.println("u == u2");
        } else {
                System.out.println("u != u2");
            }

        /* java выдяляет память под объекты только при использваонии new
        меняя значения объектов, он мофицирует только одну часть памяти
        User u3 = u2;
        u3.id = 2
        */

        User u3 = new User();
        u3.id = 2;
        u3.login = u2.login;
        System.out.println(u2);
        System.out.println(u3);

        //Конструктор - метод который срабатывает при вызове его
        User u4 = new User(4,"lagendal");
        System.out.println(u4);

        /* Исключения - Exception
        int a = 10/0;

        try {
             Исключительная ситуация
        }
        catch (ArithmeticException e1){
        }
        catch (ArrayIndexOutOfBoundsException e2){
        }
        catch (Exception e3){
        }
        */
        Scanner s = new Scanner(System.in);
        while (true){
            System.out.println("Введите целое число");
            try {
                s.nextInt();
                System.out.println("Ура");
                break;
                }
                catch(Exception e) {
                    System.out.println("Неверный ввод, повторите попытку");
                    System.out.println(e.getLocalizedMessage());
                    s.nextLine();
                }
            }

        }
    }







