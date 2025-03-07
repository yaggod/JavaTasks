package ticketsystem;

import ticketsystem.examples.*;

public class Program
{
    public static void main(String[] args) 
    {
        System.out.println(ExampleCinemaGenerator.GetExampleCinema().allRooms.get(0));
    }
}