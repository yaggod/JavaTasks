import java.util.*;

public class CinemaRoom 
{
    ArrayList<ArrayList<Seat>> seatsRows;
    
    public CinemaRoom(ArrayList<ArrayList<Seat>> seatsRows) 
    {
        this.seatsRows = seatsRows;
    }

    public ArrayList<ArrayList<Seat>> getSeatsRows() 
    {
        return seatsRows;
    }
}
