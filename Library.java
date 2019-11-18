import java.util.*;
/**
 * Write a description of class Library here.
 *
 * @author (2018315056 우메모토 세이야)
 * @version (2019/11/18)
 */
public class Library
{
    private String name;
    private TreeSet<Book> books;
    private HashSet<Borrower> borrowers;
    public Library(String name) {
        this.name = name;
    }

    public void registerOneBorrower(String name) {
        Iterator it = borrowers.iterator();
        while(it.hasNext() == true) {
            if(((Borrower)it).getName().equals(name))
                System.out.println("Duplicate Error.");
                return;
        }
        borrowers.add(new Borrower(name));
    }

    public void registerOneBook(String title, String author) {

    }

    public void displayBooksForLoan() {

    }

    public void displayBooksOnLoan() {

    }

    public void lendOneBook() {

    }

    public void returnOneBook() {

    }
}
