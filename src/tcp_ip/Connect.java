package tcp_ip;

import java.net.InetSocketAddress;
import java.net.Socket;

public class Connect {

    final static int timeout = 2000;

    static boolean check(String host,int port) {
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(host, port), timeout);
            return true;
        } catch (Exception e) {
            System.out.println(e.getClass());
            return false;
        }
    }

}
