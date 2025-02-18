package lt.codeacademy.ca2025;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.List;
import lt.codeacademy.ca2025.exception.AmountLessOrEqualZeroException;

public class BudgetManager {
	private final BudgetService budgetService = new BudgetService();
	private final BudgetDataIncomeResolver budgetDataIncomeResolver = new BudgetDataIncomeResolver(budgetService);

	public void run() {
		System.out.println("Hello My Budget! This is Demo Version!");

		while (true) {
			try {
				budgetDataIncomeResolver.resolve();
				break;
			} catch (AmountLessOrEqualZeroException e) {
				System.out.println(e.getMessage().concat(" Please try again."));
			} catch (InputMismatchException e) {
				System.out.println("Entered last value is not correct. Please try again.");
			}
		}

		final ExpenseRecord expenseRecord = new ExpenseRecord(
				BigDecimal.valueOf(100), "Food", LocalDateTime.now(), PaymentMethodType.CARD, new BankCard("Revolut", "1234"));
		budgetService.setExpenseRecords(expenseRecord);

		printIncomeRecords();
		printExpenseRecords();
	}

	private void printIncomeRecords() {
		final List<IncomeRecord> records = budgetService.getIncomeRecords();
		for (IncomeRecord record : records) {
			System.out.println(record);
		}
	}

	private void printExpenseRecords() {
		final List<ExpenseRecord> records = budgetService.getExpenseRecords();
		for (ExpenseRecord record : records) {
			System.out.println(record);
		}
	}
}
