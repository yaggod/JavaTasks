package ticketsystem;

import java.util.*;

public class CinemasRepository 
{
    private final static ArrayList<Cinema> cinemas = new ArrayList<>();

    public static void AddCinema(Cinema cinema)
    {
        cinemas.add(cinema);
    }

    public static ArrayList<Cinema>  GetCinemas()
    {
        return cinemas;
    }
}
