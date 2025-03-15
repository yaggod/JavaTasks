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

}
