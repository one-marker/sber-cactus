package tasks.homework;

public class Main {
    public static void main(String[] args) {

        int max = 0, tmp, index= 0;
        String[] strings = "10111111111110011101111111111110110111".split("0");
        for (int i = 0; i < strings.length-1 ; i++) {


            if (!strings[i].isEmpty()) {

                tmp = strings[i].length() + strings[i + 1].length();
                if (tmp > max) {
                    max = tmp;
                    index = i + 1;
                }
            }


        }
        System.out.println("max lenght = " + max + ", index = " + index );
    }
}
