import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

public class AccountShould {
    @Test
    public void make_a_deposit(){
        Clock clock = Mockito.mock(Clock.class);
        Repository repository = new InMemoryRepository(clock);
        Device console = new Console();
        Printer printer = new Printer(console);
        int amount = 2000;
        String dateOfTransaction = "11/11/2018";
        when(clock.getTransactionDate()).thenReturn("11/11/2018");

        Account account = new Account(printer, repository);
        account.deposit(amount);
        Transaction expectedTransaction = new Transaction(amount, dateOfTransaction);

        List<Transaction> transactions = repository.getAllTransactions();
        Transaction transaction = transactions.get(0);
        assertThat(transactions.size(), is(1));
        assertThat(expectedTransaction, is(transaction));
    }
}
