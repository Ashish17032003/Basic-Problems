/*
(Duplicate Elimination) Use a one-dimensional array to solve the following problem: Write an
application that inputs five numbers, each between 10 and 100, inclusive. As each number is read,
display it only if it's not a duplicate of a number already read. Provide for the "worst case," in which
all five numbers are different. Use the smallest possible array to solve this problem. Display the
complete set of unique values input after the user enters each new value.
*/

import java.util.Scanner;

public class DuplicateElimination
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int sid[] = new int[5];
        int count = 0;
        int x = 0;
        int num = 0;

        while (x < sid.length)
        {
            System.out.println("Enter Number: ");
            num = input.nextInt();

            if ((num >= 10) && (num <= 100))
            {
                boolean digit = false;
                x++;

                for (int i = 0; i < sid.length; i++) // to check if the number was entered before or not
                {   if (sid[i] == num)
                    digit = true;
                }

                if (!digit) // store in array if the number was not entered before
                {
                    sid[count] = num;
                    count++;
                }

                else
                    System.out.printf("The number was entered before \n");
            }

            else
                System.out.println("Number must be between 10 and 100");


            for (int i =0;  i < x; i++)
            {
                if(sid[i]!=0)
                    System.out.print(sid[i] +" "); //printing all the unique values in order (ignoring zeroes)
            }
            System.out.println();
        }

    }

}