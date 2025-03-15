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
    public ArrayList<UserCommandBase> GetUserSpecificCommands() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
