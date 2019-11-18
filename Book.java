import java.util.*;
/**
 * Write a description of class Book here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Book
{
    private String title;
    private String author;
    private int catalogueNumber;
    private Loan loan;
    public Book(String title, String author, int catalogueNumber) {
        this.title = title;
        this.author = author;
        this.catalogueNumber = catalogueNumber;
    }
    @Override
    public String toString() {

    }
    public boolean checkifAvailable() {
        
    }
    public void registerLoan(Loan loan) {
        
    }
    public Loan deleteLoan() {
        
    }
}
