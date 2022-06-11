import java.util.Scanner;

public class ParkingGarageTest
{
    public static void main(String[] args)
    {
        int hours , hoursYesterday;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of hours parked yesterday = ");
        hoursYesterday = Integer.parseInt(sc.nextLine());

        System.out.print("Enter the number of hours parked today = ");
        hours = Integer.parseInt(sc.nextLine());

        ParkingGarage p1 = new ParkingGarage();
        System.out.println("Parking Charges = $" + p1.calculateCharges(hoursYesterday,hours));

    }
}
