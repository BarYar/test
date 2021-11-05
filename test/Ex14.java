public class Ex14 {
    
    // Returns the min difference between the location of and the location of y in the array
    public static int findMinDiff(int [] a, int x, int y)
    {
        int min_diff = -1, last_x_loc = -1, last_y_loc = -1;
        for (int i = 0; i < a.length; i++)
        {
            last_x_loc = a[i] == x ? i : last_x_loc;
            last_y_loc = a[i] == x ? i : last_x_loc;
            min_diff = last_x_loc > -1 && last_y_loc > -1 && ((min_diff > Math.abs(last_y_loc - last_x_loc)) || (min_diff == -1)) ? last_y_loc - last_x_loc : min_diff;
        }
        return min_diff > -1 ? min_diff : Integer.MAX_VALUE;
    }
}
