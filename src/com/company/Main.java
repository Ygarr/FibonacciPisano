package com.company;

import java.text.DecimalFormat;

public class Main {

    final static double MINUTE = 60000d;


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

        double elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println(" прошло :  "  +  elapsedTime  + " миллисекунд");
       // System.out.println(" прошло :  "  + (( new DecimalFormat("#0.0000000000").format(elapsedTime)/1000)/60 ) + " секунд");

        DecimalFormat fourDigits = new DecimalFormat("#0.000000000000000000");

        System.out.println(" прошло " +fourDigits.format(elapsedTime/1000/60) + " секунд");
        System.out.println(" прошло " +String.format("%.06f", elapsedTime/1000/60) + " секунд");

        if (elapsedTime >= MINUTE) {
            System.out.println(" Минута! Дальнейшее вычисление неприемлемо");
        } else {
            System.out.println(" До истечения минуты осталось:   " + (MINUTE - elapsedTime) + " миллисекунд" + " ");
        }

    }

    public static void calcFibonacci(String[] args) {
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
