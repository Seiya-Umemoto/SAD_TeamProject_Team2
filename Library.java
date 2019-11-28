import java.util.TreeSet;
import java.util.Iterator;
import java.util.HashSet;
/**
 * Library Class where 6 usecases are implemented
 *
 * @author (2018315056 우메모토 세이야, 2018315036 양유석, 2018315030 이가영, 2018315053 테라오카 유이카)
 * @version (2019/11/28)
 */
public class Library
{ //변수 이름을 변경하는 것은 어떨까? 일단 다이어그램대로 구현했음.
    private String name; //name of this Library object
    private int lastCatalogueNumber;
    private TreeSet<Book> registeredBooks; //registeredBooks
    private HashSet<Borrower> registeredBorrowers; //registeredBorrowers // 휜색 마름모
    public Library(String name) {
        this.name = name;
        lastCatalogueNumber = 0;
        registeredBooks = new TreeSet<Book>(); //registeredBooks
        registeredBorrowers = new HashSet<Borrower>(); //registeredBorrowers
    }

    public void registerOneBorrower(String name) {
        Borrower borrower = null;
        Iterator<Borrower> it = registeredBorrowers.iterator();
        while(it.hasNext()) {
            borrower = it.next();
            if(borrower.getName().equals(name)){
                System.out.println("Duplicate Error."); return;}
        }
        Borrower bor = new Borrower(name);
        System.out.println(bor);
        registeredBorrowers.add(bor); //registered
    }

    public void registerOneBook(String title, String author) {
        Book book = null;
        Iterator<Book> it = registeredBooks.iterator();
        while(it.hasNext()) {
            book = it.next();
            if((book.getTitle().equals(title)) && (book.getAuthor().equals(author))) {
                System.out.println("Duplicate Error."); return;}
        }
        Book bk = new Book(title, author, lastCatalogueNumber);
        System.out.println(bk);
        registeredBooks.add(bk);
        lastCatalogueNumber += 1;
    }

    public void displayBooksForLoan() {
        Book book;
        Iterator<Book> it = registeredBooks.iterator();
        while(it.hasNext()) {
            book = it.next();
            if(book.checkIfAvailable() == true)
                System.out.println(book.toString());
        }
    }

    public void displayBooksOnLoan() {
        Book book;
        Iterator<Book> it = registeredBooks.iterator();
        while(it.hasNext()){
            book = it.next();
            if (book.checkIfAvailable() == false){
                System.out.println(book.toString());
            }
        }
    }

    public void lendOneBook(String name, int catalogueNumber) {
        Borrower borrower = null;
        Book book = null;
        Loan newLoan = null;
        Iterator<Borrower> itborrowers = registeredBorrowers.iterator();
        while(itborrowers.hasNext()) {
            borrower = itborrowers.next();
            if(borrower.getName().equals(name))
                break;
        }
        Iterator<Book> itbooks = registeredBooks.iterator();
        while(itbooks.hasNext()) {
            book = itbooks.next();
            if(book.getCatalogueNumber() == catalogueNumber)
                break;
        }
        if((borrower.checkIfEligible()) && (book.checkIfAvailable())) {
            newLoan = new Loan();
            borrower.registerLoans(newLoan);
            book.registerLoan(newLoan);
        } else if(borrower.checkIfEligible()) {
            System.out.println(borrower.toString() + "- can't borrow ");
        } else
            System.out.println(book.toString() + "- can't be borrowed");
    } //try and catch?

    public void returnOneBook(String name, int catalogueNumber) {
        Borrower borrower = null;
        Book book = null;
        Iterator<Borrower> itBorr = registeredBorrowers.iterator();
        while(itBorr.hasNext()) {
            borrower = itBorr.next();
            if(borrower.getName().equals(name))
                break;
        }
        Iterator<Book> itBook = registeredBooks.iterator();
        while(itBook.hasNext()){
            book = itBook.next();
            if (book.getCatalogueNumber() == catalogueNumber){
                break;
            }
        }
        Loan loan = book.deleteLoan();
        borrower.deleteLoan(loan); //loan과 관련이 있는가?
    }

    public String toString(){
        return "Library Name: "+this.name;
    }
}
