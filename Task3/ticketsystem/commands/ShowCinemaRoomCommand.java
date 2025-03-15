package ticketsystem.commands;

import ticketsystem.*;

public class ShowCinemaRoomCommand extends UserCommandBase
{

    @Override
    public String GetDescription() 
    {
        return "Show CinemaRoom";
    }

    @Override
    public void Execute()
    {
        Cinema cinema = UserInputObjectSelector.SelectCinema();
        if(cinema == null)
            return;
        CinemaRoom room = UserInputObjectSelector.SelectRoom(cinema.GetRooms());
        if(room == null)
            return;
        System.out.println(room);
    }
}
