import java.time.*;
/**
 * Write a description of class Loan here.
 *
 * @author (2018315056 우메모토 세이야)
 * @version (2019/11/18)
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
