package tasks.my;

import java.util.ArrayList;
import java.util.Random;

public class ArrayTask {

    Integer[] array;
    public ArrayTask(int size) {
        Random random = new Random();
        random.setSeed(12232);
        array = new Integer[size];

        for(int i = 0; i < size; i++){
            array[i] = random.nextInt(10);
        }

    }
    public void print(){
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i] + "[" + i + "]");
        }
        System.out.println("------------");
    }
    public void sort(int item) {
        int cursor_start = 0, cursor_end = 0;
        for (int i = 0; i < array.length; i++) {

            if (array[i] == item) {
                if (i == 0) {
                    cursor_start = cursor_end = 0;
                } else if (array[i - 1] != item) {
                    cursor_start = cursor_end = i;
                }
                cursor_end++;
            } else if (cursor_start != 0 || cursor_end != 0) {

                swap(cursor_start, cursor_end);

                cursor_start++;
                cursor_end++;
            }
        }
    }


    public void swap(int index1, int index2)
    {
        System.out.println("Swap " + index1 + " to " + index2);

        int tmp = array[index2];
        array[index2] = array[index1];
        array[index1] = tmp;

        print();
    }
}
