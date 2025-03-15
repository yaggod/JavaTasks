package ticketsystem;

public class Seat
{
    private final int seatNumber; 
    private boolean isFree = true;

    public Seat(int seatNumber)
    {
        this.seatNumber = seatNumber;
    }
    
    public int GetSeatNumber() 
    {
        return seatNumber;
    }

    public boolean IsFree() 
    {
        return isFree;
    }

    public void TakeSeat() 
    {
        this.isFree = false;
    }

    public void FreeSeat()
    {
        this.isFree = true;
    }
}