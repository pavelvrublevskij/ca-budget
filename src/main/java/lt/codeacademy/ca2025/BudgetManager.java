package lt.codeacademy.ca2025;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class BudgetManager {
	private final BudgetService budgetService = new BudgetService();
	private final BudgetDataIncomeResolver budgetDataIncomeResolver = new BudgetDataIncomeResolver(budgetService);

	public void run() {
		System.out.println("Hello My Budget! This is Demo Version!");

		budgetDataIncomeResolver.resolve();
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
