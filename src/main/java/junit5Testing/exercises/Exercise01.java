package junit5Testing.exercises;

import java.util.Arrays;


public class Exercise01 {

    public static void main(String[] args) {
        //  System.out.println(countDuplicateLetters("wbbbn"));

        //System.out.println(reduce(1, "bac"));
        //  System.out.println(challenge02("cccc"));
        //  System.out.println(challenge02("abcabc"));
        System.out.println(challenge03("(hello))"));
        System.out.println(challenge03("(hello(hello))"));

    }

    public static String maxAndMin(String numbers) {
        int max = Arrays.stream(numbers.split(" "))
                .mapToInt(Integer::parseInt)
                .max()
                .getAsInt();
        int min = Arrays.stream(numbers.split(" "))
                .mapToInt(Integer::parseInt)
                .min()
                .getAsInt();

        return String.format("%d %d", max, min);
    }

    ////////01/////////

    public static String countDuplicateLetters(String givenLine) {
        StringBuilder builder = new StringBuilder();
        int count = 1;
        char actual;
        char next;
        int i = 0;
        while (i < givenLine.length()) {
            if (hasNextLetter(i, givenLine)) {
                actual = givenLine.charAt(i);
                next = givenLine.charAt(i + 1);
                if (actual == next) {
                    count++;
                } else {
                    builder.append(count).append(actual);
                    count = 1;
                }
            } else {
                builder.append(count).append(givenLine.charAt(i));
            }
            i++;
        }
        return builder.toString();
    }



    public static boolean hasNextLetter(int index, String line) {
        return index != line.length() - 1;
    }

    ////////02/////////

    public static String challenge02(String given) {
        StringBuilder builder = new StringBuilder(given);
        int i = 0;
        char start;
        char next;
        while (hasNextLetter(i, builder.toString())) {
            start = builder.charAt(i);
            next = builder.charAt(i + 1);

            if (start == next) {
                i++;
            } else {
                builder = reduce(i, builder.toString());
                i = 0;
            }
        }
        return String.valueOf(builder.length());
    }

    public static StringBuilder reduce(int index, String given) {
        char start = given.charAt(index);
        char next = given.charAt(index + 1);
        String replacement;
        if ((start + next) == ('a' + 'b')) {
            replacement = "c";
        } else if ((start + next) == ('b' + 'c')) {
            replacement = "a";
        } else {
            replacement = "b";
        }

        StringBuilder builder = new StringBuilder(given);
        builder.deleteCharAt(index);
        builder.replace(index, index + 1, replacement);


        return builder;
    }

    ////////03/////////

    public static int challenge03(String given) {
        int numberOfLeftBrackets = countElementsInLine('(', given);
        int numberOfRightBrackets = countElementsInLine(')', given);

        if (numberOfLeftBrackets == numberOfRightBrackets) {
            return 1;
        }
        return 0;
    }

    private static int countElementsInLine(char element, String given) {
        int count = 0;
        for (int i = 0; i < given.length(); i++) {
            if (given.charAt(i) == element) {
                count++;
            }
        }
        return count;
    }


}
