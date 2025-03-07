package ticketsystem;
import java.util.*;

public class SessionScheduleItem 
{
    Film film;
    Date startTime;
    Date endTime;

    public SessionScheduleItem(Film film, Date startTime, Date endTime) 
    {
        this.startTime = startTime;
        this.endTime = endTime;
        this.film = film;
    }

}
