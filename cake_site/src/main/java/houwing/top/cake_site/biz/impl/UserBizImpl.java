package houwing.top.cake_site.biz.impl;

import houwing.top.cake_site.biz.UserBiz;
import houwing.top.cake_site.dao.AccountDao;
import houwing.top.cake_site.dao.UserDao;
import houwing.top.cake_site.entity.Account;
import houwing.top.cake_site.global.DaoFactory;

import java.util.List;

public class UserBizImpl implements UserBiz {

    UserDao userDao= DaoFactory.getInstance().getDao(UserDao.class);
    AccountDao accountDao=DaoFactory.getInstance().getDao(AccountDao.class);

    public List<Account> getAll() {
        return userDao.getAll();
    }

    public void deleteUser(int id) {
        userDao.delete(id);
    }

    public void lockUser(int id) {
        userDao.lock(id);
    }

    public void unlockUser(int id) {
        userDao.unlock(id);
    }

    public void insertUser(Account account) {
        userDao.insert(account);
    }

    public Account selectByUsername(Account account) {
        List<Account> accounts = accountDao.selectByName(account.getUsername());
        for (Account acc:accounts) {
            if(acc.getPriority()==0&&acc.isLock()==false){
                if(acc.getUserpass().equals(account.getUserpass()))
                    return acc;
            }else if(acc.getPriority()==0&&acc.isLock()==true){
                //锁定
                return new Account(acc.getId(),true);
            }else if(acc.getPriority()!=0){
                //管理员
                return new Account(acc.getPriority());
            }else {
                //查无此人
                return null;
            }
        }
        return null;

    }

}
