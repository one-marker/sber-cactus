package tasks.pavel;

public class Main {
    public static void main(String[] args) {
	    OwnArray fa = new OwnArray(new int[]{7,2,2,2,2,2,2,2,2,27,7,1,7,7,2,3,7,4,5,6,7,7,7,7,8,9,7,10,7});
	    fa.print();
	    fa.deleteItem(7);
	    fa.print();
        fa.deleteItem(2);
        fa.print();

        System.out.println("input string: " + "Hello for            Anton and    Sberbank");
        System.out.println("first alg: " + ReverseClass.reverseWords("Hello for            Anton and    Sberbank"));
        System.out.println("second alg: " + ReverseClass.reverseWords1("Hello for            Anton and    Sberbank".toCharArray()));
        System.out.println("third alg: " + ReverseClass.reverseWords1(new StringBuilder("Hello for            Anton and    Sberbank")));
    }
}
