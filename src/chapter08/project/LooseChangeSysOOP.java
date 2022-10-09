package chapter08.project;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class LooseChangeSysOOP {
    public static void main(String[] args) {
        new LooseChangeSys().mainMenu();
    }
}

class LooseChangeSys {
    Scanner scanner = new Scanner(System.in);
    boolean isExit = false;
    int key;
    String detail = "";
    float balance = 0;
    float money;
    String note;
    Date date;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public void mainMenu() {
        do {
            System.out.println("\n==========零钱通菜单==========");
            System.out.println("\t\t1 零钱通明细");
            System.out.println("\t\t2 收入记账");
            System.out.println("\t\t3 消费入账");
            System.out.println("\t\t4 退出");
            System.out.print("请选择（1-4）：");
            key = scanner.nextInt();
            switch (key) {
                case 1:
                    this.printDetail();
                    break;
                case 2:
                    this.income();
                    break;
                case 3:
                    this.consume();
                    break;
                case 4:
                    this.exit();
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
            }
            for (int i = 0; i < 50; i++) {
                System.out.print("*");
            }
        } while (!isExit);

    }

    public void printDetail() {
        System.out.print("零钱通明细");
        if (detail.equals("")) {
            System.out.println("\n暂无记录");
            return;
        }
        System.out.println(detail);
    }

    public void income() {
        System.out.print("请输入收入金额：");
        money = scanner.nextFloat();
        if (money <= 0 ) {
            System.out.println("收入金额有误，应大于0");
            return;
        }
        System.out.print("请输入收入说明：");
        note = scanner.next();
        balance += money;
        date = new Date();
        detail += "\n收入\t" + "+" + money + "\t" + note + "\t" + sdf.format(date) + "\t余额：" + balance;
    }

    public void consume() {
        System.out.print("请输入消费金额：");
        money = scanner.nextFloat();
        if (money <= 0 || money > balance) {
            System.out.println("消费金额有误，应大于0，小于" + balance);
            return;
        }
        System.out.print("请输入消费说明：");
        note = scanner.next();
        balance -= money;
        date = new Date();
        detail += "\n消费\t" + "-" + money + "\t" + note + "\t" + sdf.format(date) + "\t余额：" + balance;
    }

    public void exit() {
        System.out.println("你确定要退出吗？ y/n");
        String choice;
        while (true) {
            choice = scanner.next();
            if (choice.equals("y") || choice.equals("n"))
                break;
            System.out.println("请输入y/n");
        }
        if (choice.equals("y")){
            isExit = true;
            System.out.println("退出了零钱通系统");
        }
    }

}