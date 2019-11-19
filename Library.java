import java.util.TreeSet;
import java.util.Iterator;
import java.util.HashSet;
/**
 * Library Class where 6 usecases are implemented
 *
 * @author (2018315056 우메모토 세이야, 2018315036 양유석, 2018315030 이가영, 2018315053 테라오카 유이카)
 * @version (2019/11/18)
 */
public class Library
{
    private String name;
    private int lastCatalogueNumber;
    private TreeSet<Book> books;
    private HashSet<Borrower> borrowers;
    public Library(String name) {
        this.name = name;
        lastCatalogueNumber = 0;
        books = new TreeSet<Book>();
        borrowers = new HashSet<Borrower>();
    }

    public void registerOneBorrower(String name) {
        Borrower borrower = null;
        Iterator it = borrowers.iterator();
        while(it.hasNext()) {
            borrower = (Borrower)it.next();
            if(borrower.getName().equals(name)){
                System.out.println("Duplicate Error."); return;}
        }
        Borrower bor = new Borrower(name);
        System.out.println(bor);
        borrowers.add(bor);
    }

    public void registerOneBook(String title, String author) {
        Book book = null;
        Iterator it = books.iterator();
        while(it.hasNext()) {
            book = (Book)it.next();
            if((book.getTitle().equals(title)) && (book.getAuthor().equals(author))) {
                System.out.println("Duplicate Error."); return;}
        }
        Book bk = new Book(title, author, lastCatalogueNumber);
        System.out.println(bk);
        books.add(bk);
        lastCatalogueNumber += 1;
    }

    public void displayBooksForLoan() {
        Book book;
        Iterator it = books.iterator();
        while(it.hasNext()) {
            book = (Book)it.next();
            if(book.checkIfAvailable() == true)
                System.out.println(book.toString());
        }
    }

    public void displayBooksOnLoan() {
        Book book;
        Iterator it = books.iterator();
        while(it.hasNext()){
            book = (Book)it.next();
            if (book.checkIfAvailable() == false){
                System.out.println(book.toString());
            }
        }
    }

    public void lendOneBook(String name, int catalogueNumber) {
        Borrower borrower = null;
        Book book = null;
        Loan newLoan = null;
        Iterator itborrowers = borrowers.iterator();
        while(itborrowers.hasNext()) {
            borrower = (Borrower)itborrowers.next();
            if(borrower.getName().equals(name))
                break;
        }
        Iterator itbooks = books.iterator();
        while(itbooks.hasNext()) {
            book = (Book)itbooks.next();
            if(book.getCatalogueNumber() == catalogueNumber)
                break;
        }
        if((borrower.checkIfEligible()) && (book.checkIfAvailable()))
            newLoan = new Loan();
            borrower.registerLoans(newLoan);
            book.registerLoan(newLoan);
    }

    public void returnOneBook(String name, int catalogueNumber) {
        Borrower borrower = null;
        Book book = null;
        Iterator itBorr = borrowers.iterator();
        while(itBorr.hasNext()) {
            borrower = (Borrower)itBorr.next();
            if(borrower.getName().equals(name))
                break;
        }
        Iterator itBook = books.iterator();
        while(itBook.hasNext()){
            book = (Book)itBook.next();
            if (book.getCatalogueNumber() == catalogueNumber){
                break;
            }
        }
        Loan loan = book.deleteLoan();
        borrower.deleteLoan(loan);
    }
    public String toString(){
        return "도서관 이름: "+this.name;
    }
}
