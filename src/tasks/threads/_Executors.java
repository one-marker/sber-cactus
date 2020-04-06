package tasks.threads;

import java.util.concurrent.*;

public class _Executors {

    public static void main(String[] args) throws Exception{
        //Таймер
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.schedule(new MyRunable(),3,TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();



        //Пул потоков
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(new MyRunable());
        System.out.println(executorService.submit(new MyCallable()).get());
        executorService.shutdown();



    }

    static class MyRunable implements Runnable{

        @Override
        public void run() {
            System.out.println(1);
        }
    }

    static class MyCallable implements Callable<String>{


        @Override
        public String call() throws Exception {
            return "2";
        }
    }
}
