package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
	/* Сериализация - прочитать в памяти и вывыести на экран
	implements Serializable
	объект отвечающий за сериализацию
	FileOutputStream
	 */
	//Сериализация
	Settings s = new Settings();
	s.posX = 200;
	s.posY = 200;
	s.fullScreen = false;
	User u = new User();
	u.name = "lagendal";
	u.avatar = "img/1.png";
	System.out.println(s);
	System.out.println(u);
	FileOutputStream fos = new FileOutputStream("app.bin");
	ObjectOutputStream oos = new ObjectOutputStream(fos);
	oos.writeObject(s);
	oos.writeObject(u);
	oos.close();
	fos.close();
	//Десириализация
		FileInputStream fis = new FileInputStream("app.bin");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Settings s1 = (Settings) ois.readObject();
		User u1 = (User) ois.readObject();
		ois.close();
		fis.close();
		System.out.println(s1);
		System.out.println(u1);
    }
}
