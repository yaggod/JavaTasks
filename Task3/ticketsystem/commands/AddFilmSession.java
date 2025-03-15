package ticketsystem.commands;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import ticketsystem.*;

public class AddFilmSession extends UserCommandBase
{

    @Override
    public String GetDescription() 
    {
        return "Add new film session";
    }

    @Override
    public void Execute()
        {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter index of Cinema to add session in: ");
        Cinema cinema = UserInputObjectSelector.SelectCinema();
        if(cinema == null)
            return;
        System.out.println("Enter index of Room to add session in: ");
        CinemaRoom room = UserInputObjectSelector.SelectRoom(cinema.GetRooms());
        if(room == null)
            return;
        System.out.println("Enter index of film to add session with: ");
        Film film = UserInputObjectSelector.SelectFilm();

        System.out.println("Enter \'MM.dd HH:mm\' formated date to show \"" + film.getFilmName() + "\" film on: ");
        try
        {
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM.dd HH:mm");
            String input = scanner.next();
            Calendar calendar = Calendar.getInstance();
            Date startTime = dateFormat.parse(input);
            calendar.setTime(startTime);
            calendar.add(Calendar.MINUTE, film.getMinutesDuration());
            Date endTime = calendar.getTime();
            SessionScheduleItem item = new SessionScheduleItem(film, startTime, endTime);
            room.AddScheduleItem(item);
        }
        catch(ParseException ex)
        {
            System.out.println("Failed to add film in a schedule");
        }
    }
}
