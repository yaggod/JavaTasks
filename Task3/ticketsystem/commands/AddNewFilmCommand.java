package ticketsystem.commands;

import java.util.*;
import ticketsystem.*;

public class AddNewFilmCommand extends UserCommandBase
{

    @Override
    public String GetDescription() 
    {
        return "Add new Film";
    }

    @Override
    public void Execute()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of Film: ");
        String filmName = scanner.next();
        System.out.println("Enter Film duration in minutes: ");
        int duration  = scanner.nextInt();
        Film film = new Film(filmName, duration);
        FilmsRepository.AddFilm(film);
    }


}
