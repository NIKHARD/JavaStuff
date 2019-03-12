package com.thread.thread03;

/**
 * ClassName:NotSafeThread02
 * package:com.thread.thread03
 * Description:
 *             线程不安全:取钱
 *
 * @date:2019/2/20 15:51
 * @author: NIK
 */
public class NotSafeThread02 {

    public static void main(String[] args) {

        Account account = new Account(100, "Nik's salary");

        Withdraw nik = new Withdraw(account, 80, "thread");
        Withdraw zoe = new Withdraw(account, 90, "zoe");

        nik.start();
        zoe.start();

    }

}

class Account {

    int money;
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }

}

class Withdraw extends Thread {

    Account account;
    int withdrawMoney;
    int balance;

    public Withdraw(Account account, int withdrawMoney, String name) {
        super(name);
        this.account = account;
        this.withdrawMoney = withdrawMoney;
    }

    @Override
    public void run() {

        if (account.money - withdrawMoney < 0) {
            return;
        }

        try {
            this.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        account.money -= withdrawMoney;
        balance += withdrawMoney;
        System.out.println(this.getName() + " " + "accountMoney: " + account.money);
        System.out.println(this.getName() + " " + "balance: " + balance);
    }
}
