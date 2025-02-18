package lt.codeacademy.ca2025.exception;

public class AmountLessOrEqualZeroException extends Exception{

	public AmountLessOrEqualZeroException() {
		super("Amount must be greater than zero");
	}
}
