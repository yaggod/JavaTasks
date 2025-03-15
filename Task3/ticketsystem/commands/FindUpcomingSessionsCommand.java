package ticketsystem.commands;

import java.util.*;
import ticketsystem.*;

public class FindUpcomingSessionsCommand extends UserCommandBase
{

    @Override
    public String GetDescription() 
    {
        return "Find upcoming sessions";
    }

    @Override
    public void Execute()
    {

        for(Cinema cinema : CinemasRepository.GetCinemas())
        {
            ArrayList<CinemaRoom> rooms = cinema.GetRooms();
            for(int i = 0; i < rooms.size(); i++)
            {
                ArrayList<SessionScheduleItem> schedule = rooms.get(i).GetUpcomingFilms();
                for(int j = 0; j < schedule.size(); j++)
                {
                    SessionScheduleItem scheduleItem = schedule.get(j);
                    System.out.println(scheduleItem.film.GetFilmName() + " in " + cinema.GetCinemaName() + " in room " + (i+1) + " at " + scheduleItem.startTime);
                }
            }
        }
    }


}
