package tasks.threads;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class _BlockingQueue {
    public static void main(String[] args) {
//        Queue<String> queue = new PriorityQueue<>();
//
//        new Thread(){
//            @Override
//            public void run() {
//                System.out.println(queue.remove());
//            }
//        }.start();
//        new Thread(){
//            @Override
//            public void run() {
//                queue.add("string");
//            }
//        }.start();
        BlockingQueue<String> queue = new PriorityBlockingQueue<>();
        queue.add("string1");
        new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println(queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                queue.add("strin1");
                queue.add("strin2");
            }
        }.start();
    }
}
