package com.multithreading.example;

import java.util.ArrayList;
import java.util.List;
public class Producer extends Thread {
    Fruit fruit;

    public Producer(Fruit f) {
        this.fruit = f;
    }

    public void run() {
        List<String> fruits = new ArrayList<String>(0);
        fruits.add("Apple");
        fruits.add("Orange");
        fruits.add("Papaya");
        fruits.add("Banana");
        fruits.add("Watermelon");
        fruits.add("Grapes");
        fruit.setQuantity(fruits.size());
        for (String f : fruits) {
            fruit.produce(f);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
