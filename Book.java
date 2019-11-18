import java.util.*;
/**
 * Write a description of class Book here.
 *
 * @author (2018315056 우메모토 세이야)
 * @version (2019/11/18)
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
