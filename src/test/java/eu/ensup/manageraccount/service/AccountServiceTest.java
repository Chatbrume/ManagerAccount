package eu.ensup.manageraccount.service;

import eu.ensup.manageraccount.entity.Account;
import eu.ensup.manageraccount.entity.TypeAccount;
import eu.ensup.manageraccount.repository.AccountRepository;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest
{
    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;

    @Test
    public void findAll()
    {
        List<Account> accounts = Arrays.asList(
                new Account(1, 10.0, Date.valueOf("2020-01-01"), TypeAccount.CURRENT),
                new Account(2, 100.0, Date.valueOf("2020-01-02"), TypeAccount.SPARE),
                new Account(3, 5.5, Date.valueOf("2020-01-03"), TypeAccount.CURRENT)
        );

        // given
        when(accountRepository.findAll()).thenReturn(accounts);

        // when
        List<Account> founds = accountService.findAll();
        MatcherAssert.assertThat(founds.size(), Matchers.equalTo(accounts.size()));

        // then
        verify(accountRepository).findAll();
    }

    @Test
    public void findByType()
    {
        List<Account> accounts = Arrays.asList(
                new Account(1, 10.0, Date.valueOf("2020-01-09"), TypeAccount.CURRENT),
                new Account(3, 5.5, Date.valueOf("2020-01-10"), TypeAccount.CURRENT)
        );

        // given
        when(accountRepository.findByType(TypeAccount.CURRENT)).thenReturn(accounts);

        // when
        List<Account> founds = accountService.findByType(TypeAccount.CURRENT);
        MatcherAssert.assertThat(founds.size(), Matchers.equalTo(accounts.size()));

        // then
        verify(accountRepository).findByType(TypeAccount.CURRENT);
    }

    @Test
    public void findById()
    {
        Account account = new Account(2, 100.0, Date.valueOf("2020-01-10"), TypeAccount.SPARE);

        // given
        when(accountRepository.findById(2)).thenReturn(Optional.of(account));

        // when
        Account found = accountService.findById(2);
        MatcherAssert.assertThat(found.getType(), Matchers.equalTo(account.getType()));

        // then
        verify(accountRepository).findById(2);
    }

    @Test
    public void save()
    {
        Account account = new Account(3, 5.5, Date.valueOf("2020-01-10"), TypeAccount.CURRENT);

        // given
        when(accountRepository.save(account)).thenReturn(account);

        // when
        Account found = accountService.save(account);
        MatcherAssert.assertThat(found.getType(), Matchers.equalTo(TypeAccount.CURRENT));

        // then
        verify(accountRepository).save(account);
    }

    @Test
    public void deleteById()
    {
        // given
        when(accountRepository.findById(2)).thenReturn(Optional.empty());

        // when
        boolean found = accountService.deleteById(2);
        MatcherAssert.assertThat(found, Matchers.equalTo(true));

        // then
        verify(accountRepository).deleteById(2);
    }

    @Test
    public void delete()
    {
        Account account = new Account(2, 100.0, Date.valueOf("2020-01-10"), TypeAccount.SPARE);

        // given
        when(accountRepository.findById(2)).thenReturn(Optional.empty());

        // when
        boolean found = accountService.delete(account);
        MatcherAssert.assertThat(found, Matchers.equalTo(true));

        // then
        verify(accountRepository).delete(account);
    }
}
