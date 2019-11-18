import java.util.*;
/**
 * Book class where books' information is stored
 *
 * @author (2018315056 우메모토 세이야, 2018315036 양유석, 2018315030 이가영, 2018315053 테라오카 유이카)
 * @version (2019/11/18)
 */
public class Book implements Comparable<Book>
{
    private String title;
    private String author;
    private int catalogueNumber;
    private Loan loan = null;
    public Book(String title, String author, int catalogueNumber) {
        this.title = title;
        this.author = author;
        this.catalogueNumber = catalogueNumber;
    }
    public String toString() {
        return "제목: " + this.title +", 작가: " + this.author + ", 분류 번호: " + this.catalogueNumber;
    }
    public boolean checkIfAvailable() {
        if(loan == null)
            return true;
        else
            return false;
    }
    public void registerLoan(Loan loan) {
        this.loan = loan;
    }
    public Loan deleteLoan() {
        Loan tmp_loan;
        tmp_loan = this.loan;
        this.loan = null;
        return tmp_loan;
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
    public int compareTo(Book book) {
        if (book.getCatalogueNumber() == this.catalogueNumber)
            return 0;
        else if(book.getCatalogueNumber() < this.catalogueNumber)
            return -1;
        else
            return 1;
    }
}
