import java.util.List;

public interface Repository {
    List<Transaction> getAllTransactions();

    void addDeposit(int amount);

    void addWithdraw(int amount);
}
