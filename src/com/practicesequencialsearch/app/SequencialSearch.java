package com.practicesequencialsearch.app;

import java.util.Random;
import java.util.Scanner;

public class SequencialSearch
{
    public static void main(String[] args)
    {
        //Constants declaration
        final int ELEMENTS_ARRAY = 100;

        //Array declaration
        int[] vector = new int[ELEMENTS_ARRAY];

        //Variable declaration
        int numberToFind = 0;
        int indexFound = -1;
        int index = 0;
        boolean isFound = true;

        //Object declaration
        Random random = new Random(System.nanoTime());
        Scanner in = new Scanner(System.in);

        //Array Initialization
        for (int i = 0; i < ELEMENTS_ARRAY; i++)
        {
            vector[i] = random.nextInt(101);
            System.out.print(vector[i]+ " ");
        }

        System.out.println();

        do
        {
            //Input number to search
            System.out.print("Input the value to find inside the array: ");
            numberToFind = in.nextInt();

            //Validate number
            if(numberToFind < 0)
            {
                System.out.println("Number must be greater than or equal to Zero!!!");
            }

            //SequentialSearch algorithm
            for(int i = 0; i < ELEMENTS_ARRAY; i++)
            {
                if(numberToFind == vector[i])
                {
                    indexFound = i;
                    break;
                }
            }

            if(indexFound != -1)
            {
                System.out.println("Element found at index: "+indexFound);
            }
            else{
                System.out.println("Element not found!!!");
            }
        }while(numberToFind < 0);


        //Previous algorithm implementation with loop while
        while (!isFound && index < ELEMENTS_ARRAY)
        {
            if(numberToFind == vector[index])
            {
                indexFound = index;
                isFound = true;
            }
            index++;
        }

        //Close input
        in.close();
    }
}
