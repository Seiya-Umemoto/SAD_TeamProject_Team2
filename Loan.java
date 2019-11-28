import java.time.*;
/**
 * Loan class where loan information is stored
 *
 * @author (2018315056 우메모토 세이야, 2018315036 양유석, 2018315030 이가영, 2018315053 테라오카 유이카)
 * @version (2019/11/28)
 */
public class Loan
{
	private LocalDate borrowDate;
	private LocalDate returnDate;
	public Loan() {
		borrowDate = LocalDate.now();
		returnDate = borrowDate.plusWeeks(2);
	}
}
