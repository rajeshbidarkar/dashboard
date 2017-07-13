package com.multithreading.example;

public class ProducerConsumerTest {
    public static void main(String[] args) {
        Fruit f = new Fruit();
        Producer p = new Producer(f);
        Consumer c = new Consumer(f);
        p.start();
        c.start();
    }
}

