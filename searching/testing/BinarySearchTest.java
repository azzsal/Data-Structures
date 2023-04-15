package searching.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import searching.implementation.BinarySearch;


public class BinarySearchTest {

    private static class Student {
        int id;
        int age;
        String name;

        public Student(int id, int age, String name) {
            this.id = id;
            this.age = age;
            this.name = name;
        }
    }

    @Test
    public void testBinarySearch1() {

        Integer[] array = new Integer[]{1, 2, 10, 20, 33, 40, 59};
        Assertions.assertEquals(3, BinarySearch.binarySearch(array, 20));
        Assertions.assertEquals(-1, BinarySearch.binarySearch(array, 100));
        Assertions.assertEquals(0, BinarySearch.binarySearch(array, 1));
        Assertions.assertEquals(array.length-1, BinarySearch.binarySearch(array, 59));
    }

    @Test
    public void testBinarySearch2() {
        Student[] students = new Student[]{new Student(11, 20, "Ahmed"), new Student(12, 21, "Khaled"), new Student(18, 24, "Zaid")};
        Assertions.assertEquals(2, BinarySearch.binarySearch(students, new Student(18, 24, "Zaid"),
                (student1, student2) -> student1.id - student2.id));
    }
}


