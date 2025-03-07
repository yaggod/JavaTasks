package ticketsystem;

public class Seat
{
    private final int seatNumber; 
    private boolean isFree = true;

    public Seat(int seatNumber)
    {
        this.seatNumber = seatNumber;
    }
    
    public int getSeatNumber() 
    {
        return seatNumber;
    }

    public boolean isFree() 
    {
        return isFree;
    }

    public void takeSeat() 
    {
        this.isFree = false;
    }

    public void freeSeat()
    {
        this.isFree = true;
    }
}