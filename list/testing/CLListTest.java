package list.testing;

import list.implementation.CLList;
import list.implementation.DLList;
import list.implementation.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class CLListTest {

    @Test
    public void randomizedTest() {

        Random r = new Random();
        List<Integer> dLList = new CLList<>();
        int N = (int) 1e6;

        for (int i = 0; i < N; i++) {
            int operation = r.nextInt(10);
            Integer randVal = r.nextInt(1000000);
            switch (operation) {
                case 1:
                    // addFirst
                    dLList.addFirst(randVal);
                    Assertions.assertEquals(randVal, dLList.getFirst());
                    break;
                case 2:
                    // addLast
                    dLList.addLast(randVal);
                    Assertions.assertEquals(randVal, dLList.getLast());
                    break;
                case 3:
                    // removeFirst
                    if (dLList.size() == 0) continue;
                    Integer first = dLList.getFirst();
                    Integer front_removed = dLList.removeFirst();
                    Assertions.assertEquals(first, front_removed);
                    break;
                case 4:
                    // removeLast
                    if (dLList.size() == 0) continue;
                    Integer last = dLList.getLast();
                    Integer last_removed = dLList.removeLast();
                    Assertions.assertEquals(last, last_removed);
                    break;
            }
        }
    }
}
