package tasks.my;


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
        for(int i=0; i< array.length; i++){
           System.out.println(array[i] + "["+i+"]");
        }
        System.out.println("------------");
    }
    public void clearItem(int item){
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
    public void clearItem2(int item){

        for(int i = array.length-1; i >= 0; i--){
            // System.out.println("["+i+"]");
            if (array[i] != item){
                for(int j =i-1; j >= 0; j--){
                    if (array[j] == item){

                        array[i] = array[i] + array[j];
                        array[j] = array[i] - array[j];
                        array[i] = array[i] - array[j];

                        System.out.println("\n after swap " + i +" => " +j);
                        print();

                        break;
                    }

                }
            }
        }


        for(int i = array.length-1; i >= 0; i--) {

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
                return i;
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

        }
        return k;
    }
    void swap_word(int index1, int index2){



        //сдвиг справа налево
        int first_index_of_left_word = getIndex(index1);
        System.out.println(first_index_of_left_word);
        int first_index_of_right_word = getIndex(index2);

        int right_word_lenght = getLenghtByIndex(first_index_of_right_word);
        int left_word_lenght = getLenghtByIndex(first_index_of_left_word);
        //Если длины слов равны
        if(left_word_lenght == right_word_lenght){
            swap_equal_lenght(index1,index2);
            System.out.println("O(n)");
            return;
        }


        for(int j =first_index_of_right_word; j > first_index_of_left_word; j--){
            for (int i = 0; i <=right_word_lenght; i++){
                if (j+i != lenght){
                    swap(j+i, j+i-1);
                }
            }
        }


        print("После сдвига справа налево");
        //сдвиг слева направо
        ++index1;
        int indexL_after_swap = getIndex(index1);


        int last_index_of_right_word = first_index_of_right_word + getLenghtByIndex(first_index_of_right_word);
        int last_index_of_left_word = indexL_after_swap + getLenghtByIndex(indexL_after_swap);
        left_word_lenght = getLenghtByIndex(indexL_after_swap);

        for(int j = last_index_of_left_word; j <last_index_of_right_word; j++){
            for (int i = 0; i <=left_word_lenght; i++){
                if (j-i+1 != lenght){
                    swap(j-i,j-i+1);
                }
            }
        }
        print("После сдвига слева направо");
    }
    void swap(int index1, int index2){
        str[index1] = (char) (str[index1] + str[index2]);
        str[index2] = (char) (str[index1] - str[index2]);
        str[index1] = (char) (str[index1] - str[index2]);
    }
    void print(String message) {
        System.out.println("Message: " + message);
        System.out.println(str);
    }
    void print() {
        System.out.println(str);
    }

    void swap_equal_lenght(int index1, int index2){
        int head1 = getIndex(index1);
        int head2 = getIndex(index2);
        int from;
        int to;

        int i = 0;
        while (true){
            from  = head1 + i;
            to = from + head2 - head1;;
            if (str[from] == ' ' || str[to] == ' '){
                break;
            }
            else {
                swap(from, to);
            }

            i++;

        }

    }


    void reverse(int index1, int index2){
        System.out.println(index1+ " - "+ index2);
        for(int i = 0; i<= (index2-index1)/2; i++){
           // if((index1+i)!=(index2-i))
            int i1 = index1+i;
            int i2 = index2-i;
            System.out.println(i1+ " "+ i2);
            if(i1 == i2+1)
                break;
            if(i1 == i2)
                break;

            swap(i1,i2);

        }
    }

    void new_swap(int index1, int index2){
        int head1 = getIndex(index1);
        int tail2 = getIndex(index2) + getLenghtByIndex(getIndex(index2)+1);
       // System.out.println("head " + head1+ " tail " + tail2);
        reverse(head1,tail2);
       // print();
        int tmpHead = head1;
        for (int i = head1; i <= tail2+1; i++){
            if(i>= lenght)
                break;;
            if(str[i]==' '){
                reverse(tmpHead,i-1);
               // System.out.println("Head: " + tmpHead + "; End:" + (i-1));
                tmpHead = i+1;

            }


        }
    }
}


public class Main {



    public static void main(String[] args) {
        first_task task1 = new first_task(12);
//        task1.print();
//        task1.clearItem2(7);
//        task1.print();
        //max str cl000000e cly.00
        second_task task2 = new second_task("loj max str 3");
        task2.print();

       // task2.swap_word(0,2);
       // task2.new_swap(0,2);
       // task2.reverseAll();
        task2.new_swap(0,3);
//     //   task2.swap_word(0,2);
        //task2.reverse(3,7);
//      //  task2.swap_word(0,5);
        task2.print();
//        task2.swap_word2(1,2);
//        task2.print();

        //сериализация
    }
}


