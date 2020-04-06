package tcp_ip;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;

class ScanThread implements Runnable{


    private String host;
    private String port;
    private int timeOut;
    private CountDownLatch countDownLatch;

    public ScanThread(String host, String port, int timeOut,  CountDownLatch countDownLatch) {
        this.host = host;
        this.port = port;
        this.timeOut = timeOut;
        this.countDownLatch = countDownLatch;

    }

    @Override
    public void run() {


        boolean status = false;
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(host, Integer.parseInt(port)), timeOut);
            status = true;

        } catch (Exception e) {
            status = false;
        } finally {

            System.out.println( this.host + ":" + this.port + " [" + status + "]");
            ScanResult.results.add(new Result(host, port, status));
            countDownLatch.countDown();


//            try {
//                Thread.sleep(0);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }


        }


    }

}