package list.testing;

import list.implementation.SLList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class SLListTest {

    @Test
    public void randomizedTest() {

        Random r = new Random();
        SLList<Integer> sLList = new SLList<>();
        int N = (int) 1e6;

        for(int i = 0; i < N; i++) {
            int operation = r.nextInt(10);
            Integer randVal = r.nextInt(1000000);
            switch (operation) {
                case 1:
                    // addFirst
                    sLList.addFirst(randVal);
                    Assertions.assertEquals(randVal, sLList.getFirst());
                    break;
                case 2:
                    // addLast
                    sLList.addLast(randVal);
                    Assertions.assertEquals(randVal, sLList.getLast());
                    break;
                case 3:
                    // removeFirst
                    if(sLList.size() == 0) continue;
                    Integer first = sLList.getFirst();
                    Integer front_removed = sLList.removeFirst();
                    Assertions.assertEquals(first, front_removed);
                    break;
                case 4:
                    // removeLast
                    if(sLList.size() == 0) continue;
                    Integer last = sLList.getLast();
                    Integer last_removed = sLList.removeLast();
                    Assertions.assertEquals(last, last_removed);
                    break;
            }
        }
    }
}
