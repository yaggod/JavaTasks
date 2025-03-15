package ticketsystem.commands;

import java.util.*;
import ticketsystem.Cinema;
import ticketsystem.CinemaRoom;

public class AddCinemaRoomCommand extends UserCommandBase
{

    @Override
    public String GetDescription() 
    {
        return "Add new CinemaRoom";
    }

    @Override
    public void Execute()
    {
        Scanner scanner = new Scanner(System.in);
        if(Cinema.GetCinemas().size() < 1)
        {
            System.out.println("No cinemas too add room in");
            return;
        }
        System.out.println("Enter index of Cinema too add room in: ");
        int cinemaIndex;
        do
        {
            cinemaIndex = scanner.nextInt();
        }
        while(cinemaIndex < 1 | cinemaIndex > Cinema.GetCinemas().size());


        Cinema cinema = Cinema.GetCinemas().get(cinemaIndex - 1);
        System.out.println("Enter rows count in the room: ");
        int rowsCount = scanner.nextInt();
        ArrayList<Integer> columns = new ArrayList<>();
        for(int i = 0; i < rowsCount; i++)
        {
            System.out.println("Enter sits count in row " + (i + 1) + ": ");
            columns.add(scanner.nextInt());
        }
        CinemaRoom room = new CinemaRoom(columns);
        cinema.AddRoom(room);
    
    
    }
}
