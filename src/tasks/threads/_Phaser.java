package tasks.threads;

import java.util.concurrent.Phaser;

public class _Phaser {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(2);
        new Washer(phaser);
        new Washer(phaser);

    }
    static class Washer extends Thread{
        Phaser phaser;

        public Washer(Phaser phaser) {
            this.phaser = phaser;
            start();
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println(getName() + " washing the car " + i);
                phaser.arriveAndAwaitAdvance();
            }

        }
    }
}
