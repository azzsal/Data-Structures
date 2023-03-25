package deque;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class ArrayDequeTest {

    @Test
    public void equalsMethodTest() {
        ArrayDeque<Student> arrayDeque = new ArrayDeque<>();
        arrayDeque.addLast(new Student(123, "Ahmed", 19, 99.4));
        arrayDeque.addLast(new Student(123, "Khaled", 19, 99.4));
        arrayDeque.addLast(new Student(123, "Ali", 15, 99.4));
        arrayDeque.addLast(new Student(123, "Sami", 20, 98.4));
        arrayDeque.addLast(new Student(123, "Aziz", 21, 97.1));

        ArrayDeque<Student> arrayDeque2 = new ArrayDeque<>();
        arrayDeque2.addLast(new Student(123, "Ahmed", 19, 99.4));
        arrayDeque2.addLast(new Student(123, "Khaled", 19, 99.4));
        arrayDeque2.addLast(new Student(123, "Ali", 15, 99.4));
        arrayDeque2.addLast(new Student(123, "Sami", 20, 98.4));
        arrayDeque2.addLast(new Student(123, "Aziz", 21, 97.1));

        assertTrue(arrayDeque.equals(arrayDeque2));

    }


    @Test
    public void simpleTest() {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.addLast(67);
        arrayDeque.removeFirst();
        arrayDeque.removeLast();
        arrayDeque.removeLast();
        arrayDeque.addFirst(91);
        arrayDeque.addFirst(89);
        arrayDeque.addFirst(1);
        arrayDeque.addFirst(22);
        arrayDeque.removeFirst();
        arrayDeque.addFirst(1);
        arrayDeque.removeFirst();
        arrayDeque.addFirst(84);
        arrayDeque.addFirst(19);
        arrayDeque.addFirst(57);
        arrayDeque.addFirst(31);
        arrayDeque.removeFirst();
        arrayDeque.removeFirst();
        arrayDeque.addLast(47);
    }

    @Test
    public void randomizedTest() {
        Random r = new Random();
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        LinkedListDeque<Integer> linkedListDeque = new LinkedListDeque<>();
        int N = (int) 1e6;
        for(int i = 0; i < N; i++) {
            int operation = r.nextInt(10);
            Integer randVal = r.nextInt(100);
            if(operation == 1) {
                // addFirst
                arrayDeque.addFirst(randVal);
                linkedListDeque.addFirst(randVal);
                assertEquals(linkedListDeque.get(0), arrayDeque.get(0));
            } else if(operation == 2) {
                // addLast
                arrayDeque.addLast(randVal);
                linkedListDeque.addLast(randVal);
                assertEquals(linkedListDeque.get(linkedListDeque.size() - 1), arrayDeque.get(arrayDeque.size() - 1));
            } else if(operation == 3) {
                // removeFirst
                if(arrayDeque.isEmpty() || linkedListDeque.isEmpty()) continue;
                Integer sFirst = linkedListDeque.removeFirst();
                Integer aFirst = arrayDeque.removeFirst();
                assertEquals(sFirst, aFirst);
            } else if(operation == 4) {
                // removeLast
                if(arrayDeque.isEmpty() || linkedListDeque.isEmpty()) continue;
                Integer sLast = linkedListDeque.removeLast();
                Integer aLast = arrayDeque.removeLast();
                assertEquals(sLast, aLast);
            }
        }
    }

}
