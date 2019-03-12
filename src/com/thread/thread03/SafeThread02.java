package com.thread.thread03;

/**
 * ClassName:SafeThread02
 * package:com.thread.thread03
 * Description:
 *
 * @date:2019/2/20 16:59
 * @author: NIK
 */
public class SafeThread02 {

    public static void main(String[] args) {

        AccountSafe accountSafe = new AccountSafe(100, "Nik's salary");

        WithdrawSafe nik = new WithdrawSafe(accountSafe, 80, "thread");
        WithdrawSafe zoe = new WithdrawSafe(accountSafe, 90, "zoe");

        nik.start();
        zoe.start();

    }

}

class AccountSafe {

    int money;
    String name;

    public AccountSafe(int money, String name) {
        this.money = money;
        this.name = name;
    }

}

class WithdrawSafe extends Thread {

    AccountSafe accountSafe;
    int withdrawMoney;
    int balance;

    public WithdrawSafe(AccountSafe accountSafe, int withdrawMoney, String name) {
        super(name);
        this.accountSafe = accountSafe;
        this.withdrawMoney = withdrawMoney;
    }

    @Override
    public void run() {

        test();

    }

    //目标不对锁定失败，这里不是锁this应该锁定account
    public synchronized void test() {

        if (accountSafe.money - withdrawMoney < 0) {
            return;
        }

        try {
            this.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accountSafe.money -= withdrawMoney;
        balance += withdrawMoney;
        System.out.println(this.getName() + " " + "accountMoney: " + accountSafe.money);
        System.out.println(this.getName() + " " + "balance: " + balance);

    }

}
