package houwing.top.cake_site.biz.impl;

import houwing.top.cake_site.biz.AccountBiz;
import houwing.top.cake_site.dao.AccountDao;
import houwing.top.cake_site.entity.Account;
import houwing.top.cake_site.global.DaoFactory;

import java.util.List;

public class AccountBizImpl implements AccountBiz {

    private AccountDao accountDao= DaoFactory.getInstance().getDao(AccountDao.class);


    public Account login(String username, String userpass) {
        List<Account> list=accountDao.selectByName(username);
        for (Account account:list) {
            if (account.getUserpass().equals(userpass)){
                return account;
            }
        }
        return null;
    }
}
