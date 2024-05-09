import java.util.*;

class Student {
    String name;
    String ID;
    int enrollmentYear;
    double CGPA;

    public Student(String name, String ID, int enrollmentYear, double CGPA) {
        this.name = name;
        this.ID = ID;
        this.enrollmentYear = enrollmentYear;
        this.CGPA = CGPA;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", ID: " + ID + ", Enrollment Year: " + enrollmentYear + ", CGPA: " + CGPA;
    }
}

public class QuickSortStudents {
    public static void main(String[] args) {
        List<Student> students = generateStudentRecords(10);
        System.out.println("Original List:");
        displayStudents(students);

        long startTime = System.nanoTime();
        quickSort(students, 0, students.size() - 1);
        long endTime = System.nanoTime();

        System.out.println("\nSorted List:");
        displayStudents(students);

        System.out.println("\nTime taken to sort: " + (endTime - startTime) + " nanoseconds");
    }

    public static List<Student> generateStudentRecords(int numRecords) {
        List<Student> students = new ArrayList<>();
        Random random = new Random();
        String[] names = {"Alice", "Bob", "Charlie", "David", "Emma", "Frank", "Grace", "Henry", "Ivy", "Jack"};

        for (int i = 0; i < numRecords; i++) {
            String name = names[random.nextInt(names.length)];
            String ID = "ID" + (1000 + i); 
            int enrollmentYear = 2010 + random.nextInt(10); 
            double CGPA = 4.0 + (random.nextDouble() * (10.0 - 4.0)); 
            students.add(new Student(name, ID, enrollmentYear, CGPA));
        }
        return students;
    }

    public static void displayStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void quickSort(List<Student> students, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(students, low, high);
            quickSort(students, low, partitionIndex - 1);
            quickSort(students, partitionIndex + 1, high);
        }
    }

    public static int partition(List<Student> students, int low, int high) {
        String pivot = students.get(high).name;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (students.get(j).name.compareTo(pivot) <= 0) {
                i++;
                swap(students, i, j);
            }
        }

        swap(students, i + 1, high);
        return i + 1;
    }

    public static void swap(List<Student> students, int i, int j) {
        Student temp = students.get(i);
        students.set(i, students.get(j));
        students.set(j, temp);
    }
}
