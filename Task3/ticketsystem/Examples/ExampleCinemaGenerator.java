package ticketsystem.examples;
import java.util.*;
import ticketsystem.*;

public class ExampleCinemaGenerator 
{
    public static Cinema GetExampleCinema()
    {
        Cinema cinema = new Cinema();
        CinemaRoom room = GetExampleRoom();
        TakeRandomSeats(room, 10);
        cinema.AddRoom(room);
        
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

    public static void TakeRandomSeats(CinemaRoom room, int seatsToTake)
    {
        Random random = new Random();
        for(int seat = 0; seat < seatsToTake; seat++)
        {
            ArrayList<ArrayList<Seat>> seatsRows = room.getSeatsRows();
            int i = random.nextInt(seatsRows.size());
            int j = random.nextInt(seatsRows.get(i).size());
            seatsRows.get(i).get(j).takeSeat();            
        }
    }
}
