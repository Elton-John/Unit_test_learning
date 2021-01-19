package test01;

public class FirstClassForTesting {
    public static void main(String[] args) {

    }

    public static String getFirstHalf(String s) {
        return s.substring(0, s.length() / 2);
    }

    public static String getSecondHalf(String s) {
        return s.substring( s.length() / 2);
    }
}
