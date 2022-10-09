package chapter08.test;

//import java.util.Scanner;
public class extend_test {
    public static void main(String[] args) {
        Person person = new Person("xiangming", 24);
        Student alice = new Student("Alice", 18);
        Student bob = new Student("Bob", 19);
        System.out.println(person);

//        person = student;
////        Person person1 = new Student("Alice", 18);  //等价
////        student = person;
//        student = (Student)person;
//        student.grade = 100;
//
//        System.out.println(person.name);
//        System.out.println(student.age);
//        System.out.println(student.grade);
//        test();  // main方法为static，只能直接调用static方法


    }

    public static void test() {

    }


}

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void say(){
        System.out.println("说话");

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Student extends Person {
    char grade;
    private int score;

    public Student(String name, int age) {
        super(name, age);
        if(super.age == 0)
            grade = '九';
    }

    @Override
    public void say() {
        super.say();
        System.out.println("讨论数学题");
    }
}