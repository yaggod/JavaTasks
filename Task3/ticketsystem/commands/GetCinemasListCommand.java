package ticketsystem.commands;

import java.util.*;
import ticketsystem.Cinema;
import ticketsystem.CinemasRepository;

public class GetCinemasListCommand extends UserCommandBase
{

    @Override
    public String GetDescription() 
    {
        return "Get cinemas list";
    }

    @Override
    public void Execute()
    {
        ArrayList<Cinema> cinemas = CinemasRepository.GetCinemas();
        for (int i = 0; i < cinemas.size(); i++) 
        {
            System.out.println(i + 1 + ": " + cinemas.get(i).GetCinemaName()); 
        }
    }


}
