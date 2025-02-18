package lt.codeacademy.ca2025;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Scanner;

public class BudgetDataIncomeResolver {

	private final Scanner sc = new Scanner(System.in);
	private final BudgetService budgetService;

	public BudgetDataIncomeResolver(final BudgetService budgetService) {
		this.budgetService = budgetService;
	}

	public void resolve() {
		System.out.println("Please enter your income record.");
		System.out.print("Amount: ");
		final BigDecimal amount = sc.nextBigDecimal();
		sc.nextLine();
		System.out.print("Description: ");
		final String description = sc.nextLine();
		System.out.print("Is it a bank transfer? (true/false): ");
		final boolean isBankTransfer = sc.nextBoolean();
		System.out.print("Please enter other optional information: ");
		final String optionalInfo = sc.nextLine();

		final IncomeRecord incomeRecord = new IncomeRecord(
				amount, description, LocalDateTime.now(), isBankTransfer, optionalInfo);

		budgetService.setIncomeRecord(incomeRecord);
	}
}
