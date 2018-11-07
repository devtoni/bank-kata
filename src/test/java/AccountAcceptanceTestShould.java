import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AccountAcceptanceTestShould {
    @Test
    public void be_able_to_make_transactions_of_deposit_and_withdrawal_and_print_all_of_them(){
        Device console = Mockito.mock(Device.class);
        Clock clock = Mockito.mock(Clock.class);
        Printer printer = new Printer(console);
        Repository repository = new InMemoryRepository(clock);
        when(clock.getTransactionDate()).thenReturn("10/01/2012", "13/01/2012", "14/01/2012");

        Account account = new Account(printer, repository);
        account.deposit(1000);
        account.deposit(2000);
        account.withdraw(500);
        account.print();

        verify(console).print("date || credit || debit || balance");
        verify(console).print("14/01/2012 || || 500.00 || 2500.00");
        verify(console).print("13/01/2012 || 2000.00 || || 3000.00");
        verify(console).print("10/01/2012 || 1000.00 || || 1000.00");

    }
}
