package ticketsystem.commands;

import ticketsystem.*;

public class BuyTicketCommand extends UserCommandBase
{

    @Override
    public String GetDescription() 
    {
        return "Buy ticket";
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
        SessionScheduleItem scheduleItem = UserInputObjectSelector.SelectSession(room.GetUpcomingFilms());
        System.out.println(scheduleItem);
        Seat seat = UserInputObjectSelector.SelectSeat(scheduleItem);
        // insert payment logics here (not really)
        if(seat.IsFree())
            seat.TakeSeat();
        else
            System.out.println("Seat is already taken");
    }


}
