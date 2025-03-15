package ticketsystem;
import java.util.*;

public class SessionScheduleItem 
{
    public Film film;
    public Date startTime;
    public Date endTime;
    private final ArrayList<ArrayList<Seat>> seatsRows = new ArrayList<>();

    public SessionScheduleItem(Film film, Date startTime, Date endTime) 
    {
        this.startTime = startTime;
        this.endTime = endTime;
        this.film = film;
    }

    void SetupSeats(ArrayList<Integer> rowsSeatsCount) 
    {
        int currentSeatNumber = 1;
        for(int i = 0; i < rowsSeatsCount.size(); i++)
        {
            ArrayList<Seat> row = new ArrayList<>();
            for(int j = 0; j < rowsSeatsCount.get(i); j++)
                row.add(new Seat(currentSeatNumber++));
                
            seatsRows.add(row);
        }
    }

    public ArrayList<ArrayList<Seat>> GetSeats()
    {
        return seatsRows;
    }

    public int GetTotalSeatsCount()
    {
        return seatsRows.getLast().getLast().GetSeatNumber();
    }
    

    public Seat GetSeatByNumber(int number)
    {
        if(number < 1 | number > GetTotalSeatsCount())
            throw new IndexOutOfBoundsException();
        int totalSeatsSkipped = 0;
        for(ArrayList<Seat> row : seatsRows)
        {
            if(totalSeatsSkipped + row.size() >= number)
                return row.get(number - totalSeatsSkipped - 1);

            totalSeatsSkipped += row.size();
        }

        return null; // unreachable 
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
                builder.append(seat.GetSeatNumber());
                if(!seat.IsFree())
                    builder.append('*');
            }
        }
        builder.append("\n\n* - Taken");
        builder.append('\n');
        builder.append(film.GetFilmName());
        builder.append("\t at");
        builder.append(startTime);
        builder.append(" - ");
        builder.append(endTime);            

        return builder.toString();
    }


}
