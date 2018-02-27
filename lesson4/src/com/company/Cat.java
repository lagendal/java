package com.company;

public class Cat extends Animal {
    public String name;
    private int age;
    public void sleep(int h){
        System.out.print("Кот заснул на ");
        System.out.print(h);
        System.out.print(" Часов");
    }
    public void sleep(int h, int m){
        System.out.print(" Кот заснул на ");
        System.out.print(h);
        System.out.print(" Часов ");
        System.out.print(m);
        System.out.print(" Минут");

    }
    @Override
    public void Voice() {
        System.out.println(" Мяу");
    }
}
