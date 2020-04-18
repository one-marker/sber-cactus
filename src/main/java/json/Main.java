package json;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        //HostResult hostResult = new HostResult("1","2");
        boolean b = true;
        int i = b ? 1 : 0;


        //Gson gson = new Gson
    }

    public static int boolToInt(boolean b) {
        return b ? 1 : 0;
    }

    public static class HostResult{

        private String hostname;
        private String result;

        public HostResult(String hostname, String result) {
            this.hostname = hostname;
            this.result = result;
        }
    }
}
