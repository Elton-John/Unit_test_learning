package junit5Testing.revision;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10};
        System.out.println(binarySearch(arr, 2));
        System.out.println(binarySearch(arr, 3));
        System.out.println(binarySearch(arr, 10));
        System.out.println(binarySearchWithRecursion(arr, 2, 0, arr.length - 1));
        System.out.println(binarySearchWithRecursion(arr, 3, 0, arr.length - 1));
        System.out.println(binarySearchWithRecursion(arr, 10, 0, arr.length - 1));


    }

    public static int binarySearch(int[] arr, int key) {

        if (!isSorted(arr)) {
            throw new IllegalArgumentException("array must be sorted");
        }

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (key < arr[mid]) {
                high = mid - 1;
            } else if (key > arr[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static int binarySearchWithRecursion(int[] sortedArr, int key, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;

        if (key < sortedArr[mid]) {
            return binarySearchWithRecursion(sortedArr, key, low, mid - 1);
        } else if (key > sortedArr[mid]) {
            return binarySearchWithRecursion(sortedArr, key, mid + 1, high);
        } else {
            return mid;
        }

    }
}
