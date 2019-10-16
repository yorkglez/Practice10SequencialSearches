package com.practicesequencialsearch.app;

import java.util.Random;
import java.util.Scanner;

public class BinarySearch
{
    public static void main(String[] args)
    {
        //Constants declaration
        final int ELEMENTS_ARRAY = 5;

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
        for (int i = 0; i < ELEMENTS_ARRAY; i++)
        {
//            System.out.print(arrayNumbers[i]+" ");
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
        for(int i = 0; i < ELEMENTS_ARRAY; i++)
        {
            System.out.print(arrayNumbers[i] +" ");
        }

        //Ask the user for the number to find
        do
            {
                System.out.println();
                System.out.print("Input the number to find inside the array (0-100): ");
                numberToFound = in.nextInt();

                if(numberToFound < 0)
                {
                    System.out.println("Number must be zero or positive vaulue!!");
                }

            //Binary Search algorithm
            while (limInf <= limInf)
            {
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
