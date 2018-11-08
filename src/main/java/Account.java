public class Account {
    private final Printer console;
    private final Repository repository;

    public Account(Printer console, Repository repository) {
        this.console = console;
        this.repository = repository;
    }

    public void deposit(int amount) {
        repository.addDeposit(amount);
    }

    public void withdraw(int amount) {
        repository.addWithdraw(amount);
    }

    public void print() {
    }
}
