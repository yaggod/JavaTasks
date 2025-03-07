package ticketsystem;
import java.util.*;

public class CinemaRoom 
{


public class Seat
{
    private int seatNumber; 

    public int getSeatNumber() 
    {
        return seatNumber;
    }

    private void setSeatNumber(int seatNumber)
    {
        this.seatNumber = seatNumber;
    }
}

    ArrayList<ArrayList<Seat>> seatsRows;
    
    public CinemaRoom(ArrayList<ArrayList<Seat>> seatsRows) 
    {
        this.seatsRows = seatsRows;
        RecaltulateSeatNumbers();
    }

    private void RecaltulateSeatNumbers() 
    {
        int currentNumber = 1;
        for(ArrayList<Seat> row : seatsRows)
        {
            for(Seat seat : row)
            {
                seat.setSeatNumber(currentNumber++);
            }
        }
    }


    public ArrayList<ArrayList<Seat>> getSeatsRows() 
    {
        return seatsRows;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        for(ArrayList<Seat> row : seatsRows)
        {
            builder.append("\n\n");
            for(Seat seat : row)
            {
                builder.append("\t" + seat.getSeatNumber());
            }
        }

        return builder.toString();
    }

}
