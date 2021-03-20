package junit5Testing.revision;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BubbleSort {

    public static void main(String[] args) {


        String[] arr = {"ala", "a", ""};


        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.sort(Integer::compareTo);
        list.stream().sorted().collect(Collectors.toList());
        list.sort(Comparator.naturalOrder());

    }


    public static int task02(String[] arr) {
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("")) {
                return 0;
            } else {
                if (arr[i].length() > max) {
                    max = arr[i].length();
                }
            }
        }
        return max;

    }


    public static int[] sort(int[] arr) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    isSorted = false;

                    int buff = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buff;
                }
            }
        }

        return arr;
    }
}
