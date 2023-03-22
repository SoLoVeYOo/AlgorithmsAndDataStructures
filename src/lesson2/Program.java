package lesson2;

import java.util.Arrays;
import java.util.Random;

public class Program {


    private static final Random random = new Random();

    public static void main(String[] args) {

        int[] arr = ArrayUtils.prepareArray();
        ArrayUtils.printArray(arr);
        // Сортировка выбором
        SortUtils.directSort(arr);
        ArrayUtils.printArray(arr);

        // Быстрая сортировка
        arr = ArrayUtils.prepareArray();
        ArrayUtils.printArray(arr);
        SortUtils.quickSort(arr);
        ArrayUtils.printArray(arr);

        int[] testArr = ArrayUtils.prepareArray(100000);
        long startTime = System.currentTimeMillis();
        //HeapSort.directSort(testArr.clone());
        long endTime = System.currentTimeMillis();
        long processingTime = endTime - startTime;
        System.out.printf("Время выполнения сортировки выбором: %d мс.\n", processingTime);

        startTime = System.currentTimeMillis();
        SortUtils.quickSort(testArr.clone());
        endTime = System.currentTimeMillis();
        processingTime = endTime - startTime;
        System.out.printf("Время выполнения быстрой сортировки: %d мс.\n", processingTime);

        startTime = System.currentTimeMillis();
        Arrays.sort(testArr.clone());
        endTime = System.currentTimeMillis();
        processingTime = endTime - startTime;
        System.out.printf("Время выполнения системной сортировки: %d мс.\n", processingTime);

        int[] testArr2 = new int[]{-5, 100, -1, 3, 4, 5, 9, 22, 9, 101, -6};
        ArrayUtils.printArray(testArr2);
        SortUtils.quickSort(testArr2);
        ArrayUtils.printArray(testArr2);
        int searchElement = 9;
        int res01 = SearchUtils.binarySearch(testArr2, searchElement);
        System.out.printf("Элемент %d %s\n", searchElement,
                res01 >= 0 ? String.format("найден в массиве п индексу %d", res01) :
                "не найден");
    }


    static class ArrayUtils{

        /**
         * Подготовить массив случайных чисел
         * @return
         */
        static int[] prepareArray(){
            int[] arr = new int[random.nextInt(16) + 5];
            for (int i = 0; i < arr.length; i++){
                arr[i] = random.nextInt(101) - 50;
            }
            return arr;
        }

        /**
         * Подготовить массив случайных чисел
         * @param length кол-во элементов
         * @return
         */
        static int[] prepareArray(int length){
            int[] arr = new int[length];
            for (int i = 0; i < arr.length; i++){
                arr[i] = random.nextInt(101) - 50;
            }
            return arr;
        }


        /**
         * Распечатать массив на экран
         * @param arr
         */
        static void printArray(int[] arr){
            for (int e: arr) {
                System.out.printf("%d\t", e);
            }
            System.out.println();
        }

    }

    static class SortUtils{


        /**
         * Сортировка выбором
         * @param arr
         */
        static void directSort(int[] arr){
            for (int i = 0; i < arr.length; i++){
                int save = i;
                for (int j = i + 1; j < arr.length; j++){
                    if (arr[j] < arr[save])
                        save = j;
                }
                if (save != i){
                    int buf = arr[i];
                    arr[i] = arr[save];
                    arr[save] = buf;
                }
            }
        }

        static void quickSort(int[] arr){
            quickSort(arr, 0, arr.length - 1);
        }

        private static void quickSort(int[] arr, int start, int end){
            int left = start;
            int right = end;
            int middle = arr[(start + end) / 2];
            do{
                while (arr[left] < middle){
                    left++;
                }
                while (arr[right] > middle){
                    right--;
                }

                if (left <= right){

                    if (left < right){
                        int buf = arr[left];
                        arr[left] = arr[right];
                        arr[right] = buf;
                    }
                    left++;
                    right--;
                }
            }
            while (left <= right);
            if (left < end){
                quickSort(arr, left, end);
            }
            if (start < right){
                quickSort(arr, start, right);
            }
        }


    }


    static class SearchUtils{

        static int binarySearch(int[] array, int value){
            return binarySearch(array, value, 0, array.length - 1);
        }


        static int binarySearch(int[] array, int value, int left, int right){
            if (right < left){
                return -1;
            }
            int middle = (left + right) / 2;

            if (array[middle] == value){
                return  middle;
            }
            else if (array[middle] < value){
                return binarySearch(array, value, middle + 1, right);
            }
            else {
                return binarySearch(array, value, left, middle - 1);
            }
        }


    }

}
