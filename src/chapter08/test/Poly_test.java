package chapter08.test;

public class Poly_test {
    public static void main(String[] args) {
        //属性没有重写之说！属性的值看编译类型
        Base base = new Sub();//向上转型
        base.say();
        System.out.println(base.count);// ？ 看编译类型 10
        Sub sub = new Sub();
        sub.say();
        System.out.println(sub.count);//? 20
    }
}

class Base { //父类
    int count = 10;//属性

    void say() {
        System.out.println("Base");
    }
}

class Sub extends Base {//子类
    int count = 20;//属性

    void say() {
        System.out.println("Sub");
    }
}