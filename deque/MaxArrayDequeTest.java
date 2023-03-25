package deque;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;


public class MaxArrayDequeTest {

    @Test
    public void testMaxArrayDeque() {

        MaxArrayDeque<Student> studentsDeq = new MaxArrayDeque<>(new Comparator<Student>() {
            @Override
            public int compare(Student student1, Student student2) {
                return student1.getAge() - student2.getAge();
            }
        });

        studentsDeq.addLast(new Student(1234, "Ahmed Sami", 20, 95));
        studentsDeq.addLast(new Student(1233, "Ahmed Ali", 19, 94));
        studentsDeq.addLast(new Student(1232, "Ahmed Zaid", 17, 93));
        studentsDeq.addLast(new Student(1231, "Ahmed Waled", 24, 92));
        studentsDeq.addLast(new Student(1230, "Ahmed Belal", 26, 93));
        studentsDeq.addLast(new Student(1209, "Ahmed Aziz", 15, 99));

        Assertions.assertEquals(studentsDeq.get(2), studentsDeq.max(Student.getNameComparator()));
    }
}
