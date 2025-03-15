package ticketsystem;

import java.util.*;
import ticketsystem.commands.CommandExecuter;
public class Program
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        User user;
        do
        {
        System.out.println("Enter user login: ");
        String login = scanner.nextLine();
        System.out.println("Enter user password: ");
        String password = scanner.nextLine();
        user = AuthorizationSystem.TryToLogin(login, password);
        if(user != null)
            break;

        System.out.println("Incorrect password or username");
        }
        while(true);
        CommandExecuter.RunCommandExecutionLoop(user);
    
    }
}