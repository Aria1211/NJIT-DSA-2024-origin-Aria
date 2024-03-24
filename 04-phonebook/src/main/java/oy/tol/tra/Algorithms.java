package oy.tol.tra;

import java.util.Comparator;
import java.util.function.Predicate;

public class Algorithms {
    
    public static <T> void reverse(T[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        
        int i = 0;
        while (i < array.length / 2) {
            swap(array, i, array.length - i - 1); 
            i++;
        }
    }

    public static <T extends Comparable<T>> void sort(T[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        
        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    flag = false;
                    swap(array, j, j + 1);
                }
            }
            if (flag == true) {
                break;
            }
        }
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
                swap(array, i, j);
            }
        }
    
        swap(array, i + 1, end);
    
        return i + 1;
    }

    public static <T> int partitionByRule(T[] array, int count, Predicate<? super T> rule) {
        int index = 0;
        for (index = 0; index < count; index++) {
            if (rule.test(array[index])) {
                break;
            }
        }
        if (index >= count) {
            return count;
        }
        int nextIndex = index + 1;
        while (nextIndex != count) {
            if (!rule.test(array[nextIndex])) {
                swap(array, index, nextIndex); 
                index++;
            }
            nextIndex++;
        }
        return index;
    }
    
    public static void sortWithComparator(Person[] array, Comparator<Person> comparator) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (comparator.compare(array[j], array[j + 1]) > 0) {
                    swap(array, j, j + 1); 
                }
            }
        }
    }

    public static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}