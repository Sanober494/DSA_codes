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

public class MergeSortStudents {
    public static void main(String[] args) {
        List<Student> students = generateStudentRecords(10);
        System.out.println("Original List:");
        displayStudents(students);

        long startTime = System.nanoTime();
        mergeSort(students, 0, students.size() - 1);
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

    public static void mergeSort(List<Student> students, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(students, left, mid);
            mergeSort(students, mid + 1, right);
            merge(students, left, mid, right);
        }
    }

    public static void merge(List<Student> students, int left, int mid, int right) {
        List<Student> temp = new ArrayList<>();
        int i = left;
        int j = mid + 1;

        while (i <= mid && j <= right) {
            if (students.get(i).name.compareTo(students.get(j).name) <= 0) {
                temp.add(students.get(i));
                i++;
            } else {
                temp.add(students.get(j));
                j++;
            }
        }

        while (i <= mid) {
            temp.add(students.get(i));
            i++;
        }

        while (j <= right) {
            temp.add(students.get(j));
            j++;
        }

        for (i = left; i <= right; i++) {
            students.set(i, temp.get(i - left));
        }
    }
}
