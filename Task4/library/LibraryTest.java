
package library;

public class LibraryTest 
{
    public static void Test()
    {
        Book book1 = new Book("Philosopher's Stone", "Rowling", 1997);
        Book book2 = new Book("Chamber of Secrets", "Rowling", 1998);
        Book book3 = new Book("1984", "Orwell", 1949);
        
        Library library = new Library();
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.printAllBooks();
        
        library.removeBook(book3);
        library.printAllBooks();

        System.out.println();
        for(Book book : library.findBooksByAuthor("Rowling"))
            System.out.println(book);

        System.out.println();
        for(Book book : library.findBooksByYear(1997))
            System.out.println(book);

        library.printUniqueAuthors();

        library.printAuthorStatistics();
    }
}
