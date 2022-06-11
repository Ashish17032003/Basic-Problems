import java.util.Scanner;

public class RationalTest
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the numerator and denominator for the first Rational number: ");
        int numerator1 = sc.nextInt();
        int denominator1 = sc.nextInt();

        System.out.println();

        System.out.print("Enter the numerator and denominator for the second Rational number: ");
        int numerator2 = sc.nextInt();
        int denominator2 = sc.nextInt();

        Rational ob1 = new Rational(numerator1,denominator1);
        Rational ob2 = new Rational(numerator2,denominator2);

        Rational result; // object to store the result of the provided operations

        result = ob1.addition(ob2);
        System.out.println("Addition = " + result.toString());
        System.out.println(result.toFloatingPointString());

        result = ob1.division(ob2);
        System.out.println("Division = " + result.toString());
        System.out.println(result.toFloatingPointString());
    }
}
