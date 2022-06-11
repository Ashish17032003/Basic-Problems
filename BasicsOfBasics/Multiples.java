/*
(Multiples) Write a method isMultiple that determines, for a pair of integers, whether the second
integer is a multiple of the first. The method should take two integer arguments and return true if the
second is a multiple of the first and false otherwise. [Hint: Use the remainder operator.] Incorporate
this method into an application that inputs a series of pairs of integers (one pair at a time) and
determines whether the second value in each pair is a multiple of the first.
*/

import java.util.Scanner;

public class Multiples
{
    public static boolean isMultiple(int num1, int num2)
    {
        if ( num2 % num1 ==0 )
            return true;
        else
            return false;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter the numbers in pair : ");
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            boolean result = isMultiple(num1, num2);
            if (result == true)
                System.out.println(num2 + " is a multiple of " + num1);

            else
            {
                System.out.println(num2 + " is not a multiple of " + num1);
                break;
            }
        }
    }
}
