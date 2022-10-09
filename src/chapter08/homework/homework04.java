package chapter08.homework;

public class homework04 {
    public static void main(String[] args) {
        Manger manger = new Manger("刘备", 1000, 20);
        manger.setBonus(10000);
        manger.printSalary();
        Worker worker = new Worker("张飞", 800, 25);
        worker.printSalary();
    }
}

class Employee {
    private String name;
    private double daySal;
    private int workDays;
    private double grade;

    public Employee(String name, double daySal, int workDays) {
        this.name = name;
        this.daySal = daySal;
        this.workDays = workDays;
    }

    public void printSalary() {
        System.out.println(name + " 的工资为" + daySal * workDays * grade);
    }

    public String getName() {
        return name;
    }

    public double getDaySal() {
        return daySal;
    }


    public int getWorkDays() {
        return workDays;
    }


    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}

class Manger extends Employee {
    private double bonus;


    public Manger(String name, double daySal, int workDays) {
        super(name, daySal, workDays);
        super.setGrade(1.2);
    }

    @Override
    public void printSalary() {
        System.out.println("经理" + getName() + "的工资为" + (bonus + getDaySal() * getWorkDays() * getGrade()));
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}

class Worker extends Employee {
    public Worker(String name, double daySal, int workDays) {
        super(name, daySal, workDays);
        super.setGrade(1.0);
    }

    @Override
    public void printSalary() {
        System.out.print("普通员工");
        super.printSalary();
    }
}