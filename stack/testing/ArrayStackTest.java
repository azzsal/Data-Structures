package stack.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import stack.implementation.ArrayStack;
import stack.implementation.Stack;

import java.util.Random;

public class ArrayStackTest {

    @Test
    public void randomizedTest() {

        Random r = new Random();
        Stack<Integer> stack = new ArrayStack<>();
        int N = (int) 1e6;
        for(int i = 0; i < N; i++) {
            int operation = r.nextInt(3);
            Integer randVal = r.nextInt(1000000);
            switch(operation) {
                case 1:
                    // push
                    stack.push(randVal);
                    Assertions.assertEquals(randVal, stack.top());
                    break;
                case 2:
                    // pop
                    if(stack.isEmpty()) continue;
                    Integer top = stack.top();
                    Assertions.assertEquals(top, stack.pop());
                    break;
            }
        }
    }
}
