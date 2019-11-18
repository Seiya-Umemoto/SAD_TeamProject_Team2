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
    private int lastCNumber = 0;
    private TreeSet<Book> books;
    private HashSet<Borrower> borrowers;
    public Library(String name) {
        this.name = name;
    }

    public void registerOneBorrower(String name) {
        Iterator it = borrowers.iterator();
        while(it.hasNext() == true) {
            if(((Borrower)it).getName().equals(name))
                System.out.println("Duplicate Error."); return;
        }
        borrowers.add(new Borrower(name));
    }

    public void registerOneBook(String title, String author) {
        Iterator it = books.iterator();
        while(it.hasNext() == true) {
            if((((Book)it).getTitle().equals(title)) && (((Book)it).getAuthor().equals(title)))
                System.out.println("Duplicate Error."); return;
        }
        books.add(new Book(title, author, lastCNumber));
        lastCNumber += 1;        
    }

    public void displayBooksForLoan() {

    }

    public void displayBooksOnLoan() {
        Iterator it = books.iterator();
        while(it.hasNext()){
            if (((Book)it).checkIfAvailable() == false){
                System.out.println(((Book)it).toString());
            }
        }
    }

    public void lendOneBook() {

    }

    public void returnOneBook() {

    }
}
