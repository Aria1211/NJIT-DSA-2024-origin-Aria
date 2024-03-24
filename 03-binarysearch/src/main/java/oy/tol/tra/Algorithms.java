package oy.tol.tra;

public class Algorithms {
    
    public static <T extends Comparable<T>> void sort(T[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        
        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    flag = false;
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            if (flag == true) {
                break;
            }
        }
    }

    public static <T> void reverse(T[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        
        int i = 0;
        while (i < array.length / 2) {
            T temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
            i++;
        }
    }

    public static <T extends Comparable<T>> int binarySearch(T aValue, T[] fromArray, int fromIndex, int toIndex) {
        while (fromIndex <= toIndex) {
            int mid = fromIndex + (toIndex - fromIndex) / 2;
            int cmp = aValue.compareTo(fromArray[mid]);
            
            if (cmp == 0) {
                return mid;
            } else if (cmp < 0) {
                toIndex = mid - 1; 
            } else {
                fromIndex = mid + 1;
            }
        }
        
        return -1; 
    }

    public static <T extends Comparable<T>> void fastSort(T[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> void quickSort(T[] array, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(array, begin, end);
            quickSort(array, begin, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, end);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] array, int begin, int end) {
        T pivot = array[end];
        int i = begin - 1;

        for (int j = begin; j < end; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        T temp = array[i + 1];
        array[i + 1] = array[end];
        array[end] = temp;

        return i + 1;
    }

}