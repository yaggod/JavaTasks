package ticketsystem.commands;

import java.util.*;
import ticketsystem.*;

public class CommandExecuter 
{
    public static void RunCommandExecutionLoop(User user)
    {
        ArrayList<UserCommandBase> commands = user.GetAllCommands();
        Scanner scanner = new Scanner(System.in);
        int commandToRunIndex;
        for(int i = 0; i < commands.size(); i++)
        {
            System.out.println((i + 1) + ": " +  commands.get(i).GetDescription());
        }

        do
        {
            System.out.println("Enter command index: ");
            commandToRunIndex = scanner.nextInt();
        }
        while(commandToRunIndex < 1 | commandToRunIndex > commands.size());
        commands.get(commandToRunIndex - 1).Execute();


    }
}
