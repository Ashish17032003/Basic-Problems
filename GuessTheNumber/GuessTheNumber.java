/*
(Guess the Number) Write an application that plays "guess the number" as follows: Your program
chooses the number to be guessed by selecting a random integer in the range 1 to 1000. The
application displays the prompt Guess a number between 1 and 1000. The player inputs a first guess.
If the player's guess is incorrect, your program should display Too high. Try again. or Too low. Try
again. to help the player "zero in" on the correct answer. The program should prompt the user for the
next guess. When the user enters the correct answer, display Congratulations. You guessed the
number!, and allow the user to choose whether to play again. [Note: The guessing technique
employed in this problem is similar to a binary search, which is discussed in Chapter 19, Searching,
Sorting and Big O.]
*/

import java.security.SecureRandom;
import java.util.Scanner;

public class GuessTheNumber
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        SecureRandom randomNumber= new SecureRandom();
        while(true)
        {
            int numberToBeGuessed = randomNumber.nextInt(1, 1000);

            while (true)
            {
                System.out.print("Guess a number between 1 and 1000 = ");
                int guess = sc.nextInt();
                if (guess != numberToBeGuessed)
                {
                    if (guess > numberToBeGuessed)
                    {
                        System.out.println("Too High, Try Again!");
                    }
                    else if (guess < numberToBeGuessed)
                    {
                        System.out.println("Too Low, Try Again!");
                    }
                }
                else if (guess == numberToBeGuessed)
                {
                    System.out.println("Congratulations, You guessed the number!");
                    break;
                }
            }

            System.out.println("Enter 1 to continue playing or else enter 0 to exit :");
            int toContinuePlaying = sc.nextInt();
            if (toContinuePlaying == 0)
                break;

        }

    }
}