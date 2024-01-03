package com.moz1mozi.aopdemo.dao;

import com.moz1mozi.aopdemo.Account;

public interface AccountDAO {

    void addAccount(Account theAccount, boolean vipFlag);

    boolean doWork();

}
