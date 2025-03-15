package ticketsystem.commands;

import java.text.*;
import java.util.*;
import javax.naming.*;
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

        Cinema cinema = UserInputObjectSelector.SelectCinema();
        if(cinema == null)
            return;
        CinemaRoom room = UserInputObjectSelector.SelectRoom(cinema.GetRooms());
        if(room == null)
            return;
        Film film = UserInputObjectSelector.SelectFilm();

        System.out.println("Enter \'dd.MM.yyyy HH:mm\' formated date to show \"" + film.getFilmName() + "\" film on: ");
        try
        {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            String input = scanner.nextLine();
            Calendar calendar = Calendar.getInstance();
            Date startTime = dateFormat.parse(input);
            calendar.setTime(startTime);
            calendar.add(Calendar.MINUTE, film.getMinutesDuration());
            Date endTime = calendar.getTime();
            SessionScheduleItem item = new SessionScheduleItem(film, startTime, endTime);
            room.AddScheduleItem(item);
        }
        catch(ParseException | OperationNotSupportedException ex)
        {
            System.out.println("Failed to add film in a schedule");
        }
    }
}
