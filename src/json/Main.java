package json;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        int num = in.nextInt();

        System.out.printf("Your number: %d \n", num);
        in.close();
//        try{
//            Socket socket = new Socket();
//
//            socket.connect(new InetSocketAddress("evlentev.ru",32400),2000);
//            System.out.println("oK");
//          //  Scanner scanner = new Scanner((socket.getInputStream()));
////            while (scanner.hasNextLine()){
////                System.out.println(scanner.nextLine());
////            }
//        }
//        catch (Exception e){
//            System.out.println(e.getClass());
//        }
    }
}
