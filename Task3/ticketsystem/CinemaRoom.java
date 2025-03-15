package ticketsystem;
import java.util.*;
import javax.naming.OperationNotSupportedException;

public class CinemaRoom 
{

    //ArrayList<ArrayList<Seat>> seatsRows = new ArrayList<>();
    ArrayList<Integer> rowsSeatsCount;
    ArrayList<SessionScheduleItem> sessionsSchedule = new ArrayList<>();
    
    public CinemaRoom(ArrayList<Integer> rowsSeatsCount) 
    {
        this.rowsSeatsCount = rowsSeatsCount;
    }

    /*
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
    */

    public ArrayList<Integer> GetSeatsRows() 
    {
        return rowsSeatsCount;
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
        item.SetupSeats(rowsSeatsCount);
    }

    public ArrayList<SessionScheduleItem> GetSchedule()
    {
        return sessionsSchedule;
    }

    public ArrayList<SessionScheduleItem> GetUpcomingFilms() 
    {
        ArrayList<SessionScheduleItem> result = new ArrayList<>();
        Date currentTime = Calendar.getInstance().getTime();
        for(SessionScheduleItem item : sessionsSchedule)
            if(currentTime.before(item.startTime))
                result.add(item);

        return result;
    }

}
