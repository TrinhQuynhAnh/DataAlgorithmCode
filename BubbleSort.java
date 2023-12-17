import java.util.Arrays;

public class BubbleSort {
    public static <T extends Comparable<T>> void bubbleSort(T[] data) {
        int pos, scan;
        T temp;
        for (pos = data.length - 1; pos >= 0; pos--) {
            for (scan = 0; scan <= pos - 1; scan++) {
                if (data[scan].compareTo(data[scan + 1]) > 0) {
                    swap(data, scan, scan + 1);
                }
            }
        }
    }

    private static <T extends Comparable<T>> void swap(T[] data, int index1, int index2) {
        T temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }
    public static void main(String[] args) {
        Integer[] arr = {5, 2, 9, 1, 5, 6};
        System.out.println("Before sorting: " + Arrays.toString(arr));
        BubbleSort.bubbleSort(arr);
        System.out.println("After sorting: " + Arrays.toString(arr));
    }
}