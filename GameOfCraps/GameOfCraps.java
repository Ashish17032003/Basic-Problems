import java.security.SecureRandom;

public class GameOfCraps
{
    //create a random number generator for use in method rollDice
    private static final SecureRandom randomNumbers = new SecureRandom();

    //enums to represent game status
    private enum Status {CONTINUE,WON,LOST};

    //constants that represent common dice rolls

    private static final int SNAKE_EYES = 2;
    private static final int TREY = 3;
    private static final int SEVEN = 7;
    private static final int YO_LEVEN = 11;
    private static final int BOX_CARS = 12;

    public static void main(String[] args)
    {
        int myPoint = 0; // point if no won or loss on first roll
        int sumOfDice = rollDice(); // first dice roll

        Status gameStatus; // can determine game status ( either CONTINUE, WON OR LOST)

        switch (sumOfDice)
        {
            case SEVEN:
            case YO_LEVEN:
                gameStatus = Status.WON; //win with 7 or 11 on first roll
                break;

            case SNAKE_EYES:
            case TREY:
            case BOX_CARS:
                gameStatus = Status.LOST; // lost  with 2 or 3 or 12 on first roll
                break;

            default: // didn't win or lose, so remember the points
                gameStatus = Status.CONTINUE; // game continues
                myPoint = sumOfDice; // remember points
                System.out.println("Point is : " + myPoint);
                break;
        }

        while (gameStatus == Status.CONTINUE)
        {
            sumOfDice = rollDice(); //roll dice again
            //determine game status
            if(sumOfDice == myPoint) //win by making point
                gameStatus = Status.WON;

            else if (sumOfDice == SEVEN) //lose by rolling 7 before point
                gameStatus = Status.LOST;
        }

        if (gameStatus == Status.WON)
            System.out.println("Player Wins");

        else
            System.out.println("Player Loses");

    } // main ends here

    //roll dice, calculate sum and display results
    public static int rollDice()
    {
        int die1 = 1 + randomNumbers.nextInt(6);
        int die2 = 1 + randomNumbers.nextInt(6);

        int sum = die1 + die2;
        System.out.println("Player rolled " + die1 + " + " + die2 + " = " + sum);

        return sum;
    }

}
