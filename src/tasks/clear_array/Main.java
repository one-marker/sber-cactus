package tasks.clear_array;


import java.util.Random;

import static java.lang.Math.random;

class first_task{
    Integer [] array;
    public first_task(int size) {
        Random random = new Random();
        random.setSeed(12232);
        array = new Integer[size];
        for(int i=0; i< size; i++){
            array[i] = random.nextInt(10);
        }

    }
    public void print(){
        Random random = new Random();
        for(int i=0; i< array.length; i++){
           System.out.println(array[i] + "["+i+"]");
        }
        System.out.println("------------");
    }
    public void clear(int item){
        int i = 0;
        int j = 0 ;
        for(i = 0; i < array.length; i++){
           // System.out.println("["+i+"]");
            if (array[i] == item){
                for(j = i+1; j < array.length; j++){
                    if (array[j] != item){
                        array[i] = array[i] + array[j];
                        array[j] = array[i] - array[j];
                        array[i] = array[i] - array[j];
                       // i = j-1;
                        System.out.println("\n after swap " + i +" => " +j);
                        print();
                        break;
                    }
                }
            }
        }
        for(i = array.length-1; i >= 0; i--) {

            if (array [i] == item) {
                array [i] = null;
            }

        }
    }

}
class second_task{
    int lenght;
    char [] str;
    second_task(String inputString){
        lenght = inputString.length();
        str = new char[lenght];
        for(int i = 0; i < lenght; i++){
            str[i] = inputString.charAt(i);
        }

    }
    int get_index(int word_index){
        int k = 0;
        for (int i = 0; i < lenght; i++){
            if(k==word_index) {
                System.out.println(i);
                return i;
                //break;
            }
            if (str[i] == ' ') {
                k++;
            }
        }
        return 0;
    }
    int get_len_word(int char_index){
        int k = 0;
        for (int i = char_index; i < lenght; i++){
            if(str[i] ==' ' || i == lenght){

                break;
            }

            k++;
//
//            if (str[i] == ' ') {
//                k++;
//            }
        }
        return k;
    }
    void swap_word(int index1, int index2){
      //  for(int i = 0; i < lenght-1; i++){
        //int i =0;
        int in1 = get_index(index1); //0
        int in2 = get_index(index2); //8
        int len_word1 = get_len_word(in1)+1;
        int len_word2 = get_len_word(in2)+1;
        System.out.println(len_word1);
        System.out.println(len_word2);



        for(int j =in2; j > in1; j--){

            for (int i = 0; i <len_word2; i++){
                if (j+i != lenght){
                    swap(j+i, j+i-1);
                }




//                swap(j,j-1);
//                swap(j+1,j);
//                swap(j+2,j+1);
//                swap(j+3,j+2);
            }

        }
        print();
        in1 = get_index(index1+1);
        in2 = get_index(index2);
//        for(int j =in2; j >in1; j--){
//
//            for (int i = 0; i <4; i++){
//                if (j+i != lenght){
//                    swap(j+i, j+i-1);
//                  //  print();
//                }
//
//
//
////                swap(j,j-1);
////                swap(j+1,j);
////                swap(j+2,j+1);
////                swap(j+3,j+2);
//            }
////
////        }
//        }

        for(int j =7; j <lenght; j++){

          //  for (int i = 2; i>=0; i++){
//                if (j+i != lenght){
//                    swap(j+i-1, j+i);
//                     print();
//                }

            for (int i = 0; i <4; i++){
                if (j-i+1 != lenght){
                   // swap(j+i, j+i-1);

                    swap(j-i,j-i+1);


//                    swap(j,j+1);
//                    swap(j-1,j);
//                    swap(j-2,j-1);
//                    swap(j-3,j-2);
//


                    print();
                  //  print();
                }
//


           // }
//
            }
        }
        print();
    }
    void swap(int index1, int index2){

        str[index1] = (char) (str[index1] + str[index2]);
        str[index2] = (char) (str[index1] - str[index2]);
        str[index1] = (char) (str[index1] - str[index2]);
    }
    void print() {
        System.out.println(str);
    }
}

public class Main {



    public static void main(String[] args) {
//        first_task task1 = new first_task(12);
//        task1.print();
//        task1.clear(7);
//        task1.print();
        second_task task2 = new second_task("max str cle cly");
        task2.print();
       // task2.swap(0,1);
     //   task2.swap_word(0,2);
        task2.swap_word(0,3);
        task2.print();

    }
}
