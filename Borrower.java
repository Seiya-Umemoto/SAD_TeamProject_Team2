import java.util.LinkedList;
import java.util.Iterator;
/**
 * Borrower class where borrowers' information is stored
 *
 * @author (2018315056 우메모토 세이야, 2018315036 양유석, 2018315030 이가영, 2018315053 테라오카 유이카)
 * @version (2019/11/28)
 */
public class Borrower
{
    private String name;
    private LinkedList<Loan> loans; //attachedLoans
    public Borrower(String name) {
        this.name = name;
        loans = new LinkedList<Loan>();
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
    
    public void deleteLoan(Loan loan) {
        loans.remove(loan);
    }
    public String toString(){
        return "Name: "+this.name;
    }
    public String getName(){
        return this.name;
    }
}
