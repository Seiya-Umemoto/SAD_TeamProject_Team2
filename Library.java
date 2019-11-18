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
    private int lastCatalogueNumber = 0;
    private TreeSet<Book> books;
    private HashSet<Borrower> borrowers;
    public Library(String name) {
        this.name = name;
    }

    public void registerOneBorrower(String name) {
        Iterator it = borrowers.iterator();
        while(it.hasNext()) {
            if(((Borrower)it).getName().equals(name))
                System.out.println("Duplicate Error."); return;
        }
        borrowers.add(new Borrower(name));
    }

    public void registerOneBook(String title, String author) {
        Iterator it = books.iterator();
        while(it.hasNext()) {
            if((((Book)it).getTitle().equals(title)) && (((Book)it).getAuthor().equals(title)))
                System.out.println("Duplicate Error."); return;
        }
        books.add(new Book(title, author, lastCatalogueNumber));
        lastCatalogueNumber += 1;        
    }

    public void displayBooksForLoan() {
        Iterator it = books.iterator();
        while(it.hasNext()) {
            if(((Book)it).checkIfAvailable)
                System.out.println();
        }
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

    public void returnOneBook(String name, int catalogueNumber) {
        Iterator itBorr = borrowers.iterator();
        while(itBorr.hasNext()) {
            if(((Borrower)itBorr).getName().equals(name))
                break;
        }
        Iterator itBook = books.iterator();
        while(itBook.hasNext()){
            if (((Book)itBook).getCatalogueNumber() == catalogueNumber){
                break;
            }
        }
        Loan loan = ((Book)itBook).deleteLoan();
        ((Borrower)itBorr).deleteLoan(loan);
    }
}
