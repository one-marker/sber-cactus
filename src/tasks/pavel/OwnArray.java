package tasks.pavel;

import java.util.ArrayList;

public class OwnArray {

    private int[] array;
    private Integer length;
    private Integer size;

    public OwnArray(int[] _array)
    {
        array = _array;
        this.size = _array.length;
        this.length = _array.length;
    }

    public void swap(int index_1, int index_2)
    {
        this.array[index_1] += this.array[index_2];
        this.array[index_2] = this.array[index_1] - this.array[index_2];
        this.array[index_1] -= this.array[index_2];
    }

    public Integer get(int index)
    {
        if (index > this.length || index < 0)
        {
            return null;
        }
        return this.array[index];
    }

    public void set(int index, int value)
    {
        if (index < this.size || index >= 0) {
            if (this.length <= index)
            {
                this.array[this.length] = value;
                this.length++;
            }
            this.array[index] = value;
        }
    }

    public void deleteItem(int item)
    {
        int index_start=0, index_end=0;
        for (int i = 0; i < this.length; i++) {

            if (this.array[i] == item)
            {
                if (i == 0)
                {
                    index_start = index_end = 0;
                }
                else if (this.array[i-1] != item)
                {
                    index_start = index_end = i;
                }
                index_end++;
            }
            else if (index_start != 0 || index_end != 0)
            {
                this.swap(index_start, index_end);
                //this.print();
                index_start++;
                index_end++;
                //System.out.println("start " + index_start + "\t" + "end " + index_end);
            }
        }

        this.length = index_start;
    }

    public void print()
    {
        for (int i = 0; i < this.length; i++)
        {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
