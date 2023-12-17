import java.util.Arrays;

public class SelectionSort {
    public static <T extends Comparable<T>> void selectionSort(T[] data) {
        int min;
        T temp;
        for (int index = 0; index < data.length - 1; index++) {
            min = index;
            for (int scan = index + 1; scan < data.length; scan++) {
                if (data[scan].compareTo(data[min]) < 0) {
                    min = scan;
                }
            }
            swap(data, min, index);
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
        SelectionSort.selectionSort(arr);
        System.out.println("After sorting: " + Arrays.toString(arr));
    }
}