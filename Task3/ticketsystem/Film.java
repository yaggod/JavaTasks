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

    public String getFilmName()
    {
        return filmName;
    }

    public void setFilmName(String filmName)
    {
        this.filmName = filmName;
    }

    public int getMinutesDuration() 
    {
        return minutesDuration;
    }
}
