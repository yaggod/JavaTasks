package ticketsystem;

import java.util.*;

public class UserInputObjectSelector
{
    private final static Scanner scanner = new Scanner(System.in);
    
    public static <T> T SelectObject(ArrayList<T> collection)
    {
        if(collection == null || collection.isEmpty())
        {
            System.out.println("No objects to select from");
            return null;
        }        
        int index;
        while(true)
        {
            index = scanner.nextInt();
            if(index < 1 | index > collection.size())
                System.out.println("Index should be in [" + 1 + ";" + collection.size() + "] bounds");
            else
                return collection.get(index - 1);
        }
    }
    
    
    public static Cinema SelectCinema()
    {
        System.out.println("Enter index of Cinema: ");
        return SelectObject(CinemasRepository.GetCinemas());
    }

    public static CinemaRoom SelectRoom(ArrayList<CinemaRoom> rooms)
    {
        System.out.println("Enter index of CinemaRoom: ");
        return SelectObject(rooms);
    }

    public static Film SelectFilm()
    {
        System.out.println("Enter index of Film: ");
        return SelectObject(FilmsRepository.GetFilms());
    }

    public static SessionScheduleItem SelectSession(ArrayList<SessionScheduleItem> scheduleItems) 
    {
        System.out.println("Enter index of Film: ");
        for(int i = 0; i < scheduleItems.size(); i++)
        {
            SessionScheduleItem item = scheduleItems.get(i);
            System.out.println((i+1) + ": " + item.film.GetFilmName() + " at " + item.startTime);
        }
        return SelectObject(scheduleItems);
    }

    public static Seat SelectSeat(SessionScheduleItem scheduleItem) 
    { // ctrl+c ctrl+v go brrrr but its implementation is a bit different from the other ones
        System.out.println("Enter number ot Seat: ");
        int seatsCount = scheduleItem.GetTotalSeatsCount();
        if(scheduleItem == null || seatsCount == 0)
        {
            System.out.println("No objects to select from");
            return null;
        }        
        int index;
        while(true)
        {
            index = scanner.nextInt();
            if(index < 1 | index > seatsCount)
                System.out.println("Index should be in [" + 1 + ";" + seatsCount + "] bounds");
            else
                return scheduleItem.GetSeatByNumber(index);
        }
    }

}
