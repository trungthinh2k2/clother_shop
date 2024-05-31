package vn.edu.iuh.fit.shopclother.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.shopclother.entity.Account;
import vn.edu.iuh.fit.shopclother.repositoties.AccountRepository;
import vn.edu.iuh.fit.shopclother.services.AccountService;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;



    @Override
    public Account create(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account findAccountById(String username) {
        return accountRepository.findById(username).get();
    }

//    @Override
//    public boolean removeAccount(String username) {
//        return accountRepository.delete(username) > 0;
//    }
}
