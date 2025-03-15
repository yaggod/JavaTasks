package ticketsystem.commands;

import java.util.*;
import ticketsystem.Cinema;

public class AddCinemaCommand extends UserCommandBase
{

    @Override
    public String GetDescription() 
    {
        return "Add new Cinema";
    }

    @Override
    public void Execute()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of your Cinema: ");
        String cinemaName = scanner.next();
        Cinema newCinema = new Cinema(cinemaName);
        Cinema.AddCinema(newCinema);
    }


}
