package ticketsystem.commands;

import java.util.*;
import ticketsystem.*;

public class CommandExecuter 
{
    private static Scanner scanner = new Scanner(System.in);
    public static void RunCommandExecutionLoop(User user)
    {
        ArrayList<UserCommandBase> commands = user.GetAllCommands();
        while(true)
        {
            RunOneOfCommands(commands);
        }
    }

    public static void RunOneOfCommands(ArrayList<UserCommandBase> commands)
    {
        int commandToRunIndex;

        System.out.println("\n\n\nAvailible commands: ");
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
        commands.get(commandToRunIndex - 1).ShowDescriptionAndExecute();
    }
}
