package eu.ensup.manageraccount.controller;

import eu.ensup.manageraccount.entity.Account;
import eu.ensup.manageraccount.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "accounts")
public class AccountController
{
    @Autowired
    private AccountRepository accountRepository;

    @GetMapping(path = "/")
    public List<Account> getAll()
    {
        return accountRepository.findAll();
    }

    @PostMapping(path = "/")
    public Account create(@RequestBody Account account)
    {
        return accountRepository.save(account);
    }

    @GetMapping(path = "/{id}")
    public Account get(@PathVariable(name = "id") Integer id)
    {
        return accountRepository.findById(id).orElse(null);
    }

    @PutMapping(path = "/{id}")
    public Account update(@PathVariable(name = "id") Integer id, @RequestBody Account account)
    {
        account.setId(id);
        return accountRepository.save(account);
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable(name = "id") Integer id)
    {
        accountRepository.deleteById(id);
    }
}
