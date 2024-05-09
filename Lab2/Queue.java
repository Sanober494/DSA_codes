

class Student {
    public String name;
    public int idNo;
    public String dob;
    public double cgpa;

    public Student(String name, int idNo, String dob, double cgpa) {
        this.name = name;
        this.idNo = idNo;
        this.dob = dob;
        this.cgpa = cgpa;
    }

    public String toString() {
        return "Name: " + name + ", ID: " + idNo + ", DOB: " + dob + ", CGPA: " + cgpa;
    }
}

class CircularQueue {
    public int front, rear, size;
    public Student[] queue;
    public int capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        queue = new Student[capacity];
        front = rear = -1;
        size = 0;
    }

    public void enqueue(Student student) {
        if ((rear + 1) % capacity == front) {
            System.out.println("Queue is full. Cannot enqueue.");
            return;
        }

        if (front == -1) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % capacity;
        }

        queue[rear] = student;
        size++;
    }

    public Student dequeue() {
        if (front == -1) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return null;
        }

        Student removed = queue[front];
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % capacity;
        }
        size--;
        return removed;
    }

    public void displayAll() {
        if (front == -1) {
            System.out.println("Queue is empty.");
            return;
        }

        int tempFront = front;
        while (tempFront != rear) {
            System.out.println(queue[tempFront]);
            tempFront = (tempFront + 1) % capacity;
        }
        System.out.println(queue[rear]);
    }

    public void displayStudent9() {
        if (front == -1) {
            System.out.println("Queue is empty.");
            return;
        }

        int tempFront = front;
        while (tempFront != rear) {
            if (queue[tempFront].cgpa < 9.0) {
                System.out.println(queue[tempFront].name);
            }
            tempFront = (tempFront + 1) % capacity;
        }
        if (queue[rear].cgpa < 9.0) {
            System.out.println(queue[rear].name);
        }
    }
}

public class Queue {
    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);

      
        queue.enqueue(new Student("San", 89, "04/09/2004", 9.8));
        queue.enqueue(new Student("Tan", 43, "02/10/2004", 9.9));
        queue.enqueue(new Student("Lan", 53, "01/08/2004", 8.5));
        queue.enqueue(new Student("Yan", 32, "03/07/2004", 8.2));
        queue.enqueue(new Student("Wan", 12, "05/06/2004", 9.4));

        
        System.out.println("All Student Records:");
        queue.displayAll();

       
        System.out.println("\nDequeued Student Record:");
        System.out.println(queue.dequeue());

       
        System.out.println("\nStudents with CGPA Less Than 9:");
        queue.displayStudent9();
    }
}
