package hw_lesson2;

import java.util.Random;

public class ArrayUtils {
    private static final Random random = new Random();
    /**
     * Подготовить массив случайных чисел
     *
     * @return
     */
    public static int[] prepareArray() {
        int[] arr = new int[random.nextInt(16) + 5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(101) - 50;
        }
        return arr;
    }

    /**
     * Подготовить массив случайных чисел
     *
     * @param length кол-во элементов
     * @return
     */
    public static int[] prepareArray(int length) {
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(101) - 50;
        }
        return arr;
    }


    /**
     * Распечатать массив на экран
     *
     * @param arr
     */
    public static void printArray(int[] arr) {
        for (int e : arr) {
            System.out.printf("%d\t", e);
        }
        System.out.println();
    }
}