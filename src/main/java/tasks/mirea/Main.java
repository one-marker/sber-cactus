package tasks.mirea;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

class Symbol implements Comparable{

    int countSyboles = 0;
    String code = "";
    String c = "";
    float p = 0;

    public Symbol( String c,int countSyboles , float p) {
        this.code = code;
        this.countSyboles = countSyboles;
        this.c = c;
        this.p = p;
    }

    public Symbol(String c, float p) {
        this.c = c;
        this.p = p;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public float getP() {
        return p;
    }

    public void setP(float p) {
        this.p = p;
    }
    public void conc(String c){
        this.code +=c;
    }
}

public class Main {

    static ArrayList <Symbol> MainArrayList = new ArrayList<>();
    static Map<String, Symbol> map = new HashMap<>();


    public static void print(ArrayList <Symbol> arrayList){
        for (Symbol a :arrayList
             ) {
            //System.out.println(a.c + " " + a.p );
            System.out.printf("{%s} => %.12f\n", a.c, a.p);
        }
        System.out.println();
    }
    public static void printCode( Map<String, Symbol> m){

        AtomicInteger k = new AtomicInteger();
        AtomicInteger s = new AtomicInteger();


//            for(Map.Entry<String, Symbol> entry : m.entrySet()) {
//                String key = entry.getKey();
//                Symbol value = entry.getValue();
//
//
//                System.out.println(value.c + " " +new StringBuilder(value.code).reverse().toString());
//                s.addAndGet(value.countSyboles);
//                k.addAndGet((value.code.length() * value.countSyboles));
//            }
        m.forEach((key, value) -> {

            System.out.println(value.c + " " + value.countSyboles + " " +new StringBuilder(value.code).reverse().toString());
            s.addAndGet(value.countSyboles);
            k.addAndGet((value.code.length() * value.countSyboles));
        });

        System.out.println(k.get());
        System.out.printf("F= %.12f\n", k.get() /(s.get() *6f) );


    }

    public static void count(ArrayList <Symbol> arrayList) {

        float p = 0;
        for (Symbol s: arrayList
             ) {
            p += s.p;
        }
        System.out.println(p);
    }
    public static void sortBigtoSmall(ArrayList <Symbol> arrayList){
        Collections.sort(arrayList, new Comparator<Symbol>() {
            @Override
            public int compare(Symbol a, Symbol b) {
                if (a.p < b.p)
                    return 1;
                else if (a.p > b.p)
                    return -1;
                else
                    return 0;

            }
        });
    }
    public static void main(String[] args) {



        try(BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);

                String[] s = line.split("\t");
                System.out.println(s[0] + " " + s[2]);
                float f = Float.parseFloat(s[2].replace(',','.'));
               // System.out.println("==== " + Float.toString(f));
                MainArrayList.add(new Symbol(s[0], Float.parseFloat(s[2].replace(',','.'))));
               // map.put(s[0], new Symbol(s[0], Float.parseFloat(s[2].replace(',','.'))));
                map.put(s[0], new Symbol(s[0], Integer.parseInt(s[1]),Float.parseFloat(s[2].replace(',','.'))));
                line = br.readLine();
                //System.out.println("sadad" +Integer.parseInt(s[1]));
            }
            String everything = sb.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        print(MainArrayList);
        //arrayList.sort();
        System.out.println(MainArrayList.size());
        count(MainArrayList);
        sortBigtoSmall(MainArrayList);

        int i=0;
        while(MainArrayList.size()>=2){
            int len = MainArrayList.size();
            String newStr = MainArrayList.get(len - 1).c + " " + MainArrayList.get(len - 2).c;
            float newFloat = MainArrayList.get(len - 1).p + MainArrayList.get(len - 2).p;

            String[] str = MainArrayList.get(len - 1).c.split(" ");
            String[] str2 = MainArrayList.get(len - 2).c.split(" ");
            if (MainArrayList.get(len - 1).p > MainArrayList.get(len - 2).p) {
                for (String s:str) {
                      map.get(s).conc("1");
                }
                for (String s2:str2) {
                    map.get(s2).conc("0");
                }
              //  map.get(MainArrayList.get(len - 1).c).conc("1");
              //  map.get(MainArrayList.get(len - 2).c).conc("0");

            } else {
                for (String s:str) {
                    map.get(s).conc("0");
                }
                for (String s2:str2) {
                    System.out.println(s2);
                    map.get(s2).conc("1");
                }
            }

            MainArrayList.remove(len-1);
            MainArrayList.remove(len-2);
            MainArrayList.add(new Symbol(newStr, newFloat));
            sortBigtoSmall(MainArrayList);
            print(MainArrayList);
            i++;
        }
        //System.out.println(map.get("А").code);
        //System.out.println("Ans: ");

      //  print(MainArrayList);
        printCode(map);
    }


}
