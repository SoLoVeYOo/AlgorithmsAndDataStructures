package lesson1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Program {

    public static void main(String[] args) {

        int latNumber = 12;
        AtomicInteger counter = new AtomicInteger();
        System.out.printf("Сумма всех чисел от 1 до %d равна %d; Кол-во итераций: %d\n",
                latNumber, sum1(latNumber, counter), counter.get());

        System.out.printf("Сумма всех чисел от 1 до %d равна %d; Кол-во итераций: 1\n",
                latNumber, sum2(latNumber));

        int a = 2 % 3;
        int b = 3 % 2;
        int c = 3 % 5;

        counter.set(0);

        List<Integer> simpleNumbers = findSimpleNumbers(latNumber, counter);
        for (int e: simpleNumbers){
            System.out.printf("%d\t", e);
        }
        System.out.println();
        System.out.printf("Простые числа на отрезке от 1 до %d; Кол-во итераций: %d\n",
                latNumber, counter.get());

        f(4);

        counter.set(0);

        long startTime = System.currentTimeMillis();
        System.out.printf("(1) Число Фибоначчи для значения %d равно %d; Кол-во итераций %d (РЕКУРСИЯ)\n",
                10, fb1(10, counter), counter.get());
        long endTime = System.currentTimeMillis();
        long processingTime = endTime - startTime;
        System.out.printf("(1) Операция выполнена за %d мс.\n", processingTime);

        counter.set(0);

        startTime = System.currentTimeMillis();
        System.out.printf("(2) Число Фибоначчи для значения %d равно %d; Кол-во итераций %d (РЕКУРСИЯ)\n",
                30, fb1(30, counter), counter.get());
        endTime = System.currentTimeMillis();
        processingTime = endTime - startTime;
        System.out.printf("(2) Операция выполнена за %d мс.\n", processingTime);

        startTime = System.currentTimeMillis();
        System.out.printf("(3) Число Фибоначчи для значения %d равно %d; Кол-во итераций %d (РЕКУРСИЯ)\n",
                43, fb1(43, counter), counter.get());
        endTime = System.currentTimeMillis();
        processingTime = endTime - startTime;
        System.out.printf("(3) Операция выполнена за %d мс.\n", processingTime);

        counter.set(0);

        startTime = System.currentTimeMillis();
        System.out.printf("(1) Число Фибоначчи для значения %d равно %d; Кол-во итераций %d\n",
                10, fb2(10, counter), counter.get());
        endTime = System.currentTimeMillis();
        processingTime = endTime - startTime;
        System.out.printf("(1) Операция выполнена за %d мс.\n", processingTime);

        counter.set(0);

        startTime = System.currentTimeMillis();
        System.out.printf("(2) Число Фибоначчи для значения %d равно %d; Кол-во итераций %d\n",
                30, fb2(30, counter), counter.get());
        endTime = System.currentTimeMillis();
        processingTime = endTime - startTime;
        System.out.printf("(2) Операция выполнена за %d мс.\n", processingTime);

        counter.set(0);

        startTime = System.currentTimeMillis();
        System.out.printf("(3) Число Фибоначчи для значения %d равно %d; Кол-во итераций %d\n",
                43, fb2(43, counter), counter.get());
        endTime = System.currentTimeMillis();
        processingTime = endTime - startTime;
        System.out.printf("(3) Операция выполнена за %d мс.\n", processingTime);

    }

    /**
     * [1] Необходимо написать алгоритм, считающий сумму всех чисел от 1 до N.
     */
    public static int sum1(int lastNumber, AtomicInteger counter){
        int sum = 0;
        for (int i = 1; i <= lastNumber; i++){
            sum += i;
            counter.getAndIncrement(); // +1
        }
        return sum;
    }

    public static int sum2(int lastNumber){
        return ((1 + lastNumber) * lastNumber) /2;
    }

    /**
     * [2] Написать алгоритм поиска простых чисел (делятся только на себя и на 1 без остатка)
     *      * в диапазоне от 1 до N.
     *
     *
     *      1 2 3 4 5 6 7 8
     */
     public static List<Integer> findSimpleNumbers(int lastNumber, AtomicInteger counter) {

         List<Integer> numbers = new ArrayList<>();
         for (int i = 1; i <= lastNumber; i++){
             boolean simple = true;
             for (int j = 2; j < i; j++){
                 counter.getAndIncrement(); //+1
                 if (i % j == 0){
                     simple = false;
                     break;
                 }
             }
             if (simple){
                 numbers.add(i);
             }
         }
         return numbers;
     }

    /**
     * n = 4
     * @param n
     */
     static void f(int n) {
         System.out.println(n);
         if (n >= 3) {
             f(n - 1);
             f(n - 2);
             f(n - 2);
         }

     }

    /**
     *  Числа Фибоначчи
     *
     *  0 1 2 3 4 5 6  7  8  9 10 ...
     *
     *  0 1 1 2 3 5 8 13 21 34 55 ...
     */
    static long fb1(int num, AtomicInteger counter){
        counter.getAndIncrement(); // + 1
        if (num == 0 || num == 1) return num;
        return fb1(num - 1, counter) + fb1(num - 2, counter);
    }

    static long fb2(int num, AtomicInteger counter){
        if (num == 0 || num == 1) return num;
        long[] numbers = new long[num + 1];
        numbers[0] = 0;
        numbers[1] = 1;
        for (int i = 2; i <= num; i++){
            numbers[i] = numbers[i - 1] + numbers[i - 2];
            counter.getAndIncrement();
        }
        return numbers[num];
    }


}
