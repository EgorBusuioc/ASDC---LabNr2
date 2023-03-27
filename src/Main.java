import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import static java.lang.System.nanoTime;

public class Main {

    public static void main(String[] args) {

        File file = new File(".\\src\\MOCK_DATA.csv");
        ArrayList<Student> studentList = Student.input(file);
        ArrayList<Student> originalList = new ArrayList<>(studentList);

        System.out.println("----------------------------------------------------------------------------");
        System.out.println("Bubble Sort");
        System.out.println("----------------------------------------------------------------------------");
        bubbleSort(studentList);
        refreshList(studentList, originalList);

        System.out.println("----------------------------------------------------------------------------");
        System.out.println("Selection Sort");
        System.out.println("----------------------------------------------------------------------------");
        selectionSort(studentList);
        refreshList(studentList, originalList);

        System.out.println("----------------------------------------------------------------------------");
        System.out.println("Shell Sort");
        System.out.println("----------------------------------------------------------------------------");
        refreshList(studentList, originalList);
        shellSort(studentList);
    }
    public static void refreshList(ArrayList<Student> studentList, ArrayList<Student> originalList){
        studentList.clear();
        studentList.addAll(originalList);
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

    public static void selectionSort(ArrayList<Student> studentList){
        long start = nanoTime();
        int comparitions = 0;
        int swaps = 0;
        for (int i = 0; i < studentList.size() - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < studentList.size(); j++) {
                ++comparitions;
                if(studentList.get(j).compareTo(studentList.get(min_idx)) < 0)
                    min_idx = j;
            }
            if(i != min_idx){
                ++swaps;
                Student temp = studentList.get(i);
                studentList.set(i, studentList.get(min_idx));
                studentList.set(min_idx, temp);
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

    public static void shellSort(ArrayList<Student> studentList){
        long start = nanoTime();
        int comparitions = 0;
        int swaps = 0;
        for (int i = studentList.size() / 2; i > 0; i /= 2) {
            for (int j = i; j < studentList.size(); j++) {
                Student temp = studentList.get(j);
                int g;
                ++comparitions;
                for (g = i; g >= i && studentList.get(g - i).compareTo(temp) > 0 ; g -= i) {
                    ++swaps;
                    studentList.set(j, studentList.get(g - i));
                }
                ++swaps;
                studentList.set(g, temp);
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
