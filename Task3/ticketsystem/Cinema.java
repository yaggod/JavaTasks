package ticketsystem;
import java.util.*;

public class Cinema
{
    private static ArrayList<Cinema> cinemas = new ArrayList<>();

    private ArrayList<CinemaRoom> allRooms = new ArrayList<>();
    private String cinemaName;

    public Cinema(String name)
    {
        cinemaName = name;
    }

    


    public static ArrayList<Cinema> GetCinemas() 
    {
        return cinemas;
    }

    public static void AddCinema(Cinema cinema) 
    {
        cinemas.add(cinema);
    }


    public void AddRoom(CinemaRoom room)
    {
        allRooms.add(room);
    }

    public String GetCinemaName() 
    {
        return cinemaName;
    }
}