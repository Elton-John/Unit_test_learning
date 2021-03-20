package junit5Testing.revision;

import java.util.Arrays;

public class Solution1 {

    class Solution {
        public int solution(int[] arr) {
            int minDiff = Integer.MAX_VALUE;

            for (int i = 1; i < arr.length; i++) {
                int[] arr1 = Arrays.copyOfRange(arr, 0, i);
                int[] arr2 = Arrays.copyOfRange(arr, i, arr.length);
                int sum1 = Arrays.stream(arr1).reduce(0, Integer::sum);
                int sum2 = Arrays.stream(arr2).boxed().mapToInt(Integer::intValue).sum();
                int diff = Math.abs(sum1 - sum2);
                if (diff < minDiff) {
                    minDiff = diff;
                }
            }
            return minDiff;
        }
    }

}
