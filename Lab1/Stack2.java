package Lab1;


class Student{
String name;
int idno;
String dob;
double cgpa;

public Student(String name, int idno,String dob,double cgpa){
    this.name=name;
    this.idno=idno;
    this.dob=dob;
    this.cgpa=cgpa;
}

public String toString() {
    return "Student [name=" + name + ", idno=" + idno + ", dob=" + dob + ", cgpa=" + cgpa + "]";
  }

}

class Stack{

    Student arr[];
    int top;
    int capacity;

    public Stack(int size){
        arr=new Student[size];
        capacity=size;
        top=-1;
        }


public Student pop(){
    if (isEmpty()){
        System.out.println("Stack is empty");
    }
    return arr[top--];
    }

    public void push(Student stu){
        if (isFull()){
            System.out.println("OverFlow");
        }
        arr[++top]=stu;
        }

public Boolean isFull(){
    return top==capacity-1;
}
public Boolean isEmpty(){
    return top==-1;
}

public void printStack() {
    if (isEmpty()) {
      System.out.println("Stack is empty!");
    } else {
      System.out.println("Stack elements:");
      for (int i = top; i >= 0; i--) {
        Student student = arr[i];
        System.out.println(student);
      }
    }
  }

}

public class Stack1{
    public static void main(String args[]){
        Stack stack= new Stack(5);
        Student student1= new Student("San", 89,"04/09/2004", 9.8);
        Student student2= new Student("Tan", 89,"02/10/2004", 9.9);
        Student student3= new Student("Lan", 89,"01/08/2004", 8.5);
        Student student4= new Student("Yan", 89,"03/07/2004", 8.2);
        Student student5= new Student("Wan", 89,"05/06/2004", 9.4);
        stack.push(student1);
        stack.push(student2);
        stack.push(student3);
        stack.push(student4);
        stack.push(student5);
        stack.printStack();
        stack.pop();
        stack.printStack();
                
    }
}
