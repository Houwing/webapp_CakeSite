package houwing.top.cake_site.biz;

import houwing.top.cake_site.entity.Account;

public interface AccountBiz {
    Account login(String username,String userpass);
}
