package com.practicesequencialsearch.app;

import java.util.Random;
import java.util.Scanner;

public class BinarySearch
{
    public static void main(String[] args)
    {
        //Constants declaration
        final int ELEMENTS_ARRAY = 5;

        /*
            {5,10,14,21,30}
            numberToFound = 5
            5-1 / 2 =  2
            pivotal = 14
            -- 1 step --
            {5,10}
             {14}
            {21,30}
            -- 2 step --
            2-1 = 1
            {5}
            {10}



         */

        //Variable declaration
        int numberToFound = 0;
        int indexFound = -1;
        int limInf = 0;
        int temp = 0;
        int limSup = ELEMENTS_ARRAY - 1;
        int pivotal = (limSup - limInf) / 2;

        //Array declaration
        int[] arrayNumbers = new int[ELEMENTS_ARRAY];

        //Object declaration
        Scanner in = new Scanner(System.in);
        Random random = new Random(System.nanoTime());

        //Array Initialization
        for (int i = 0; i < ELEMENTS_ARRAY; i++)
        {
            arrayNumbers[i] = random.nextInt(101);
        }

        //Array Visualization
        System.out.println("-- Disordered vector --");
        for (int i = 0; i < ELEMENTS_ARRAY; i++)
        {
            System.out.print(arrayNumbers[i]+" ");
        }

        //Shorting algorithm
        for(int i = 0; i < ELEMENTS_ARRAY; i++)
        {
            for(int j =0; j < i; j++)
            {
                if(arrayNumbers[i] < arrayNumbers[j])
                {
                    temp = arrayNumbers[j];
                    arrayNumbers[j] = arrayNumbers[i];
                    arrayNumbers[i] = temp;
                }
            }
        }

        //Array visualization
        System.out.println("\n -- Ordered vector --");
        for(int i = 0; i < ELEMENTS_ARRAY; i++)
        {
            System.out.print(arrayNumbers[i] +" ");
        }

        //Ask the user for the number to find
        do
            {
                System.out.print("\n Input the number to find inside the array (0-100): ");
                numberToFound = in.nextInt();

                //Validate number
                if(numberToFound < 0)
                {
                    System.out.print("\n Number must be zero or positive value!!");
                }

                //Binary Search algorithm
                while (limInf <= limSup)
                {
                    /* *** Pseudocode ***
                        arrayNumbers =  {5,10,14,21,25,29,30,31,38,50}
                        limInf = 0;
                        limSup = 10 - 1 = 9
                        numberToFound = 30

                        <-- First step -->
                            while condition: 0 <= 9
                                pivotal = limInf + (limSup - limInf)/2 >>  pivotal = 0 + (9 - 0) / 2 = 4

                                if condition: numberToFound == arrayNumbers[pivotal] =  25   >> 30 == 25 -> false Then

                                else if condition: numberFound > arrayNumbers[pivotal] = 25  >>  30 >  25 -> true Then
                                    limInf = pivotal + 1 >> limInf = 4 + 1 = 5

                                else if condition: numberToFound < arrayNumbers[pivotal] = 4 >> 30 < 25 -> false Then
                            end while

                        <-- End step -->

                        <-- Second step -->
                            while condition: 5 <= 9
                                pivotal = limInf + (limSup - limInf)/2 >>  pivotal = 5 + (9 - 5 ) / 2 = 7

                                if condition: numberToFound == arrayNumbers[pivotal] =  25   >> 30 == 31 -> false Then

                                else if condition: numberFound > arrayNumbers[pivotal] = 25  >>  30 >  31 -> false Then


                                else if condition: numberToFound < arrayNumbers[pivotal] = 4 >> 30 < 31 -> true Then
                                    limSup = pivotal - 1 >> limSup = 7 - 1 = 6
                             end while
                        <-- End step -->
                           while condition: 5 <= 6
                                pivotal = limInf + (limSup - limInf)/2 >>  pivotal = 5 + (7 - 5 ) / 2 = 6

                                if condition: numberToFound == arrayNumbers[pivotal] =  30  >> 30 == 30 -> true Then
                                    indexFound = pivotal = 6
                                    break >> Stop loop
                             end while

                        <-- Third step -->



                    */
                    pivotal = limInf + (limSup - limInf) / 2;
                    if(numberToFound == arrayNumbers[pivotal])
                    {
                        indexFound = pivotal;
                        break;
                    }
                    else if(numberToFound > arrayNumbers[pivotal])
                    {
                        limInf = pivotal + 1;
                    }
                    else if(numberToFound < arrayNumbers[pivotal]){
                        limSup = pivotal - 1;
                    }
                }

            if(indexFound != -1)
            {
                System.out.println("Element found at index: "+indexFound);
            }
            else
                {
                    System.out.println("Element not present in the array!!");
                }

        }while(numberToFound < 0);
        //Close input
        in.close();
    }
}
