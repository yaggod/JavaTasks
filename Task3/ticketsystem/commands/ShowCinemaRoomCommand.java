package ticketsystem.commands;

import java.util.*;
import ticketsystem.Cinema;

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
        Scanner scanner = new Scanner(System.in);
        if(Cinema.GetCinemas().size() < 1)
        {
            System.out.println("No cinemas to show room in");
            return;
        }
        System.out.println("Enter index of Cinema to show room in: ");
        int cinemaIndex;
        do
        {
            cinemaIndex = scanner.nextInt();
        }
        while(cinemaIndex < 1 | cinemaIndex > Cinema.GetCinemas().size());
        Cinema cinema = Cinema.GetCinemas().get(cinemaIndex - 1);
        if(cinema.GetRooms().size() < 1)
        {
            System.out.println("No rooms to show");
            return;
        }
        System.out.println("Enter index of Room to show: ");
        int roomIndex;
        do
        {
            roomIndex = scanner.nextInt();
        }
        while(roomIndex < 1 | roomIndex > cinema.GetRooms().size());

        System.out.println(cinema.GetRooms().get(roomIndex - 1));
    }
}
