import java.util.LinkedList;
import java.util.Iterator;
/**
 * Write a description of class Borrower here.
 *
 * @author (2018315056 우메모토 세이야)
 * @version (2019/11/18)
 */
public class Borrower
{
    private String name;
    private LinkedList<Loan> loans;
    public Borrower(String name) {
        this.name = name;
    }

    public boolean checkIfEligible() {
        if(loans.size() <= 10)
            return true;
        else
            return false;
    }

    public void registerLoans(Loan loan) {
        loans.add(loan);
    }

    // public Loan findLoan(Loan loan) {
        // Iterator it = loans.iterator();
        // while(it.hasNext()){
            // if(it.equals(loan))
                // break;
        // }
        // return loan
    // }

    public void deleteLoan(Loan loan) {
        loans.remove(loan);
    }
    public String getName(){
        return this.name;
    }
}
