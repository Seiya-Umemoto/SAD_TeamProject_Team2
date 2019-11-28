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
{ 
    private String name;
    private int lastCatalogueNumber;
    private TreeSet<Book> registeredBooks;
    private HashSet<Borrower> registeredBorrowers;
    public Library(String name) {
        this.name = name;
        lastCatalogueNumber = 0;
        registeredBooks = new TreeSet<Book>();
        registeredBorrowers = new HashSet<Borrower>();
    }

    public void registerOneBorrower(String name) {
        Borrower eachBorrower = null;
        Iterator<Borrower> it = registeredBorrowers.iterator();
        while(it.hasNext()) {
            eachBorrower = it.next();
            if(eachBorrower.getName().equals(name)){
                System.out.println("Duplicate Error."); return;}
        }
        Borrower borrowerToRegister = new Borrower(name);
        System.out.println(borrowerToRegister);
        registeredBorrowers.add(borrowerToRegister);
    }

    public void registerOneBook(String title, String author) {
        Book eachBook = null;
        Iterator<Book> it = registeredBooks.iterator();
        while(it.hasNext()) {
            eachBook = it.next();
            if((eachBook.getTitle().equals(title)) && (eachBook.getAuthor().equals(author))) {
                System.out.println("Duplicate Error."); return;}
        }
        Book bookToRegister = new Book(title, author, lastCatalogueNumber);
        System.out.println(bookToRegister);
        registeredBooks.add(bookToRegister);
        lastCatalogueNumber += 1; //일련번호 생성 방법 바꿀 필요가 있음
    }

    public void displayBooksForLoan() {
        Book eachBook;
        Iterator<Book> it = registeredBooks.iterator();
        while(it.hasNext()) {
            eachBook = it.next();
            if(eachBook.checkIfAvailable() == true)
                System.out.println(eachBook.toString());
        }
    }

    public void displayBooksOnLoan() {
        Book eachBook;
        Iterator<Book> it = registeredBooks.iterator();
        while(it.hasNext()) {
            eachBook = it.next();
            if (eachBook.checkIfAvailable() == false){
                System.out.println(eachBook.toString());
            }
        }
    }

    public void lendOneBook(String name, int catalogueNumber) {
        Borrower eachBorrower = null;
        Book eachBook = null;
        Loan newLoan = null;
        Iterator<Borrower> itBorrowers = registeredBorrowers.iterator();
        while(itBorrowers.hasNext()) {
            eachBorrower = itBorrowers.next();
            if(eachBorrower.getName().equals(name))
                break;
        }
        Iterator<Book> itBooks = registeredBooks.iterator();
        while(itBooks.hasNext()) {
            eachBook = itBooks.next();
            if(eachBook.getCatalogueNumber() == catalogueNumber)
                break;
        }
        if((eachBorrower.checkIfEligible()) && (eachBook.checkIfAvailable())) {
            newLoan = new Loan();
            eachBorrower.registerLoans(newLoan);
            eachBook.registerLoan(newLoan);
        } else if(eachBook.checkIfAvailable() == false)
            System.out.println(eachBook.toString() + " - can't be borrowed");
        else if(eachBorrower.checkIfEligible() == false)
            System.out.println(eachBorrower.toString() + " - can't borrow");
    }

    public void returnOneBook(String name, int catalogueNumber) {
        Borrower eachBorrower = null;
        Book eachBook = null;
        Iterator<Borrower> itBorrowers = registeredBorrowers.iterator();
        while(itBorrowers.hasNext()) {
            eachBorrower = itBorrowers.next();
            if(eachBorrower.getName().equals(name))
                break;
        }
        Iterator<Book> itBooks = registeredBooks.iterator();
        while(itBooks.hasNext()) {
            eachBook = itBooks.next();
            if (eachBook.getCatalogueNumber() == catalogueNumber){
                break;
            }
        }
        Loan loan = eachBook.deleteLoan();
        eachBorrower.deleteLoan(loan);
    }

    public String toString(){
        return "Library Name: "+this.name;
    }
}
