public class ForValue {    public static void main(String[] args) {        // The Wrapper are immutable        // Every primitive variable is passed by value        Integer i = 10;        System.out.println("initialized the value i = " + i);        test(i);        System.out.println("finished the value i = " + i);    }    public static void test(Integer i){        System.out.println("initialized the test method = " + i);        i = 35;        System.out.println("i = " + i);    }}