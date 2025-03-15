package ticketsystem;

import java.util.*;

public class FilmsRepository 
{
    private final static ArrayList<Film> films = new ArrayList<>();

    public static void AddFilm(Film film)
    {
        films.add(film);
    }

    public static ArrayList<Film> GetFilms()
    {
        return films;
    }
}
