import Queue.slidingWindow;

public class Sorting {
    private static <T extends Comparable<T>> void swap(T[] data, int index1, int index2) {
        T temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }
    public static <T extends Comparable<T>> void bubbleSort(T[] data) {
        for (int pos = data.length - 1; pos > 0; pos--) {
            for (int scan = 0; scan < pos; scan++) {
                if (data[scan].compareTo(data[scan + 1]) > 0) {
                    swap(data, scan, scan + 1);
                }
            }
        }
    }
    public static <T extends Comparable<T>> void quickSort(T[] data, int min, int max) {
        int pivot;
        if (min < max) {
            pivot = partition(data, min, max);
            quickSort(data, min, pivot - 1);
            quickSort(data, pivot + 1, max);
        }
    }
    private static <T extends Comparable<T>> int partition(T[] data, int min, int max) {
        int mid = (min + max) / 2;
        T partitionElement = data[mid];
        swap(data, min, mid);
        int left, right;
        left = min;
        right = max;
        while (right > left) {
            while (left < right && data[left].compareTo(partitionElement) < 0) {
                left++;
            }
            while (data[right].compareTo(partitionElement) >= 0) {
                right--;
            }
            if (right > left) {
                swap(data, left, right);
            }
        }
        swap(data, min, right);
        return right;
    }
}
