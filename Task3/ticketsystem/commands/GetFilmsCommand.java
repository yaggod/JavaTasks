package ticketsystem.commands;

import java.util.*;
import ticketsystem.*;

public class GetFilmsCommand extends UserCommandBase
{

    @Override
    public String GetDescription() 
    {
        return "Get Films list";
    }

    @Override
    public void Execute()
    {
        ArrayList<Film> films = FilmsRepository.GetFilms();
        for(int i = 0; i < films.size(); i++)
        {
            Film film = films.get(i);
            System.out.println(i + 1 + ": " + film.GetFilmName() + "\t" + film.GetMinutesDuration() + " minutes long");
        }
    }
}
