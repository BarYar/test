import java.util.*;
public class p87ex32 {
    public static void main(String[]args)
    {
        Scanner reader=new Scanner(System.in);
        int referee_num = 1;
        int [] results  = new int[50];
        int [] referee_winners  = new int[3];
        for (;referee_num <= 10; referee_num++);
        {
            System.out.println("Referee number:" + referee_num + "enter your winners.");
            for (int i = 0; i < 3; i++)
            {
                referee_winners[i] = reader.nextInt();
                results[referee_winners[i] - 1] += 3 - i;
            }
          
        }
        int [] winners = new int[3];
        int [] winners_results = new int[3];
        boolean need_to_update = false;
        int temp_loc = 0;
        int temp_result = 0;
        for (int i = 0; i < 50; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (!need_to_update)
                    if (results [i] > winners_results[j])
                    {
                        if (j < 2)
                        {
                            need_to_update = true;
                            temp_loc = winners[j];
                            temp_result = winners_results[j];
                        }
                        winners[j] = i + 1;
                        winners_results [j] = results [i];
                }
                else 
                {
                    if(j == 2)
                        need_to_update = false;
                    else
                    {
                        temp_loc = winners[j];
                        temp_result = winners_results[j]; 
                    }
                    winners_results [j] = temp_result;
                    winners [j] = temp_loc;
                }
            }
            
        }

    }
    
}
