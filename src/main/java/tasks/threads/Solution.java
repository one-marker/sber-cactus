package tasks.threads;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.sleep;

/*
Знакомство с ThreadPoolExecutor
*/
public class Solution {
    static final AtomicInteger Minus = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
        final AtomicInteger count = new AtomicInteger(0);
 //       final AtomicInteger Minus = new AtomicInteger(0);
        LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        for (int i = 0; i < 10; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {




                    try {
                            Socket socket = new Socket();
                            socket.connect(new InetSocketAddress("evlentev.ru", 324000), 1000);
                            //System.out.println("true");
                        } catch (Exception e) {
                            //System.out.println(e.getClass());
                           // System.out.println("false");
                        }
                        doExpensiveOperation(count.addAndGet(1));

                      //  Minus.addAndGet(-1);
                        try {
                            sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }finally {
                           // Minus.addAndGet(1);
                        }


                }
            };
            queue.put(runnable);

        }
        new Thread2().run();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 5, 1000,
                TimeUnit.MILLISECONDS, queue);
        executor.prestartAllCoreThreads();


       // executor.shutdown();
        //executor.awaitTermination(5, TimeUnit.SECONDS);
        //Add your code here

        /* output example
pool-1-thread-2, localId=2
pool-1-thread-3, localId=3
pool-1-thread-1, localId=1
pool-1-thread-3, localId=5
pool-1-thread-2, localId=4
pool-1-thread-3, localId=7
pool-1-thread-1, localId=6
pool-1-thread-3, localId=9
pool-1-thread-2, localId=8
pool-1-thread-1, localId=10
         */
    }
    static class Thread2 extends Thread {
        @Override
        public void run() {

            System.out.println(getName() + " begin working");
            while (true) {

//                if (Minus.get() == 10) {
//                    System.out.println(getName() + "Stop");
//                    break;
//
//                }
            }

        }
    }
    private static void doExpensiveOperation(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId=" + localId);
    }
}