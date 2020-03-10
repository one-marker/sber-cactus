package tasks.clear_array;


import java.util.Random;

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
    int getIndex(int word_index){
        int k = 0;
        for (int i = 0; i < lenght; i++){
            if(k == word_index) {
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
    int getLenghtByIndex(int char_index){
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

        int in1 = getIndex(index1);
        int in2 = getIndex(index2);
        int len_word1 = getLenghtByIndex(in1)+1;
        int len_word2 = getLenghtByIndex(in2)+1;
        System.out.println(len_word1);
        System.out.println(len_word2);


        //сдвиг справа налево
        int first_index_of_left_word = getIndex(index1);
        int first_index_of_right_word = getIndex(index2);
        int right_word_lenght = getLenghtByIndex(first_index_of_right_word);

        for(int j =first_index_of_right_word; j > first_index_of_left_word; j--){

         //   swap(j, j-1);
            for (int i = 0; i <=right_word_lenght; i++){
                if (j+i != lenght){
                    swap(j+i, j+i-1);
                }
            }
        }







        print();
        in1 = getIndex(1 + index1);
        in2 = getIndex(index2);

        //сдвиг слева направо
        int last_index_of_right_word = getIndex(index2)+ getLenghtByIndex(getIndex(index2));
        int last_index_of_left_word = in1 + getLenghtByIndex(in1);
        int left_word_lenght = getLenghtByIndex(getIndex(index1+1));

        for(int j = last_index_of_left_word; j <last_index_of_right_word; j++){

            for (int i = 0; i <=left_word_lenght; i++){
                if (j-i+1 != lenght){

                    swap(j-i,j-i+1);

                }


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

    void swap_word2(int index1, int index2){
        int head1 = getIndex(index1);
        int head2 = getIndex(index2);

        int sdvig = head2 - head1;

        int from;
        int to;

        int i = 0;
        while (true){

            from  = head1 + i;
            to = from + sdvig;
            if (str[from] == ' ' || str[to] == ' '){
                break;
            }else {
                swap(from, to);
            }

            i++;

        }

    }
}


public class Main {



    public static void main(String[] args) {
//        first_task task1 = new first_task(12);
//        task1.print();
//        task1.clear(7);
//        task1.print();
        //max str cl000000e cly.00
        second_task task2 = new second_task("lol max str");
        task2.print();
       // task2.swap(0,1);
     //   task2.swap_word(0,2);
      //  task2.swap_word(0,5);
        task2.print();
        task2.swap_word2(1,2);
        task2.print();

    }
}
