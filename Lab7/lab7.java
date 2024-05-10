class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    Node top;

    Stack() {
        this.top = null;
    }

    boolean isEmpty() {
        return top == null;
    }

    void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        int popped = top.data;
        top = top.next;
        return popped;
    }
}

class Queue {
    Node front, rear;

    Queue() {
        this.front = this.rear = null;
    }

    boolean isEmpty() {
        return front == null;
    }

    void enqueue(int data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        int dequeued = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }
        return dequeued;
    }
}

public class lab7 {
    public static void main(String[] args) {
        Stack stack = new Stack();
        Queue queue = new Queue();

      
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Popped from stack: " + stack.pop());
        System.out.println("Popped from stack: " + stack.pop());

        
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Dequeued from queue: " + queue.dequeue());
        System.out.println("Dequeued from queue: " + queue.dequeue());
    }
}
