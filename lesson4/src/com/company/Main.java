package com.company;

public class Main {

    public static void main(String[] args) {
        /*
        1) Инкапсуляция
        Известна только часть методов, свойств, часть недоступна
        Реализуется при помощи private, public, protected. Ставится перед объявлением свойства.
        private int age; закрытый метод или свойство
        (public) int age; открытый метод или свойство
        protected int age;
        2) Полиморфизм
        В зависимости от входного аргмента реализуется по разному
        Вызвываем одну и ту же функцию sleep, но с разными аргументами
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
        3) Наследование
        Переходят сами свойства из одной функции в другую
        public class Cat extends Animal
        Cat - дочерний класс, Animal родительский класс
        private - свойства и методы не наследуются
        public - наследуются
        protected - наследуются, мы можем переопределить метод в дочернем классе, но используются в одном пакете,
        например com.company
        @Override  - переопределение, пишется перед методом
        @Override
    public void Voice() ...
        4) Абстракция
        Идеально обстрактный код, код который можно скопировать и использовать в другом проекте
        */
        Cat cat = new Cat();
        cat.name = "Vasya";
        cat.sleep(5);
        cat.sleep(7, 43);
        cat.color = "Brown";
        cat.Voice();
        System.out.println(cat);

        // Тип String - пользовательский, пишется с заглавной буквы
        String s = "It's a disaster";
        // Приведение к нижнему регистру
        String lc = s.toLowerCase();
        System.out.println(lc);
        // Приведение к верхнему регистру
        System.out.println(s.toUpperCase());
        // Нахождение номера символа в строке с начала строки и с конца
        System.out.println(s.indexOf("a"));
        System.out.println(s.lastIndexOf("t"));
        //Обрезка строки, первое число с какого символа, второе по какой
        System.out.println(s.substring(3, 7));
        // Сравнить две строки, если регистр не важен
        if (s.equalsIgnoreCase("IT'S a DisaSter")) {
            System.out.println("Строки равны");
        }
        // Длинна строки
        s.length();
        // Метод который возвращает строку в один формат, метод вызывается не у объекта, а у класса
        // \n - переход со слова на новую строку, \b - табуляция
        String f = String.format("\nМеня \tзовут %s, я сплю %d часов","Игорь",10);
        System.out.print(f);




    }
}
