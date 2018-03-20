package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	// Потоки
        //long time = System.currentTimeMillis();
        /*for (int i=0; i<10000000; i++){
            double d = Math.sin(i*2) + Math.pow(i,3) - Math.sqrt(i/2);
            }
        */


        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<1000000; i++){
                    //double d = Math.sin(i*2) + Math.pow(i,3) - Math.sqrt(i/2);
                    update(1);
                }

            }
        });
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<1000000; i++){
                    //double d = Math.sin(i*2) + Math.pow(i,3) - Math.sqrt(i/2);
                    update(-1);
                }
            }
        });

        t.start();
        t1.start();
        t.join();
        t1.join();
        /*System.out.println(System.currentTimeMillis() - time);
        */
        System.out.println(n);
        }
    public static int n = 0;
    public static synchronized void update(int d){
        n += d;
    }
    }
