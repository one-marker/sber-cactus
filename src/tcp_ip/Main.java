package tcp_ip;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

import static java.lang.Thread.sleep;

public class Main {



    public static void main(String[] args) throws InterruptedException {


        System.out.println("hello");


        int threads;
        //scan -h evlentev.ru, 2232, 212121/3 -p 32400, 2320,32,32,56454,454,32400

        Scanner sc = new Scanner(System.in);
        System.out.println("Port scanner 3000:");

        while (true) {

            ScanResult.results.clear();
            String cmd = sc.nextLine();
           // String cmd = "scan -h evlentev.ru -p 0-5000 -t 5000";
            String[] hosts;
            String[] ports;

            try {
                hosts = cmd.substring(cmd.indexOf("-h") + 2, cmd.indexOf("-p") - 1).replaceAll(" ", "").split(",");
                if(!cmd.contains("-t")){
                    cmd = cmd.concat(" -t 1");
                }
                ports = cmd.substring(cmd.indexOf("-p") + 2, cmd.indexOf("-t") - 1).replaceAll(" ", "").split(",");
                threads = Integer.parseInt(cmd.substring(cmd.indexOf("-t") + 2).replaceAll(" ", ""));


                if (hosts[0].isEmpty() || ports[0].isEmpty()) {
                    if (hosts[0].isEmpty()) {
                        System.err.println("Enter hosts");
                    }
                    if (ports[0].isEmpty()) {
                        System.err.println("Enter ports");
                    }
                } else {

                    System.out.println("Start scaning...");

                    PortScanner.start(hosts, ports, threads);

                    System.out.println("Scanning successful!");

                }
            } catch (Exception e) {
                System.err.println("Incorrect format!\nUse this format -> #scan -h hostname -p port -t k-threads");
            }

        }

    }




}
