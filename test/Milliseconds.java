import java.util.Scanner;
public class Milliseconds
{
    public static void main (String [] args)
    {
        // ...מתאימים קבועים להופיע צריכים כאן
        // 1 seconds =  1000 ms 1 minutes = 60,000 1 hours = 1,200,000
        final long SECONDS, MINUTES, HOURS, DAYS;
        Scanner scan = new Scanner (System.in);
        System.out.println ("This program reads an integer which " +
                "represents Milliseconds and converts it to days, " +
                "hours, minutes and seconds. ");
        System.out.println ("Please enter the number of Milliseconds");
        long ms = scan.nextLong();
        DAYS = ms / 86400000;
        ms = ms - DAYS * 86400000;
        HOURS = ms / 3600000;
        ms = ms - HOURS * 3600000;
        MINUTES = ms / 60000;
        ms = ms - MINUTES * 60000;
        SECONDS = ms / 1000;
        System.out.println( DAYS + " days " + HOURS+ ":" + MINUTES + ":" + SECONDS +" hours");



    }
}