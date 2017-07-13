package com.multithreading.example;

public class Consumer extends Thread {
    private Fruit fruit;

    public Consumer(Fruit f) {
        this.fruit = f;
    }

    public void run() {
        int i = 0;
        do {
            fruit.consume();
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        } while (i < fruit.getQuantity());
    }
}
