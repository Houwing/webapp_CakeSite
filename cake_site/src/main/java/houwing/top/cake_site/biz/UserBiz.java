package houwing.top.cake_site.biz;

import houwing.top.cake_site.entity.Account;

import java.util.List;

public interface UserBiz {
    List<Account> getAll();
    void deleteUser(int id);
    void lockUser(int id);
    void unlockUser(int id);
    void insertUser(Account account);
    Account selectByUsername(Account account);
}
