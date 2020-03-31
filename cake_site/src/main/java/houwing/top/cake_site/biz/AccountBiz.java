package houwing.top.cake_site.biz;

import houwing.top.cake_site.entity.Account;

import java.util.List;

public interface AccountBiz {
    Account login(String username,String userpass);
    List<Account> getAllAdmin();
    void  insertAccount(Account account);
    Account selectById(int id);
    void  updateAccount(Account account);
    void  deleteAccount(int id);
}
