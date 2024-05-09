import java.util.Scanner;

class Node {
    public String name;
    public String ID;
    public double CGPA;
    public Node next;

    public Node(String name, String ID, double CGPA) {
        this.name = name;
        this.ID = ID;
        this.CGPA = CGPA;
        this.next = null;
    }
}

public class SinglyLinkedList {
    public Node head;

    public SinglyLinkedList() {
        this.head = null;
    }

    public void insert(int position, String name, String ID, double CGPA) {
        Node newNode = new Node(name, ID, CGPA);
        if (position == 1 || head == null) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            for (int i = 1; i < position - 1 && current.next != null; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public int find(String name) {
        Node current = head;
        int position = 1;
        while (current != null) {
            if (current.name.equals(name)) {
                return position;
            }
            current = current.next;
            position++;
        }
        return -1;
    }

    public int delete(String name) {
        int position = find(name);
        if (position == -1) {
            return -1;
        }
        if (position == 1) {
            head = head.next;
        } else {
            Node current = head;
            for (int i = 1; i < position - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        return position;
    }

    public Node get(int position) {
        Node current = head;
        for (int i = 1; i < position; i++) {
            current = current.next;
        }
        return current;
    }

    public void display() {
        Node current = head;
        int position = 1;
        while (current != null) {
            System.out.println(position + ". " + current.name + ", " + current.ID + ", " + current.CGPA);
            current = current.next;
            position++;
        }
    }

    public int size() {
        Node current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public int isEmpty() {
        return head == null ? 1 : 0;
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("List Operations:");
            System.out.println("1. Add a student record to the list");
            System.out.println("2. Find a student record by name");
            System.out.println("3. Delete a student record from the list");
            System.out.println("4. Display the list");
            System.out.println("5. isEmpty");
            System.out.println("6. Size");
            System.out.println("7. Exit");
            System.out.print("Enter Menu Option: ");
            option = scanner.nextInt();
            scanner.nextLine(); 
            switch (option) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter ID no: ");
                    String ID = scanner.nextLine();
                    System.out.print("Enter CGPA: ");
                    double CGPA = scanner.nextDouble();
                    System.out.print("Enter index: ");
                    int index = scanner.nextInt();
                    list.insert(index, name, ID, CGPA);
                    System.out.println("Added the student record to the list");
                    break;
                case 2:
                    System.out.print("Enter the Name of the student: ");
                    String searchName = scanner.nextLine();
                    int pos = list.find(searchName);
                    if (pos != -1) {
                        System.out.println("The student " + searchName + " is present at index " + pos);
                    } else {
                        System.out.println("The student " + searchName + " is not found in the list");
                    }
                    break;
                case 3:
                    System.out.print("Enter the Name of the student to be deleted from the list: ");
                    String deleteName = scanner.nextLine();
                    int deletedPos = list.delete(deleteName);
                    if (deletedPos != -1) {
                        System.out.println("The student " + deleteName + " is deleted from the list.");
                        System.out.println("There are " + list.size() + " records present in the list. The student records present in the list are:");
                        list.display();
                    } else {
                        System.out.println("The student " + deleteName + " is not found in the list");
                    }
                    break;
                case 4:
                    System.out.println("There are " + list.size() + " records present in the list. The student records present in the list are:");
                    list.display();
                    break;
                case 5:
                    System.out.println("List is " + (list.isEmpty() == 1 ? "empty" : "not empty"));
                    break;
                case 6:
                    System.out.println("Total number of students in the list: " + list.size());
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please enter a valid option.");
            }
        } while (option != 7);
        scanner.close();
    }
}
