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
    private LinkedList<Loan> attachedLoans;
    public Borrower(String name) {
        this.name = name;
        attachedLoans = new LinkedList<Loan>();
    }

    public boolean checkIfEligible() {
        if(attachedLoans.size() <= 10)
            return true;
        else
            return false;
    }

    public void registerLoans(Loan loan) {
        attachedLoans.add(loan);
    }
    
    public void deleteLoan(Loan loan) {
        attachedLoans.remove(loan);
    }
    public String toString(){
        return "Name: "+this.name;
    }
    public String getName(){
        return this.name;
    }
}
