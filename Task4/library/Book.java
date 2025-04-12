package library;

public class Book
{
    private final String title;
    private final String author;
    private final int year;

    public Book(String title, String author, int year)
    {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString()
    {
        return title + " by " + author + " from year " + year; 
    }

    @Override
    public int hashCode()
    {
        return toString().hashCode();
    }

    @Override
    public boolean equals(Object object)
    {
        if(!(object instanceof Book))
            return false;
        Book bookObject = (Book) object;
        return (this.author.equals(bookObject.author)) &&
                (this.author.equals(bookObject.author)) &&
                (this.year == bookObject.year);
    }

    public String getTitle()
    {
        return title;
    }

    public String getAuthor()
    {
        return author;
    }

    public int getYear()
    {
        return year;
    }
}