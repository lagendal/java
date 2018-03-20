package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {
	/*
	Работа с файлами
	File - можем записать путь к файлу, так и к каталогу
	File f = newFile("1.txt");
	Есть абсолютный путь и относительный
	Абсолютный - мы точно знаем где файл, а относительный - относительно нашего исполняемого файла
	С:\\windows\\users\\
	          \\users\\public
	 */
        File f = new File("1.txt");
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (f.isHidden()) {
            System.out.println("Скрытый файл");
        } else {
            System.out.println("Нескрытый файл");
        }
        f.setWritable(true);
        if (!f.canWrite()) {
            System.out.println("Только для чтения файл");
        }
        f.setLastModified(0);
        System.out.println(f.lastModified());
        f.delete();
        f.renameTo(new File("123.txt"));
        // Cоздаем папку с путем
        File dir = new File("test\\");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String files[] = dir.list();

        for (int i = 0; i < files.length; i++){
            System.out.println(files[i]);
        }

        try {
            PrintWriter pw = new PrintWriter("123.txt","UTF-8");
            pw.write("Hello, bratan, po chem semki?");
            pw.append("!!!");
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        //Рекурсия - вывод метода внутри себя

        /*int fact(int n){
            if (n<=1){
                return 1;
                return * n*fact(n-1);
            }
        }
        */
        //Создать массив типа файл, dir это каталог и должен быть еще каталог с файлами,
        // вывести все файлы которые есть в папке
        // делается через рекурссию
        //Проверить явлется ли объект папкой или файлом, .isFile(), isDirectory();
        File files[] = dir.listFiles();
    }
}
