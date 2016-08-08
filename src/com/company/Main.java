package com.company;

import java.util.concurrent.TimeUnit;

public class Main {

    final static long MINUTE = 60000l;


    public static void main(String[] args) {
        /*
         * Выясните экспериментальном путём, начиная с какого элемента последовательности Фибоначчи,
         *  вычисление с использованием рекурсии становится неприемлемым
         *  (занимает более минуты по времени).
         *  (Использовать для замера времени System.currentTimeMillis()
         *  который возвращает время в миллисекундах)
         *
         *
         */
        long startTime = System.currentTimeMillis();



        System.out.println("Началось в " + startTime);


        calcFibonacci(args);

        long currentTime = System.currentTimeMillis();
        System.out.println(" текущее:  " + currentTime );

        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println(" прошло :  "  +  elapsedTime  + " миллисекунд");

        if (elapsedTime >= MINUTE) {
            System.out.println(" Минута! Дальнейшее вычисление неприемлемо");
        } else {
            System.out.println(" До истечения минуты осталось:   " + (MINUTE - elapsedTime) + " миллисекунд" + " или примерно " + TimeUnit.MILLISECONDS.toSeconds((MINUTE - elapsedTime))+ " секунд(ы)");
        }

    }

    public static void calcFibonacci(String[] args){
        long n_first = 0;
        long n_second = 1;

        System.out.print(" first and second: \n" + n_first + " \n" + n_second + ", then \n");

        for(int i = 0; i <= 100; i++) {
       // while (true) { //< Long.MAX_VALUE 9223372036854775807
            n_second +=  n_first;

           if (n_second >= Long.MAX_VALUE | n_second < 0) break  ;

            n_first = n_second - n_first;

            System.out.print(" " + n_second + "  \n");
        }
        System.out.println();

    }

}
