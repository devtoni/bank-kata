import java.util.LinkedList;
import java.util.List;

public class InMemoryRepository implements Repository {

    private final List<Transaction> transactions;
    private Clock clock;

    public InMemoryRepository(Clock clock) {
        this.clock = clock;
        this.transactions = new LinkedList<Transaction>();
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactions;
    }

    @Override
    public void addDeposit(int amount) {
       transactions.add(new Transaction(amount, clock.getTransactionDate()));
    }
}
