package ticketsystem;

import java.util.*;
import ticketsystem.commands.*;

public class AdminUser extends User
{

    public AdminUser(String login, String password) 
    {
        super(login, password);
    }

    @Override
    public ArrayList<UserCommandBase> GetUserSpecificCommands() 
    {
        ArrayList<UserCommandBase> result = new ArrayList<>();
        result.add(new AddCinemaCommand());
        result.add(new AddCinemaRoomCommand());
        result.add(new AddNewFilmCommand());
        result.add(new AddFilmSession());

        return result;
    }
}
