package com.dao;

import java.util.List;

import com.pojo.Account;

public interface IAccountDAO {

    //查询关键字（用户名、密码）
    public Account queryByKeyWords(String username,String password);
    //分页
    public List<Account> queryAll(int startIndex,int pageSize);
    //总笔数
    public int getCount();
    //添加
    public int add(Account account);
    //删除
    public int delete(int accountID);
    //修改
    public int update(Account account);
    //编辑
    public Account queryByKey(int accountID);
    //批量删除
    public int deletes(int...accountIDs);
    //模糊插叙
    public List<Account> queryKeyWords(String accountName);
}
