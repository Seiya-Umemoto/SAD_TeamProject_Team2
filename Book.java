import java.util.*;
/**
 * Book class where books' information is stored
 *
 * @author (2018315056 우메모토 세이야, 2018315036 양유석, 2018315030 이가영, 2018315053 테라오카 유이카)
 * @version (2019/11/28)
 */
public class Book implements Comparable<Book>
{
    private String title;
    private String author;
    private int catalogueNumber;
    private Loan attachedLoan;
    public Book(String title, String author, int catalogueNumber) {
        this.title = title;
        this.author = author;
        this.catalogueNumber = catalogueNumber;
        attachedLoan = null;
    }
    public String toString() { 
        return "Title: " + this.title +", Author: " + this.author + ", Catalogue Number: " + this.catalogueNumber;
    }
    public boolean checkIfAvailable() {
        if(attachedLoan == null)
            return true;
        else
            return false;
    }
    public void registerLoan(Loan newLoan) {
        attachedLoan = newLoan;
    }
    public Loan deleteLoan() {
        Loan tempLoan;
        tempLoan = this.attachedLoan;
        this.attachedLoan = null;
        return tempLoan;
    }
    public int compareTo(Book book) {
        if (book.getCatalogueNumber() == this.catalogueNumber)
            return 0;
        else if(book.getCatalogueNumber() < this.catalogueNumber)
            return -1;
        else
            return 1;
    }
    public String getTitle(){
        return this.title;
    }
    public String getAuthor(){
        return this.author;
    }
    public int getCatalogueNumber() {
        return this.catalogueNumber;
    }
}
