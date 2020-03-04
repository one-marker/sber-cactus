package ru.marker;


public class Main
{
    public static int smthDo()
    {
        try {
            throw (new RuntimeException());
        }
        finally {
            // return -1;
        }
    }
    public static void main(String[] args)
    {

//
//        List list1 = new List();
//        List list2 = new List();
//
//        list1.push(new Node(121));
//        list1.push(new Node(0203));
//        list1.push(new Node(192));
//
//        list2.push(new Node(12));
//
//        list2.push_back(new Node(324));
//
//
//        list1.combineList(list2,new Node(65));
//        list1.combineList(list2,new Node(652));
//        list1.combineList(list2,new Node(652));
//
//        list2.push_back(new Node(3244));
//        list2.pop_back();
//        list2.pop_back();
//        list2.pop_back();
//
//
//        System.out.println("Первый список:");
//        list1.print();
//
//        System.out.println("Второй список:");
//        list2.print();
//
//        //0-ая задача
//        System.out.println("Значение у связанного узла: " + list1.findCommonNode(list2).getData());
//
//
//        System.out.println("Индекс по значению: " + list2.byValue(list1.findCommonNode(list2)));
//
//        System.out.println("Значение по индексу: " + list2.byIndex(7).getData());
//
//
//        System.out.println(list1.insertAt(2,new Node(0)));
//
//        System.out.println("Первый список:");
//        list1.print();
//        //System.out.println(list1.removeAt(1));
//
//        list1.swap(0,0);
//        System.out.println("Значение по индексу: " + list1.byIndex(1).getData());
//        System.out.println("Первый список:");
//        list1.print();
//
//
//
//        int i1 = 0;
//        int j1 = i1;
//        i1 = 6;
//
//        Integer i = new Integer(7);
//        Integer j = i;
//        i = 9;
//
//        String s1 = "строка";
//        String s2 = s1;;
//
//        s1 = "Hello";
//
//        System.out.println(j1);
//
//
//        Polimorfism.check();
//        Incapsulation.check();
//
        Zoo zoo = new Zoo();
        zoo.start();



//
//
//        Integer i = new Integer(7);
//        Integer i1 = new Integer(i + (2147483647+1)*2);
//
//        String h = "h";
//        Object n = new Object();
//        Object n1 = new Object();
//        System.out.println(n.getClass().toString());
//        System.out.println(n.getClass().toString());
//        System.out.println(i);
//        System.out.println(i1);
//
//        System.out.println(i.hashCode());
//        System.out.println(i1.hashCode());
//        System.out.println(i.equals(i1));
//        System.out.println(h.hashCode());
//
//        Error r;
//        try
//        {
//            n.wait();
//        }
//        catch (Throwable e)
//        {
//            System.out.println(e);
//        }
//        finally
//        {
//            System.out.println("finaly");
//        }

//        System.out.println(smthDo());
//
//
//        System.out.println("hello");
//        Cloneable c;
    }


}