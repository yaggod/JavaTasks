package ticketsystem.commands;

public abstract class UserCommandBase 
{
    protected String description;

    public UserCommandBase(String description)
    {
        this.description = description;
    }

    public abstract void Execute();

    @Override
    public String toString()
    {
        return description;
    }
}
