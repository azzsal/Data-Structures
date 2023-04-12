package queue.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import queue.implementation.ArrayQueue;
import queue.implementation.Queue;

import java.util.Random;

public class ArrayQueueTest {

    @Test
    public void randomizedTest() {
        Random r = new Random();
        Queue<Integer> arrayQueue = new ArrayQueue();
        int N = (int) 1e7;
        for(int i = 0; i < N; i++) {
            int operation = r.nextInt(3);
            Integer randVal = r.nextInt(1000000);
            switch (operation) {
                case 1:
                    // enqueue
                    int currentSize = arrayQueue.size();
                    arrayQueue.enqueue(randVal);
                    Assertions.assertEquals(currentSize+1, arrayQueue.size());
                    break;
                case 2:
                    // dequeue
                    if(arrayQueue.isEmpty()) continue;
                    Integer front = arrayQueue.front();
                    Assertions.assertEquals(front, arrayQueue.dequeue());
                    break;
            }
        }
    }

    @Test
    public void testEnqueue() {
        Queue<Integer> arrayQueue = new ArrayQueue<>();
        arrayQueue.enqueue(10);
        arrayQueue.enqueue(15);
        arrayQueue.enqueue(20);
        arrayQueue.enqueue(25);
        arrayQueue.enqueue(30);
        arrayQueue.enqueue(35);
        arrayQueue.enqueue(40);
        arrayQueue.enqueue(45);
        arrayQueue.enqueue(50);
        arrayQueue.enqueue(55);
        arrayQueue.enqueue(60);
        arrayQueue.enqueue(65);
        arrayQueue.enqueue(70);
        arrayQueue.enqueue(75);
        arrayQueue.enqueue(80);
        arrayQueue.enqueue(85);
        arrayQueue.enqueue(90);
        arrayQueue.enqueue(95);
        arrayQueue.enqueue(100);
        arrayQueue.enqueue(200);
        arrayQueue.enqueue(300);
        arrayQueue.enqueue(400);
        arrayQueue.enqueue(500);
        arrayQueue.enqueue(600);
        arrayQueue.enqueue(700);
        arrayQueue.enqueue(800);
        arrayQueue.enqueue(900);
        arrayQueue.enqueue(1000);
        arrayQueue.enqueue(1100);
        arrayQueue.enqueue(1200);
        arrayQueue.enqueue(1300);
        arrayQueue.enqueue(1400);
        arrayQueue.enqueue(1500);
        arrayQueue.enqueue(1600);
        arrayQueue.enqueue(1700);
        arrayQueue.enqueue(1800);
        arrayQueue.enqueue(1900);
        arrayQueue.enqueue(2000);

        int last = 2000;
        while(arrayQueue.size() > 1) {
            arrayQueue.dequeue();
        }
        Assertions.assertEquals(last, arrayQueue.front());
    }
}
