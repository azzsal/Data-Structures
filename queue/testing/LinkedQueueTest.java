package queue.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import queue.implementation.LinkedQueue;
import queue.implementation.Queue;


import java.util.Random;

public class LinkedQueueTest {

    @Test
    public void randomizedTest() {

        Random r = new Random();
        Queue<Integer> queue = new LinkedQueue<>();
        int N = (int) 1e6;
        for(int i = 0; i < N; i++) {
            int operation = r.nextInt(3);
            Integer randVal = r.nextInt(1000000);
            switch(operation) {
                case 1:
                    // enqueue
                    int currentSize = queue.size();
                    queue.enqueue(randVal);
                    Assertions.assertEquals(currentSize+1, queue.size());
                    break;
                case 2:
                    // dequeue
                    if(queue.isEmpty()) continue;
                    Integer front = queue.front();
                    Assertions.assertEquals(front, queue.dequeue());
                    break;
            }
        }
    }
}
