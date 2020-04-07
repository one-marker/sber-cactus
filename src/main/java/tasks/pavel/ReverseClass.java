package tasks.pavel;

public class ReverseClass {
    public static String reverseWords(String data)
    {
        Integer last_index = data.length();
        String new_str = "";

        for (int i = data.length()-1; i >=0; i--)
        {
            if (data.charAt(i) == ' ')
            {
                int voids_index = i;
                while (data.charAt(voids_index) == ' ')
                {
                    voids_index--;
                }
                new_str = new_str.concat(data.substring(i+1, last_index));
                new_str = new_str.concat(data.substring(voids_index+1, i+1));
                i = voids_index+1;
                last_index = voids_index+1;
            }
            else if(i == 0 && data.charAt(i) != ' ')
            {
                new_str = new_str.concat(data.substring(i, last_index));
            }
        }

        return new_str;
    }

    public static char[] reverse(char[] data)
    {
        for (int i = 0; i < data.length/2; i++)
        {
            char tmp = data[i];
            data[i] = data[data.length-1-i];
            data[data.length-1-i] = tmp;
        }

        return data;
    }

    public static char[] reverse(char[] data, Integer start, Integer end)
    {

        for (int x = 0; x < (end-start)/2; x++)
        {
            char tmp = data[start + x];
            data[start + x] = data[end-x];
            data[end - x] = tmp;
        }

        return data;
    }

    public static String reverseWords1(char[] data)
    {
        Integer last_index = data.length-1;

        for (int i = data.length-1; i >=0; i--)
        {
            if (data[i] == ' ')
            {
                data = reverse(data, i+1, last_index);

                while (data[i] == ' '){i--;}
                last_index = i;
            }
            else if(i == 0 && data[i] != ' ')
            {
                data = reverse(data, i, last_index);
            }
        }
        return new String(reverse(data));
    }

    public static StringBuilder reverseWords1(StringBuilder data)
    {
        Integer last_index = data.length()-1;

        for (int i = data.length()-1; i >=0; i--)
        {

        }
        return data.reverse();
    }
}
