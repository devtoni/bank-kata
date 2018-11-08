import java.util.List;

public class Account {
    private final Printer printer;
    private final Repository repository;

    public Account(Printer printer, Repository repository) {
        this.printer = printer;
        this.repository = repository;
    }

    public void deposit(int amount) {
        repository.addDeposit(amount);
    }

    public void withdraw(int amount) {
        repository.addWithdraw(amount);
    }

    public void print() {
        List<Transaction> transactions = repository.getAllTransactions();
        printer.print(transactions);
    }
}
