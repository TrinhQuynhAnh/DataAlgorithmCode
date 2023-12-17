public class Searching {
    public static<T extends Comparable<T>> boolean LinearSearch(T[] data, int min, int max, T targetElement) {
        boolean found = false;
        int index = min;
        while (!found && index <= max) {
            found = data[index].equals(targetElement);
            index++;
        }
        return found;
    }
    public static<T extends Comparable<T>> boolean binarySearch(T[] data, int min, int max, T target) {
        boolean found = false;
        int midpoint = (min + max) / 2;
        if (data[midpoint].compareTo(target) == 0) {
            found = true;
        } else if (data[midpoint].compareTo(target) > 0) {
            found = binarySearch(data, min, midpoint - 1, target);
        } else {
            found = binarySearch(data, midpoint + 1, max, target);
        }
        return found;
    }
}