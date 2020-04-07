package tasks.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Conditions {
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();
    static int money = 0;
    public static void main(String[] args) throws InterruptedException{
        new AccountMinis().start();
        new AccountPlus().start();
    }
    static class AccountPlus extends Thread{
        @Override
        public void run() {
            lock.lock();
            money += 10;
            condition.signal();
            lock.unlock();
        }
    }
    static class AccountMinis extends Thread{
        @Override
        public void run() {
            if (money < 10){
                try {
                    lock.lock();
                    System.out.println(money);
                    condition.await();
                    System.out.println(money);
                    lock.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            money -= 10;
        }
    }
}
