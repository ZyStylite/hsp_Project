package chapter08.test;

public class Finalize_test {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a);
//        将a所指对象变为了垃圾对象
        a = null;
//        立即触发垃圾回收机制（有小概率不成功）
        System.gc();
        System.out.println("程序运行结束");

    }
}
class A {
    @Override
    protected void finalize() {
//        super.finalize();
        System.out.println("该对象要被销毁了");
    }
}

