import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import static java.lang.System.nanoTime;

public class Main {

    public static void main(String[] args) {

        File file = new File(".\\src\\MOCK_DATA.csv");
        ArrayList<Student> studentList = Student.input(file);

        System.out.println("----------------------------------------------------------------------------");
        System.out.println("Bubble Sort");
        System.out.println("----------------------------------------------------------------------------");
        //bubbleSort(studentList);

    }

    public static void bubbleSort(ArrayList<Student> studentList) {
        long start = nanoTime();
        int comparitions = 0;
        int swaps = 0;
        for (int i = 0; i < studentList.size() - 1; i++) {
            for (int j = 0; j < studentList.size() - i - 1; j++) {
                ++comparitions;

                if(studentList.get(j).compareTo(studentList.get(j + 1)) > 0){
                    ++swaps;
                    Student temp = studentList.get(j);
                    studentList.set(j, studentList.get(j + 1));
                    studentList.set(j + 1, temp);
                }
            }
        }
        long end = (nanoTime() - start);
        for (Student student: studentList) {
            System.out.println(student);
        }
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("Comparitions = " + comparitions);
        System.out.println("Swaps = " + swaps);
        System.out.println("Execution time \u2248 " + end/Math.pow(10, 9) + " seconds");
    }
}
