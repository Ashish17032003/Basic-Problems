/*
(Huge Integer Class) Create a class Hugelnteger which uses a 40-element array of digits to store
integers as large as 40 digits each. Provide methods parse, toString, add and subtract. Method parse
should receive a String, extract each digit using method charAt and place the integer equivalent of
each digit into the integer array. For comparing HugeInteger objects, provide the following methods:
isEqualTo, isNotEqualTo, isGreater Than, isLess Than, isGreaterThanOrEqualTo and
isLessThanOrEqualTo. Each of these is a predicate method that returns true if the relationship holds
between the two Hugelnteger objects and returns false if the relationship does not hold. Provide a
predicate method isZero. If you feel ambitious, also provide methods multiply, divide and remainder.
*/

public class HugeInteger
{
    int[] digits;
    boolean error;
    HugeInteger(String str) {
        parse(str);
    }

    HugeInteger(char[] array) {
        this(new String(array));
    }

    HugeInteger(int length) {
        digits = new int[length]; // initialize to 0
    }

    int size() {
        return digits.length;
    }

    void parse(String str)
    {
        digits = new int[str.length()];
        for(int i = 0; i < str.length(); i++)
            digits[i] = str.charAt(i) - '0';
    }

    public String toString()
    {
        String str = "";
        int i;
        for(i = size() -1; i >= 0; i--)
        {
            if(digits[i] != 0)
                break;
        }
        System.out.println();
        for(int j = i; j >= 0; j--)
        {
            str = digits[j] + str;
        }
        return str;
    }

    public boolean isEqualTo(HugeInteger X)
    {
        if (this.error || X.error)
        {
            return false;
        }

        for (int i = 0; i < this.size(); i++)
            if (this.digits[i] != X.digits[i])
                return false;

        return true;
    }

    public boolean isNotEqualTo(HugeInteger X)
    {
        return !error && !X.error && !this.isEqualTo(X);
    }

    public boolean isGreaterThan(HugeInteger X)
    {
        return !error && !X.error && !this.isEqualTo(X) && !this.isLessThan(X);
    }

    public boolean isLessThan(HugeInteger X)
    {
        for (int i = size() - 1; i >= 0; i--)
        {
            if (digits[i] < X.digits[i])
                return true;
            if (digits[i] > X.digits[i])
                return false;
        }
        return false;
    }

    public boolean isGreaterThanOrEqualTo(HugeInteger X)
    {
        return !error && !X.error && !this.isLessThan(X);
    }

    public boolean isLessThanOrEqualTo(HugeInteger X)
    {
        return !error && !X.error && !this.isGreaterThan(X);
    }

    public boolean isZero()
    {
        HugeInteger z = new HugeInteger("0");
        if ((z.toString()).equals(this.toString()))
            return true;
        else
            return false;
    }

    void checkLength(int length)
    {
        length += 1;
        // test size

        if(size() >= length)
            return;
        // make copy

        int[] x = new int[length];
        int k = length;

        for(int i = size() -1; i >= 0; i--)
            x[--k] = digits[i];

        // new array
        digits = x;
    }

    public HugeInteger add(HugeInteger X)
    {
        int length = size();
        if (X.size() > length)
            length = X.size();

        checkLength(length);
        X.checkLength(length);
        HugeInteger result = new HugeInteger(length + 1);
        int carry = 0;
        for (int i = length; i >= 0; i--)
        {
            result.digits[i] = digits[i] + X.digits[i] + carry;
            if (result.digits[i] < 10)
            {
                carry = 0;
            }
            else
            {
                carry = result.digits[i] % 10;
                result.digits[i] %= 10;
            }
        }
        return result;
    }

    public HugeInteger subtract(HugeInteger X)
    {
        int borrow = 0;
        HugeInteger result = new HugeInteger(this.size());
        if (error || X.error || this.isLessThan(X))
        {
            System.out.println("Can't handle negative Huge Integers.");
            error = true;
            return this;
        }
        for (int i = 0; i < X.size(); i++)
        {
            result.digits[i] = this.digits[i] - X.digits[i] + borrow;
            if (result.digits[i] >= 0)
                borrow = 0;
            else
            {
                result.digits[i] += 10;
                borrow = 1;
            }
        }
        return result;
    }

    /* ************************************************************************************ */

    public static void main(String[] args)
    {
        HugeInteger x = new
                HugeInteger("123456789012345678901234567890123456799");
        HugeInteger y = new
                HugeInteger("123456789012345678901234567890123456780");
        HugeInteger z = new HugeInteger("0000");
        if(x.isEqualTo(y))
            System.out.println(x + " Is Equal To " + y);
        if(x.isLessThan(y))
            System.out.println(x + " Is less Than " + y);
        if(x.isNotEqualTo(y))
            System.out.println(x + " Is Not Equal To " + y);
        if(x.isGreaterThan(y))
            System.out.println(x + " Is Greater Than " + y);
        if(x.isGreaterThanOrEqualTo(y))
            System.out.println(x + " Is Greater Than Or Equal To " + y);
        if(x.isLessThanOrEqualTo(y))
            System.out.println(x + " Is Less Than Or Equal To " + y);
        if(z.isZero())
            System.out.println("z:" + z + " Is zero.");
        HugeInteger s = x.subtract(y);
        HugeInteger a = x.add(y);
        System.out.println("subtract: " + s);
        System.out.println("add: " + a);
    }

}