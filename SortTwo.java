import java.util.Random;

public class SortTwo {

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void swap(int[] array, int n) {
        for (int i = 0; i < n - 1; i++) {
            if (array[i] > array[i + 1]) {
                swap(array, i, i + 1);
            }
        }
    }

    public static void bubbleSort(int[] array, int n) {
        if (n > 1) {
            swap(array, n);
            bubbleSort(array, n - 1);

        }
    }

    public static void bubbleSort(int[] array) {
        bubbleSort(array, array.length);
    }

    /**
     * @param array
     * @return
     */
    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1])
                return false;
        }
        return true;
    }

    public static int[] createRandomArray(int arrayLength) {

        int[] array = new int[arrayLength];
        Random random = new Random();
        for (int i = 0; i < arrayLength; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    public static int[] mergeArray(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                c[k] = a[i];
                k++;
                i++;
            } else {
                c[k] = b[j];
                k++;
                j++;

            }
        }
        while (i < a.length) {
            c[k] = b[i];
            k++;
            i++;
        }
        while (j < b.length) {
            c[k] = b[j];
            k++;
            j++;
        }

        return c;
    }

    public static void mergeArray(int[] a, int start, int middle, int end) {
        int[] c = new int[end - start];
        int i = start, j = middle, k = 0;
        while (i < middle && j < end) {
            if (a[i] <= a[j]) {
                c[k] = a[i];
                k++;
                i++;
            } else {
                c[k] = a[j];
                k++;
                j++;
            }
        }
        while (i < middle) {
            c[k] = a[i];
            k++;
            i++;
        }

        while (j < end) {
            c[k] = a[j];
            k++;
            j++;
        }
        for (i = start; i < end; i++) {
            a[i] = c[i - start];
        }
    }

    public static void mergeSort(int[] a, int start, int end) {
        if (end - start <= 1) {
            return;
        }
        int middle = (start + end) / 2;
        mergeSort(a, start, middle);
        mergeSort(a, middle, end);
        mergeArray(a, start, middle, end);
    }

    public static void mergeSort(int[] a) {
        mergeSort(a, 0, a.length);
    }

    public static void main(String[] args) throws Exception {
        int arrayLength = 10_000;
        int[] array = createRandomArray(arrayLength);
        long start_time, time_spent;
        start_time = System.currentTimeMillis();
        System.out.println("Before sorting, isSorted(array): " + isSorted(array));
        mergeSort(array);
        time_spent = System.currentTimeMillis() - start_time;
        System.out.println("Merge sort time: " + time_spent + " ms");
       // System.out.println("Before sorting, isSorted(array): " + isSorted(array));
        System.out.println("After sorting, isSorted(array): " + isSorted(array));
        time_spent = System.currentTimeMillis() - start_time;

        // System.out.println("Hello, World!");
    }
}