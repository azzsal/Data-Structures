package set.bstset.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import set.bstset.implementation.BSTSet;

public class BSTSetTest {

    @Test
    public void testAdd() {
        BSTSet<Integer> st = new BSTSet<>();
        st.add(10);
        st.add(1);
        st.add(2);
        st.add(3);
        st.add(4);
        st.add(9);
        st.add(8);
        st.add(3);
        st.add(1);
        st.add(2);
        st.add(0);
        Assertions.assertEquals("0 1 2 3 4 8 9 10", st.toString());
    }

    @Test
    public void testRemove() {
        BSTSet<Integer> st = new BSTSet<>();
        st.add(150);
        st.add(200);
        st.add(250);
        st.add(300);
        st.add(350);
        st.add(400);
        st.add(450);
        st.add(500);
        st.add(550);
        st.add(600);
        st.add(650);
        st.add(700);
        st.add(750);
        st.add(800);
        st.add(950);
        st.add(100);

        Assertions.assertEquals(400, st.remove(400));
        Assertions.assertNull(st.remove(400));
        Assertions.assertEquals("100 150 200 250 300 350 450 500 550 600 650 700 750 800 950", st.toString());

    }

    @Test
    public void testRemoveThreeCases() {
        BSTSet<Integer> st = new BSTSet<>();
        st.add(10);
        st.add(30);
        st.add(5);
        st.add(2);
        st.add(8);
        st.add(25);
        st.add(50);

        // removing a leaf node
        st.remove(50);
        Assertions.assertEquals("2 5 8 10 25 30", st.toString());

        // removing a node with one child
        st.remove(30);
        Assertions.assertEquals("2 5 8 10 25", st.toString());

        // removing a node with two children
        st.remove(5);
        Assertions.assertEquals("2 8 10 25", st.toString());
    }
}
