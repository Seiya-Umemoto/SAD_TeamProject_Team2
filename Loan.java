import java.time.*;
/**
 * Write a description of class Loan here.
 *
 * @author (your name)
 * @version (a version number or a date)
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
