package tasks.homework;

import java.math.BigInteger;

public class ts1 {
    public static String hexToBinary(String hex) {
        return new BigInteger(hex, 16).toString(2);
    }
    public static void main(String[] args) {
        final int num = 03;
        String input = "06 , 87 , ff , d8 , 9f , 67 , e3, 0a , ba , 58 , c0 , cb , 34 , e2 , 65 , a9 , 7b , f9, 89, e8, 06 , 32 , fd , c3 , f2 , a4\n" +
                ", 55, 89, 43, 08 , 72 , 70 , 6c , 75 , 41 , ef , 1a , d1, 04 , 1b , 5f , c1 , 13, 08 , 4e , 100 , 52 , f0 , 23 , 2c , 4e ,\n" +
                "c8, 85, db, 8b, 8c, 06 , fc , 50 , ea , 2f , 47 , 84, 87, 70, 06 , 85 , 95 , d5 , 37 , 53 , d5, 06 , ff , 1e , c6 , 46 ,\n" +
                "8e , cc, 04 , 78 , c8 , f4 , db, 0a , 75 , da , 9a , ca , 51 , cf , 36 , 8e , 30 , 5c";
        String[] strings = input.trim().split(",");
        String newString = "";
        for (int i = 0; i < strings.length ; i++) {
            int count = checkFlag(strings[i].trim());
            if (count != 0){
                i++;
                for (int j = 0; j < count; j++) {
                    newString += strings[i].trim() + ", ";
                }
            }
            else {
                newString += strings[i].trim() + ", ";
            }
        }

//        for (String s :strings
//             ) {
//            System.out.println(s);
//        }
            System.out.println(newString);

      //  String biStr = Integer.toBinaryString(num);
        //String input
//        System.out.println(" Input Number: " + num + " toBinary "+ biStr);
//        int dec = binaryStringToDecimal(biStr);
//        System.out.println("Output Number: " + dec + " toBinary "+Integer.toBinaryString(dec));
   //     int decimal = Integer.parseInt("f4",2);
    //    String hexStr = Integer.toString(decimal,16);
       // System.out.println(hexToBinary("f4"));

    }
    static int checkFlag(String hex){
        String bin = hexToBinary(hex);
        if (bin.length() == 8) {
            char charAtZero = bin.charAt(0);
            if (charAtZero == '1'){
                System.out.println(Integer.parseInt(bin.substring(1),2));
                return Integer.parseInt(bin.substring(1),2);
            }
        }
        return 0;
    }
    static int binaryStringToDecimal(String biString){
        int n = biString.length();
        int decimal = 0;
        for (int d = 0; d < n; d++){
            // append a bit=0 (i.e. shift left)
            decimal = decimal << 1;

            // if biStr[d] is 1, flip last added bit=0 to 1
            if (biString.charAt(d) == '1'){
                decimal = decimal | 1; // e.g. dec = 110 | (00)1 = 111
            }
        }
        return decimal;
    }
}
