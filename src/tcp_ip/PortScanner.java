package tcp_ip;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class PortScanner {

    private static int timeOut = 100;
    private static int poolSize = 1;

    public static void start(String[] hosts, String[] ports, int _poolSize) throws InterruptedException {

        poolSize = _poolSize;
        CountDownLatch countDownLatch = new CountDownLatch(hosts.length * ports.length);


        LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        for (String host:hosts) {

            for (String port:ports) {
                if (port.contains("-")){
                    int port1 = Integer.parseInt(port.substring(0,port.indexOf("-")));
                    int port2 = Integer.parseInt(port.substring(port.lastIndexOf("-")+1,port.length()));
                    for (int i = port1; i <= port2 ; i++) {
                        queue.put(new ScanThread(host,  Integer.toString(i), timeOut, countDownLatch));
                    }
                    //System.out.println(port1 + " - " + port2);
                } else {
                    queue.put(new ScanThread(host, port, timeOut, countDownLatch));
                 }


            }
        }
        ThreadPoolExecutor executor = new ThreadPoolExecutor(poolSize, poolSize, timeOut,
                TimeUnit.MILLISECONDS, queue);
        executor.prestartAllCoreThreads();
        while (executor.getTaskCount()!=executor.getCompletedTaskCount()) {
            //System.err.println("count="+executor.getTaskCount()+","+executor.getCompletedTaskCount());
            //Thread.sleep(5000);
        }
        System.out.println(executor.getCompletedTaskCount());
       // countDownLatch.await();
        executor.shutdown();

        try(FileWriter writer = new FileWriter("notes3.txt", false))
        {
            for (Result result: ScanResult.results) {
                writer.write(result.toString()+"\n");
            }


            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        for (Result result: ScanResult.results) {
            System.out.println(result.toString());
        }






    }


}