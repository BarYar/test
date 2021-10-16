import java.util.Scanner;
public class Einstein
{
    public static void main(String[]args)
    {
        long reversedNum, hundreds, tens, units, diff, reversedDiff;
        System.out.println("Welcome to the Einstein magic game. \nPlease enter a 3 digit positive number whose first and last digits are different:");
        Scanner scan = new Scanner (System.in);
        long num = scan.nextLong();
        if ((num > 999) || (num < 100))
        {
            System.out.println("The number you entered is not a 3 digit positive number");
        }
        else
        {
            System.out.println("User number is: " + num);
            hundreds = num / 100;
            tens = (num % 100) / 10;
            units = (num % 100) % 10;
            if (tens == hundreds)
            {
                System.out.println("You entered an invalid input, your tens and hundreds number are equal.");
            }
            else
            {
                reversedNum = units * 100 + tens * 10 + hundreds;
                diff = Math.abs(num - reversedNum);
                System.out.println("Difference: " + diff);
                hundreds = diff / 100;
                tens = (diff % 100) / 10;
                units = (diff % 100) % 10;
                reversedDiff = units * 100 + tens * 10 + hundreds;
                System.out.println("Reversed difference:" + reversedDiff);
                if (diff + reversedDiff == 1089)
                    System.out.println("SUCCEEDED");
                else
                System.out.println("FAILED");

            }
        }
    }
}
