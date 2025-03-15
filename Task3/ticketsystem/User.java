package ticketsystem;

import java.util.*;
import ticketsystem.commands.BuyTicketCommand;
import ticketsystem.commands.FindUpcomingSessionsCommand;
import ticketsystem.commands.GetCinemasListCommand;
import ticketsystem.commands.GetFilmsCommand;
import ticketsystem.commands.ShowCinemaRoomCommand;
import ticketsystem.commands.UserCommandBase;

public abstract class User 
{
    protected final String login;
    protected String password;

    public User(String login, String password)
    {
        this.login = login;
        this.password = password;
    }

    public boolean TryToLogin(String login, String password)
    {
        return this.login.equals(login) && this.password.equals(password);
    }
    public ArrayList<UserCommandBase> GetAllCommands()
    {
        ArrayList<UserCommandBase> result = new ArrayList<>();
        result.addAll(GetBasicCommands());
        result.addAll(GetUserSpecificCommands());

        return result;
    }

    public ArrayList<UserCommandBase> GetBasicCommands() // lazy initialization would've been better but who cares
    {
        ArrayList<UserCommandBase> result = new ArrayList<>();
        result.add(new GetCinemasListCommand());
        result.add(new ShowCinemaRoomCommand());
        result.add(new GetFilmsCommand());
        result.add(new FindUpcomingSessionsCommand());
        result.add(new BuyTicketCommand());

        return result;
    }

    public abstract ArrayList<UserCommandBase> GetUserSpecificCommands();
}
