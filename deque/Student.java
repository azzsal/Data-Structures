package deque;

import java.util.Comparator;

public class Student {

    private int id;
    private String name;
    private int age;
    private double gpa;

    public Student(int id, String name, int age, double gpa) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    private static class NameComparator implements Comparator<Student> {
        @Override
        public int compare(Student student, Student t1) {
            return student.getName().compareTo(t1.getName());
        }
    }

    public static Comparator<Student> getNameComparator() {
        return new NameComparator();
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gpa=" + gpa +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o instanceof Student otherStudent)
            return this.getName().equals(otherStudent.getName()) && this.getAge() == otherStudent.getAge() &&
                    this.getId() == otherStudent.getId() && this.getGpa() == otherStudent.getGpa();
        return false;
    }
}
