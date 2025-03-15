package ticketsystem;

import java.util.*;
import ticketsystem.commands.*;

public class GuestUser extends User
{

    public GuestUser(String login, String password) 
    {
        super(login, password);
    }

    @Override
    public ArrayList<UserCommandBase> GetUserSpecificCommands() 
    {
        ArrayList<UserCommandBase> result = new ArrayList<>();

        return result;
    }
}
