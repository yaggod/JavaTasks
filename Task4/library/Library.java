package library;

import java.util.*;

public class Library 
{
    private final List<Book> books;
    private final Set<String> authors; // why wont we just use authorsBooksCount keys instead of this one?
    private final Map<String, Integer> authorsBooksCount; 

    public Library()
    {
        books = new ArrayList<Book>();
        authors = new HashSet<String>();
        authorsBooksCount = new HashMap<String, Integer>();
    }

    public void addBook(Book book)
    {
        books.add(book);
        String author = book.getAuthor();
        authors.add(author);
        if(!authorsBooksCount.containsKey(author))
            authorsBooksCount.put(author, 0);
        authorsBooksCount.put(author, authorsBooksCount.get(author) + 1);
    }

    public void removeBook(Book book)
    {
        books.remove(book);
        String author = book.getAuthor();
        authorsBooksCount.put(author, authorsBooksCount.get(author) - 1);
    }

    public List<Book> findBooksByAuthor(String author)
    {
        List<Book> result = new ArrayList<Book>();
        for(Book book : books)
        {
            if(book.getAuthor().equals(author))
                result.add(book);
        }

        return result;
    }

    public List<Book> findBooksByYear(int year)
    {
        List<Book> result = new ArrayList<Book>();
        for(Book book : books)
        {
            if(book.getYear() == year)
                result.add(book);
        }

        return result;
    }

    public void printAllBooks()
    {
        System.out.println();
        for(Book book : books)
            System.out.println(book);
    }

    public void printUniqueAuthors()
    {
        System.out.println();
        for(String author : authors)
            System.out.println(author);
    }

    public void printAuthorStatistics()
    {
        System.out.println();
        for(String author : authorsBooksCount.keySet())
            System.out.println(author + " wrote " + authorsBooksCount.get(author) + " books in this library");
    }

}
