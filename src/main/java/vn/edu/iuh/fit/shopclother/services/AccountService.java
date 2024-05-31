package vn.edu.iuh.fit.shopclother.services;

import vn.edu.iuh.fit.shopclother.entity.Account;

import java.util.List;

public interface AccountService {
    public Account create(Account account);

    public List<Account> getAccounts();

    public Account findAccountById(String username);

//    public boolean removeAccount(String username);

}
