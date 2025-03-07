package ticketsystem;
import java.util.*;

public class CinemaRoom 
{

    ArrayList<ArrayList<Seat>> seatsRows = new ArrayList<>();
    
    public CinemaRoom(ArrayList<Integer> columnsSeatsCount) 
    {
        RecaltulateSeatNumbers(columnsSeatsCount);
    }

    private void RecaltulateSeatNumbers(ArrayList<Integer> columnsSeatsCount) 
    {
        int currentSeatNumber = 1;
        for(int i = 0; i < columnsSeatsCount.size(); i++)
        {
            ArrayList<Seat> row = new ArrayList<>();
            for(int j = 0; j < columnsSeatsCount.get(i); j++)
                row.add(new Seat(currentSeatNumber++));
            seatsRows.add(row);
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
                builder.append("\t");
                builder.append(seat.getSeatNumber());
            }
        }

        return builder.toString();
    }

}
