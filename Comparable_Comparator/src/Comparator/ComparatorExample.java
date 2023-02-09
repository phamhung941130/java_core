package Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Linh",24,8.22));
        students.add(new Student(2,"Nguyen",21,8.22));
        students.add(new Student(3,"Hung",22,8.22));
        students.add(new Student(4,"Binh",23,8.22));

     Collections.sort(students, new Comparator<Student>() {
         @Override
         public int compare(Student o1, Student o2) {
             return o1.getName().compareTo(o2.getName());
         }
     });
        for (Student s:students) {
            System.out.println(s.toString());
        }
    }
}
