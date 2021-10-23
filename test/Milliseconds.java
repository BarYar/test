import java.util.Scanner;
/**
 * Name: Bar Yaron      
 * The Milliseconds class converts the user input in milliseconds to Days, Hours, Minutes and Seconds.
 */
public class Milliseconds
{
    /**
     * Gets milliseconds input and convert it to Days, Hours, Minutes and Seconds according to this format:
     * d_days_h:m:s_hours 
     */
    public static void main (String [] args)
    {
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

    }//main
}//Milliseconds class