package ticketsystem.commands;

public abstract class UserCommandBase 
{
    public UserCommandBase()
    {
    }

    public abstract String GetDescription();

    public abstract void Execute();

    @Override
    public String toString()
    {
        return GetDescription();
    }
}
