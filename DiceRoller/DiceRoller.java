/*
(Dice Rolling) Write an application to simulate the rolling of two dice. The application should use an
object of class Random once to roll the first die and again to roll the second die. The sum of the two
values should then be calculated. Each die can show an integer value from 1 to 6, so the sum of the
values will vary from 2 to 12, with 7 being the most frequent sum, and 2 and 12 the least frequent.
The figure below shows the 36 possible combinations of the two dice. Your application should roll the
dice 36,000,000 times. Use a one-dimensional array to tally the number of times each possible sum
appears. Display the results in tabular format
*/

import java.security.SecureRandom;
import java.util.Random;

public class DiceRoller
{
    public static void main(String[] args) 
    {
        int dice0, dice1, sum;
        int[] freqs = new int[11]; //sum goes from 2 to 12 so number of entries = 11
        Random randomNumber = new Random();

        for (long count = 0; count < 36000000; count++)
        {
            dice0 = randomNumber.nextInt(1,7);
            dice1 = randomNumber.nextInt(1,7);
            sum = dice0 + dice1;
            freqs[sum - 2]++;
        }

        int i = 2;
        for(int freq : freqs)
        {
            System.out.println(i + "\t" + freq);
            i+=1;
        }
    }
}
