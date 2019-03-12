package com.thread.thread03;

/**
 * ClassName:SafeThreadByBlock01
 * package:com.thread.thread03
 * Description:
 *
 * @date:2019/2/20 17:20
 * @author: NIK
 */

public class SafeThreadByBlock01 {

    public static void main(String[] args) {

        AccountSafeBlock accountSafe = new AccountSafeBlock(100, "Nik's salary");

        WithdrawSafeBlock nik = new WithdrawSafeBlock(accountSafe, 80, "thread");
        WithdrawSafeBlock zoe = new WithdrawSafeBlock(accountSafe, 90, "zoe");

        nik.start();
        zoe.start();

    }

}

class AccountSafeBlock {

    int money;
    String name;

    public AccountSafeBlock(int money, String name) {
        this.money = money;
        this.name = name;
    }

}

class WithdrawSafeBlock extends Thread {

    AccountSafeBlock accountSafe;
    int withdrawMoney;
    int balance;

    public WithdrawSafeBlock(AccountSafeBlock accountSafe, int withdrawMoney, String name) {
        super(name);
        this.accountSafe = accountSafe;
        this.withdrawMoney = withdrawMoney;
    }

    @Override
    public void run() {
        test();
    }

    //目标不对锁定失败，这里不是锁this应该锁定account
    public void test() {

        //提高性能
        if (accountSafe.money < 0) {
            return;
        }

        synchronized (accountSafe){

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

}
