package ticketsystem;
import java.util.*;

public class Cinema
{
    private final static ArrayList<Cinema> cinemas = new ArrayList<>();

    private final ArrayList<CinemaRoom> cinemaRooms = new ArrayList<>();
    private final String cinemaName;

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
        cinemaRooms.add(room);
    }

    public ArrayList<CinemaRoom> GetRooms()
    {
        return cinemaRooms;
    }

    public String GetCinemaName() 
    {
        return cinemaName;
    }
}