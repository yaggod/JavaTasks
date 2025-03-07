package ticketsystem.examples;
import java.util.*;
import ticketsystem.*;

public class ExampleCinemaGenerator 
{
    public static Cinema GetExampleCinema()
    {
        Cinema cinema = new Cinema();
        cinema.AddRoom(GetExampleRoom());

        return  cinema;
    }

    public static CinemaRoom GetExampleRoom()
    {
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        int rowsCount = random.nextInt(2, 10);
        for(int i = 0; i < rowsCount; i++)
            list.add(random.nextInt(5, 10));
        
        CinemaRoom room = new CinemaRoom(list);
        return room;
    }
}
