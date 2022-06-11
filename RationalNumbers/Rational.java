/*
(Rational Numbers) Create a class called Rational for performing arithmetic with fractions. Write a
program to test your class. Use integer variables to represent the private instance variables of the
class-the numerator and the denominator. Provide a constructor that enables an object of this class
to be initialized when it's declared. The constructor should store the fraction in reduced form. The
fraction 2/4 is equivalent to 1/2 and would be stored in the object as 1 in the numerator and 2 in the
denominator. Provide a no-argument constructor with default values in case no initializers are
provided. Provide public methods that perform each of the following operations: a) Add two Rational
numbers: The result of the addition should be stored in reduced form. Implement this as a static
method. b) Subtract two Rational numbers: The result of the subtraction should be stored in reduced
form. Implement this as a static method. c) Multiply two Rational numbers: The result of the
multiplication should be stored in reduced form. Implement this as a static method. d) Divide two
Rational numbers: The result of the division should be stored in reduced form. Implement this as a
static method. e) Return a String representation of a Rational number in the form a/b, where a is the
numerator and b is the denominator. f) Return a String representation of a Rational number in
floating-point format. (Consider providing formatting capabilities that enable the user of the class to
specify the number of digits of precision to the right of the decimal point.)
*/


public class Rational
{
    private int numerator, denominator;

    public Rational()
    {
        this.numerator = 0;
        this.denominator = 0;
    }

    public Rational(int numerator, int denominator)
    {
        int greatestCommonDivisor = gcd(numerator, denominator);

        numerator = numerator / greatestCommonDivisor;
        denominator = denominator / greatestCommonDivisor;

        this.numerator = numerator;
        this.denominator = denominator;
    }
    private static int gcd(int numerator, int denominator) // logic: something euclid said (look it up)
    {
        if (denominator == numerator)
            return numerator;

        if (numerator % denominator == 0)
            return denominator;

        if (denominator % numerator == 0)
            return numerator;

        if ( numerator > denominator )
        return gcd(numerator % denominator , denominator);

        else if (numerator < denominator)
            return gcd(numerator, denominator % numerator);

        return numerator;
    }


    //Public Methods To Perform Operations

    // a) Add two Rational numbers: The result of the addition should be stored in reduced form.
    public Rational addition (Rational ob)
    {
        int numerator = (this.numerator * ob.denominator) + (this.denominator * ob.numerator);
        int denominator = (this.denominator * ob.denominator);

        return (new Rational(numerator,denominator));
    }

    // b) Subtract two Rational numbers: The result of the subtraction should be stored in reduced form.

    public Rational subtraction (Rational ob)
    {
        int numerator = (this.numerator * ob.denominator) - (this.denominator * ob.numerator);
        int denominator = (this.denominator * ob.denominator);

        return (new Rational(numerator,denominator));
    }

    // c) Multiply two Rational numbers: The result of the multiplication should be stored in reduced form.

    public Rational multiplication(Rational ob) {
        return new Rational(this.numerator * ob.numerator, this.denominator * ob.denominator);
    }

    // d) Divide two Rational numbers: The result of the division should be stored in reduced form.

    public Rational division(Rational ob) {
        return this.multiplication ( ob.reciprocal() );
    }

    public Rational reciprocal() {
        return new Rational ( denominator, numerator );
    }

    public String toString()
    {
        if (denominator == 1)
            return numerator + "";
        else
            return numerator + "/" + denominator;
    }

    public String toFloatingPointString()
    {
        if (denominator == 1)
            return (float)numerator + "";
        else
            return (float)numerator + "/" + (float)denominator;
    }


}
