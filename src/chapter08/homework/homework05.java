package chapter08.homework;

public class homework05 {
    public static void main(String[] args) {
        Writer writer = new Writer(3000);
        writer.printPay();
        Teacher teacher = new Teacher(5000, 150, 200);
        teacher.printPay();
        Scientist scientist = new Scientist(15000, 200000);
        scientist.printPay();
    }
}

class Profession {
    private double baseMonthPay;

    public Profession(double baseMonthPay) {
        this.baseMonthPay = baseMonthPay;
    }

    public void printPay() {
        System.out.println("全年工资为" + getBaseYearPay());
    }

    public double getBaseMonthPay() {
        return baseMonthPay;
    }

    public double getBaseYearPay() {
        return baseMonthPay * 12;
    }
}

class Writer extends Profession {
    public Writer(double baseMonthPay) {
        super(baseMonthPay);
    }

    @Override
    public void printPay() {
        System.out.print("服务员");
        super.printPay();
    }
}

class Teacher extends Profession {
    private double classDayPay;
    private int classDays;

    public Teacher(double baseMonthPay, double classDayPay, int classDays) {
        super(baseMonthPay);
        this.classDayPay = classDayPay;
        this.classDays = classDays;
    }

    @Override
    public void printPay() {
        System.out.print("教师");
        System.out.println("全年工资为" + (getBaseYearPay() + classDayPay * classDays));
    }
}

class Scientist extends Profession{
    private double bonus;

    public Scientist(double baseMonthPay, double bonus) {
        super(baseMonthPay);
        this.bonus = bonus;
    }

    @Override
    public void printPay() {
        System.out.print("科学家");
        System.out.println("全年工资为" + (getBaseYearPay() + bonus));
    }
}