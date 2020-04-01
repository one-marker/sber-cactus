package tasks.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class _Callable {
    public static void main(String[] args) throws Exception {
        Callable<Integer> callable = new MyCallable();
        FutureTask futureTask = new FutureTask(callable);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }
    static class MyCallable implements Callable<Integer> {


        @Override
        public Integer call() throws Exception {
            System.out.println("call");
            int j = 0;
            for (int i = 0; i < 10; i++) {
               Thread.sleep(200);
            }
            System.out.println("j = "+j);
            return j;
        }
    }
}
