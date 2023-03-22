package hw_lesson2;


public class HeapSort {

    public static void heapSwap(int[] arrayInto, int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int bigger = i;

        if (left < size && arrayInto[left] > arrayInto[i]) {
            bigger = left;
        }
        if (right < size && arrayInto[right] > arrayInto[bigger]) {
            bigger = right;
        }

        if (bigger != i) {
            int temp = arrayInto[i];
            arrayInto[i] = arrayInto[bigger];
            arrayInto[bigger] = temp;

            heapSwap(arrayInto, bigger, size);
        }
    }

    public static int heapPop(int[] arrayInto, int size) {
        if (size <= 0) {
            return -1;
        }
        int top = arrayInto[0];

        arrayInto[0] = arrayInto[size-1];

        heapSwap(arrayInto, 0, size - 1);
        return top;
    }


    public static void heapSort(int[] arrayInto) {
        int n = arrayInto.length;

        int i = (n - 2) / 2;
        while (i >= 0) {
            heapSwap(arrayInto, i--, n);
        }

        while (n > 0) {
            arrayInto[n - 1] = heapPop(arrayInto, n);
            n--;
        }
    }
}