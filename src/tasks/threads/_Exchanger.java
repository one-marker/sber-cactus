package tasks.threads;

import java.util.concurrent.Exchanger;

public class _Exchanger {
    public static void main(String[] args) throws InterruptedException{
        Exchanger<String> exchanger = new Exchanger<>();
        new User(exchanger);
        new User2(exchanger);

    }

    static class User extends Thread{
        Exchanger<String> exchanger;

        public User(Exchanger<String> exchanger) {

            this.exchanger = exchanger;
            start();
        }

        @Override
        public void run() {
            try {
                exchanger.exchange("hello");
                exchanger.exchange("max");
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    static class User2 extends Thread{
        Exchanger<String> exchanger;

        public User2(Exchanger<String> exchanger) {

            this.exchanger = exchanger;
            start();
        }

        @Override
        public void run() {
            try {
                System.out.println(exchanger.exchange(null));
                System.out.println(exchanger.exchange(null));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
