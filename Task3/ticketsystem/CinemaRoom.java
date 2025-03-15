package ticketsystem;
import java.util.*;
import javax.naming.OperationNotSupportedException;

public class CinemaRoom 
{

    ArrayList<ArrayList<Seat>> seatsRows = new ArrayList<>();
    ArrayList<SessionScheduleItem> sessionsSchedule = new ArrayList<>();
    
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

    public ArrayList<ArrayList<Seat>> GetSeatsRows() 
    {
        return seatsRows;
    }

    public void AddScheduleItem(SessionScheduleItem item) throws OperationNotSupportedException
    {
        for(SessionScheduleItem existingItem : sessionsSchedule)
        {
            if(item.startTime.after(existingItem.startTime) &&
                item.startTime.before(existingItem.endTime))
                throw new OperationNotSupportedException();
        }
        sessionsSchedule.add(item);
    }

    public ArrayList<SessionScheduleItem> GetSchedule()
    {
        return sessionsSchedule;
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
        for(SessionScheduleItem item : sessionsSchedule)
        {
            builder.append('\n');
            builder.append(item.film.GetFilmName());
            builder.append("\t at");
            builder.append(item.startTime);
            builder.append(" - ");
            builder.append(item.endTime);            
        }

        return builder.toString();
    }


}
