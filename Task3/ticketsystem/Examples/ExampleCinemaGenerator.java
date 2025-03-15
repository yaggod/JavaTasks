package ticketsystem.examples;
import java.util.*;
import ticketsystem.*;

public class ExampleCinemaGenerator 
{
    public static Cinema GetExampleCinema()
    {
        Cinema cinema = new Cinema("Example cinema");
        CinemaRoom room = GetExampleRoom();
        TakeRandomSeats(room, 10);
        FillSchedule(room, 5);
        cinema.AddRoom(room);
        
        CinemasRepository.AddCinema(cinema);
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

    public static void FillSchedule(CinemaRoom room, int filmsCount)
    {
        Random random = new Random();
        Calendar calendar = Calendar.getInstance();
        int breakTime = 15;
        Film[] films = new Film[5];
        films[0] = new Film("jonkler", 80);
        films[1] = new Film("5 jonklers per minute", 120);
        films[2] = new Film("biojonkler", 45);
        films[3] = new Film("captain jonkler", 65);
        films[4] = new Film("jonkler the unchained", 70);

        
        for(int i = 0; i < filmsCount; i++)
        {
            Film filmToAdd = films[random.nextInt(films.length)];
            Date startTime = calendar.getTime();
            calendar.add(Calendar.MINUTE, filmToAdd.getMinutesDuration());
            Date endTime = calendar.getTime();
            SessionScheduleItem item = new SessionScheduleItem(filmToAdd, startTime, endTime);
            calendar.add(Calendar.MINUTE, breakTime);

            room.AddScheduleItem(item);
        }
    }
}
