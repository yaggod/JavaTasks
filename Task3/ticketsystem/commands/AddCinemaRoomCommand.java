package ticketsystem.commands;

import java.util.*;
import ticketsystem.Cinema;
import ticketsystem.CinemaRoom;
import ticketsystem.UserInputObjectSelector;

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
        Cinema cinema = UserInputObjectSelector.SelectCinema();
        if(cinema == null)
            return;
            
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
