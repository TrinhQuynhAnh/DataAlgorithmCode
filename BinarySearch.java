public class BinarySearch {
    /**
        * Searches the specified array of objects using a binary search algorithm.
        * @param data the array to be searched
        * @param min the integer representation of the minimum value 
        * @param max the integer representation of the maximum value
        * @param target the element being searched for
        * @return true if the desired element is found
    */
    public static <T extends Comparable <T>> boolean BinarySearch (T[] data, int min, int max, T target) {
        boolean found = false;
        int midpoint = (min + max) / 2;
        if (data[midpoint].compareTo(target) == 0) {
            found = true;
        } else if (data[midpoint].compareTo(target) > 0) {
            if (min <= midpoint - 1) {
                found = BinarySearch (data, min, midpoint - 1, target);
            }
        } else if (midpoint + 1 <= max) {
            found = BinarySearch(data, midpoint + 1, max, target);
        }
        return found;
    }
}