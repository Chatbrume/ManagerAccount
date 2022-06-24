package eu.ensup.manageraccount.repository;

import eu.ensup.manageraccount.ManagerAccountApplication;
import eu.ensup.manageraccount.entity.Account;
import eu.ensup.manageraccount.entity.TypeAccount;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import java.sql.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@ActiveProfiles("test")
@DataJpaTest
@ContextConfiguration(classes = {ManagerAccountApplication.class})
public class AccountRepositoryTest {
    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void testFindAll()
    {
        int search = accountRepository.findAll().size();
        assertThat(search, equalTo(3));
    }

    @Test
    public void testFindByTypeSPARE()
    {
        Account account = new Account(2, 1000, Date.valueOf("2022-04-07"), TypeAccount.SPARE);
        Account search = accountRepository.findByType(TypeAccount.SPARE).get(0);
        assertThat(search.toString(), equalTo(account.toString()));
    }

    @Test
    public void testFindByTypeCURRENT()
    {
        int search = accountRepository.findByType(TypeAccount.CURRENT).size();
        assertThat(search, equalTo(2));
    }

    @Test
    public void testFindById()
    {
        Account account = new Account(2, 1000, Date.valueOf("2022-04-07"), TypeAccount.SPARE);
        Account search = accountRepository.findById(2).orElse(null);
        assertThat(search.toString(), equalTo(account.toString()));
    }

    @Test
    public void testFindByIdNotFound()
    {
        Account search = accountRepository.findById(5).orElse(null);
        assertThat(search, equalTo(null));
    }

    /*@Test
    public void testSave()
    {
        Account account = new Account(4, Date.valueOf("2022-04-10"), TypeAccount.SPARE);
        Account search = accountRepository.save(account);
        assertThat(search.toString(), equalTo(account.toString()));
    }*/

    @Test
    public void testDelete()
    {
        Account account = new Account(1, 0, Date.valueOf("2022-04-06"), TypeAccount.CURRENT);
        accountRepository.delete(account);
        Account search = accountRepository.findById(account.getId()).orElse(null);
        assertThat(search, equalTo(null));
    }

    @Test
    public void testDeleteById()
    {
        Account account = new Account(3, 500, Date.valueOf("2022-04-08"), TypeAccount.CURRENT);
        accountRepository.deleteById(account.getId());
        Account search = accountRepository.findById(account.getId()).orElse(null);
        assertThat(search, equalTo(null));
    }
}