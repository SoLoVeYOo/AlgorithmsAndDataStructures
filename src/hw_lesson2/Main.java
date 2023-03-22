package hw_lesson2;


public class Main {
    public static void main(String[] args) {

        int[] array = ArrayUtils.prepareArray(10);
        ArrayUtils.printArray(array);
        HeapSort.heapSort(array);
        ArrayUtils.printArray(array);

        int[] testArr = ArrayUtils.prepareArray(10000000);
        long startTime = System.currentTimeMillis();
        HeapSort.heapSort(testArr);
        long endTime = System.currentTimeMillis();
        long processingTime = endTime - startTime;
        System.out.printf("Время выполнения сортировки пирамидой: %d мс.\n", processingTime);
    }
}
