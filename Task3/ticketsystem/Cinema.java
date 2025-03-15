package ticketsystem;
import java.util.*;

public class Cinema
{
    private final ArrayList<CinemaRoom> cinemaRooms = new ArrayList<>();
    private final String cinemaName;

    public Cinema(String name)
    {
        cinemaName = name;
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