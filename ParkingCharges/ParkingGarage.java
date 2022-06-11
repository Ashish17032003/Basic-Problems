/*
(Parking Charges) A parking garage charges a $2.00 minimum fee to park for up to three hours. The
garage charges an additional $0.50 per hour for each hour or part thereof in excess of three hours.
The maximum charge for any given 24-hour period is $10.00. Assume that no car parks for longer than
24 hours at a time. Write an application that calculates and displays the parking charges for each
customer who parked in the garage yesterday. You should enter the hours parked for each customer.
The program should display the charge for the current customer and should calculate and display the
running total of yesterday's receipts. It should use the method calculateCharges to determine the
charge for each customer.
*/

public class ParkingGarage
{
    private final double minimumCharge = 2;
    private final int minimumHours = 3;
    private final double additionalCharge = 0.5;
    private final double maximumCharge = 10;

    public double calculateCharges( int hoursYesterday , int hours)
    {
        if(hoursYesterday == 24 && hours == 24)
        {
            return (2*maximumCharge);
        }

        if (hoursYesterday == 24 &&  hours<= minimumHours)
        {
            return  (maximumCharge + minimumCharge);
        }

        if (hoursYesterday == 24 && hours > minimumHours)
        {
            return (maximumCharge + (minimumCharge + (additionalCharge * hours)));
        }

        if (hoursYesterday <= minimumHours && hours == 24)
        {
            return (minimumHours + maximumCharge);
        }

        if (hoursYesterday > minimumHours && hours == 24)
        {
            return ((minimumCharge + (additionalCharge * hoursYesterday)) + maximumCharge);
        }

        if(hoursYesterday <= minimumHours && hours<= minimumHours)
        {
            return (minimumCharge + minimumCharge);
        }

        if (hoursYesterday <= minimumHours && hours > minimumHours)
        {
            return (minimumCharge + (minimumCharge + (additionalCharge * hours )));
        }

        if (hoursYesterday > minimumHours && hours <= minimumHours)
        {
            return ( ( minimumCharge + (additionalCharge * hoursYesterday) ) + minimumCharge);
        }

        if (hoursYesterday > minimumHours && hours > minimumHours)
        {
            return ( (minimumCharge + (additionalCharge * hoursYesterday )) + (minimumCharge + (additionalCharge * hours)));
        }

        if (hoursYesterday == 0 && hours <= minimumHours )
        {
            return minimumCharge;
        }

        if (hoursYesterday == 0 && hours > minimumHours)
        {
            return (minimumHours + (additionalCharge * hours));
        }

        if (hoursYesterday <= minimumHours && hours == 0 )
        {
            return minimumCharge;
        }

        if (hoursYesterday > minimumHours && hours == 0)
        {
            return (minimumHours + (additionalCharge * hours));
        }

        else
            return 0;

    }
}
