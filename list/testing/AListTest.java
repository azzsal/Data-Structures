package list.testing;

import list.implementation.AList;
import list.implementation.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Random;

public class AListTest {

    @Test
    public void randomizedTest() {

        Random r = new Random();
        List<Integer> aList = new AList<>();
        int N = (int) 1e6;
        for(int i = 0; i < N; i++) {
            int operation = r.nextInt(10);
            Integer randVal = r.nextInt(1000000);
            switch (operation) {
                case 1:
                    // addFirst
                    aList.addFirst(randVal);
                    Assertions.assertEquals(randVal, aList.getFirst());
                    break;
                case 2:
                    // addLast
                    aList.addLast(randVal);
                    Assertions.assertEquals(randVal, aList.getLast());
                    break;
                case 3:
                    // removeFirst
                    if(aList.size() == 0) continue;
                    Integer first = aList.getFirst();
                    Integer front_removed = aList.removeFirst();
                    Assertions.assertEquals(first, front_removed);
                    break;
                case 4:
                    // removeLast
                    if(aList.size() == 0) continue;
                    Integer last = aList.getLast();
                    Integer last_removed = aList.removeLast();
                    Assertions.assertEquals(last, last_removed);
                    break;
            }
        }
    }


}
