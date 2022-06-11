/*
(Reversing Digits) Write a method that takes an integer value and returns the number with its digits
reversed. For example, given the number 7631, the method should return 1367. Incorporate the
method into an application that reads a value from the user and displays the result.
*/

import java.util.Scanner;

public class ReversingDigits
{
    public static int reverse( int num)
    {
        int reverse = 0;
        while (num!=0)
        {
            int remainder = num % 10;
            reverse = (reverse * 10) + remainder;
            num = num / 10;
        }
        return  reverse;

    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number = ");
        int num = sc.nextInt();
        System.out.println("The reverse of the given number is = " + reverse(num));
    }
}
