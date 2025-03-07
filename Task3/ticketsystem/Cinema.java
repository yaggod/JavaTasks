package ticketsystem;
import java.util.*;

public class Cinema
{
    ArrayList<CinemaRoom> allRooms = new ArrayList<>();

    public void AddRoom(CinemaRoom room)
    {
        allRooms.add(room);
    }
}