package map.testing;

import map.implementation.BSTMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;


public class BSTMapTest {

    @Test
    public void sanityGenericsTest() {
        try {
            BSTMap<String, String> a = new BSTMap<>();
            BSTMap<String, Integer> b = new BSTMap<>();
            BSTMap<Integer, String> c = new BSTMap<>();
            BSTMap<Boolean, Integer> e = new BSTMap<>();
        } catch (Exception e) {
            Assertions.fail();
        }
    }

    @Test
    public void sanityClearTest() {
        BSTMap<String, Integer> b = new BSTMap<>();
        for (int i = 0; i < 500; i++) {
            b.put("hi" + i, 1+i);
            Assertions.assertTrue(null != b.get("hi" + i) && (b.get("hi"+i).equals(1+i))
                    && b.containsKey("hi" + i));
        }
        Assertions.assertEquals(500, b.size());
        b.clear();
        Assertions.assertEquals(0, b.size());
        for (int i = 0; i < 500; i++) {
            Assertions.assertTrue(null == b.get("hi" + i) && !b.containsKey("hi" + i));
        }
    }

    @Test
    public void sanityContainsKeyTest() {
        BSTMap<String, Integer> b = new BSTMap<>();
        Assertions.assertFalse(b.containsKey("Hello World"));
        b.put("Hello World", 42);
        Assertions.assertTrue(b.containsKey("Hello World"));
    }

    @Test
    public void sanityGetTest() {
        BSTMap<String, Integer> b = new BSTMap<String, Integer>();
        Assertions.assertNull(b.get("hey"));
        Assertions.assertEquals(0, b.size());
        b.put("hey", 5);
        Assertions.assertEquals(5, (int) ((Integer) b.get("hey")));
        b.put("KISS", 5);
        Assertions.assertEquals(5, (int) ((Integer) b.get("KISS")));
        Assertions.assertNotEquals(null, b.get("hey"));
        Assertions.assertEquals(2, b.size());
    }

    @Test
    public void sanitySizeTest() {
        BSTMap<String, Integer> b = new BSTMap<String, Integer>();
        Assertions.assertEquals(0, b.size());
        b.put("hi", 1);
        Assertions.assertEquals(1, b.size());
        for (int i = 0; i < 455; i++)
            b.put("hi" + i, 1);
        Assertions.assertEquals(456, b.size());
    }

    @Test
    public void sanityPutTest() {
        BSTMap<String, Integer> b = new BSTMap<String, Integer>();
        b.put("hi", 1);
        Assertions.assertTrue(b.containsKey("hi") && b.get("hi") != null);
    }

    @Test
    public void containsKeyNullTest() {
        BSTMap<String, Integer> b = new BSTMap<String, Integer>();
        b.put("hi", null);
        Assertions.assertTrue(b.containsKey("hi"));
    }

    @Test
    public void sanityKeySetTest() {
        BSTMap<String, Integer> b = new BSTMap<>();
        HashSet<String> values = new HashSet<>();
        for (int i = 0; i < 500; i++) {
            b.put("hi" + i, 1);
            values.add("hi" + i);
        }
        Assertions.assertEquals(500, b.size());
        Set<String> keySet = b.keySet();
        Assertions.assertTrue(values.containsAll(keySet));
        Assertions.assertTrue(keySet.containsAll(values));
    }

    @Test
    public void testRemoveRoot() {
        BSTMap<String,String> q = new BSTMap<>();
        q.put("c","a");
        q.put("b","a");
        q.put("a","a");
        q.put("d","a");
        q.put("e","a"); // a b c d e
        Assertions.assertNotNull(q.remove("c"));
        Assertions.assertFalse(q.containsKey("c"));
        Assertions.assertTrue(q.containsKey("a"));
        Assertions.assertTrue(q.containsKey("b"));
        Assertions.assertTrue(q.containsKey("d"));
        Assertions.assertTrue(q.containsKey("e"));
    }

    /*
     * Remove Test 2
     * test the 3 different cases of remove
     */
    @Test
    public void testRemoveThreeCases() {
        BSTMap<String,String> q = new BSTMap<String,String>();
        q.put("c","a");
        q.put("b","a");
        q.put("a","a");
        q.put("d","a");
        q.put("e","a");                         // a b c d e
        Assertions.assertNotNull(q.remove("e"));      // a b c d
        Assertions.assertTrue(q.containsKey("a"));
        Assertions.assertTrue(q.containsKey("b"));
        Assertions.assertTrue(q.containsKey("c"));
        Assertions.assertTrue(q.containsKey("d"));
        Assertions.assertNotNull(q.remove("c"));      // a b d
        Assertions.assertTrue(q.containsKey("a"));
        Assertions.assertTrue(q.containsKey("b"));
        Assertions.assertTrue(q.containsKey("d"));
        q.put("f","a");                         // a b d f
        Assertions.assertNotNull(q.remove("d"));      // a b f
        Assertions.assertTrue(q.containsKey("a"));
        Assertions.assertTrue(q.containsKey("b"));
        Assertions.assertTrue(q.containsKey("f"));
    }

    /*
     * Remove Test 3
     * Checks that remove works correctly on root nodes
     * when the node has only 1 or 0 children on either side.
     */
    @Test
    public void testRemoveRootEdge() {
        BSTMap<Character, Integer> rightChild = new BSTMap<>();
        rightChild.put('A', 1);
        rightChild.put('B', 2);
        Integer result = rightChild.remove('A');
        Assertions.assertEquals(result,  Integer.valueOf(1));
        for (int i = 0; i < 10; i++) {
            rightChild.put((char) ('C'+i), 3+i);
        }
        rightChild.put('A', 100);
        Assertions.assertEquals((rightChild.remove('D')), Integer.valueOf(4));
        Assertions.assertEquals((rightChild.remove('G')), Integer.valueOf(7));
        Assertions.assertEquals((rightChild.remove('A')), Integer.valueOf(100));
        Assertions.assertEquals(9, rightChild.size());

        BSTMap<Character, Integer> leftChild = new BSTMap<>();
        leftChild.put('B', 1);
        leftChild.put('A', 2);
        Assertions.assertEquals(1, leftChild.remove('B'));
        Assertions.assertEquals(1, leftChild.size());
        Assertions.assertNull(leftChild.get('B'));

        BSTMap<Character, Integer> noChild = new BSTMap<>();
        noChild.put('Z', 15);
        Assertions.assertEquals(15, (noChild.remove('Z')));
        Assertions.assertEquals(0, noChild.size());
        Assertions.assertNull(noChild.get('Z'));
    }

    @Test
    public void iteratorTest() {
        BSTMap<Integer, Integer> b = new BSTMap<>();
        b.put(33, 1);
        b.put(12, 1);
        b.put(10, 1);
        b.put(78, 1);
        b.put(100, 1);
        b.put(1, 1);
        b.put(0, 1);
        b.put(99, 1);
        b.put(45, 1);
        b.put(43, 1);
        List<Integer> list = new ArrayList<>();
        for (Integer integer : b) {
            list.add(integer);
        }
        Assertions.assertEquals(list, List.of(0, 1, 10, 12, 33, 43, 45, 78, 99, 100));
    }
}
