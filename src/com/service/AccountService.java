package com.service;

import com.dao.IAccountDAO;
import com.daoImpl.AccountDAOImpl;
import com.pojo.Account;
import com.util.PageUtil;

import java.util.List;

public class AccountService {

    IAccountDAO dao = new AccountDAOImpl();

    //登录
    public Account login(String username,String password){
        return dao.queryByKeyWords(username, password);
    }

    //分页
    public List<Account> queryAll(PageUtil pageUtil){
        return dao.queryAll(pageUtil.getStartIndex(),pageUtil.getPageSize());
    }

    //查询总数
    public int getCount(){
        return dao.getCount();
    }

    //添加
    public boolean add(Account account){
        return dao.add(account) > 0;
    }

    //删除
    public boolean delete(int accountID){
        return dao.delete(accountID) > 0;
    }

    //编辑
    public Account edit(int accountID){
        return dao.queryByKey(accountID);
    }

    //修改
    public boolean update(Account account){
        return dao.update(account) > 0;
    }

    //批量删除
    public boolean deletes(int...accountIDs){
        return new AccountDAOImpl().deletes(accountIDs) > 0;
    }

    //模糊查询
    public List<Account> queryKeyWords(String accountName){
        return dao.queryKeyWords(accountName);
    }
}
