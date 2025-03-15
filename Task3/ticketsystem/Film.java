package ticketsystem;

public class Film 
{
    String filmName;
    int minutesDuration;

    public Film(String filmName, int minutesDuration)
    {
        this.filmName = filmName;
        this.minutesDuration = minutesDuration;
    }

    public String GetFilmName()
    {
        return filmName;
    }

    public void SetFilmName(String filmName)
    {
        this.filmName = filmName;
    }

    public int GetMinutesDuration() 
    {
        return minutesDuration;
    }
}
