package com.daoImpl;

import com.dao.IAccountDAO;
import com.pojo.Account;
import com.util.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDAOImpl implements IAccountDAO {

    private DBUtils db = new DBUtils();
    //登录
    @Override
    public Account queryByKeyWords(String username, String password) {
    	//打开连接
        Connection conn = db.openConnection();
        //查询数据库
        String sql = "select * from account where AccountName = ? and AccountPassword = ?";
        Account account = null;
        //调用查询方法，返回结果集
        ResultSet set = db.query(conn, sql, username, password);
        //循环取值
        try {
            if(set.next()){
            	//获取
                int accountID = set.getInt("AccountID");
                String accountName = set.getString("AccountName");
                String accountPassword = set.getString("AccountPassword");
                String accountIsStop = set.getString("AccountIsStop");
                String accountRole = set.getString("AccountRole");
                
                account = new Account(accountID,accountName,
                        accountPassword,accountIsStop,accountRole);
            }
            set.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            db.closeConnection(conn);
        }

        return account;
    }

    //分页
    @Override
    public List<Account> queryAll(int startIndex, int pageSize) {
        //声明一个List集合实体对象
        List<Account> aList = new ArrayList<Account>();
        //打开连接
        Connection conn = db.openConnection();
        //编写SQL
        String sql = "SELECT * FROM account LIMIT ?,?";
        //调用查询方法，返回结果集
        ResultSet set = db.query(conn, sql,startIndex,pageSize);
        //循环取值
        try {
            while (set.next()) {
                int accountID = set.getInt("AccountID");
                String accountName = set.getString("AccountName");
                String accountPassword = set.getString("AccountPassword");
                String accountIsStop = set.getString("AccountIsStop");
                String accountRole = set.getString("AccountRole");
                //声明是一个实体
                Account account = new Account(accountID, accountName, accountPassword,
                        accountIsStop, accountRole);
                //添加到集合中
                aList.add(account);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            try {
                set.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            db.closeConnection(conn);
        }
        return aList;
    }

    //查询总笔数
    @Override
    public int getCount() {
        int count = 0;
        Connection conn = db.openConnection();
        String sql = "select count(*) from account";
        ResultSet set = db.query(conn,sql);
        try {
            if (set.next()){
                count = set.getInt(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                set.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            db.closeConnection(conn);
        }
        return count;
    }

    //添加
    @Override
    public int add(Account account) {
        Connection conn = db.openConnection();
        String sql = "insert into account(AccountID,AccountName,AccountPassword,AccountIsStop,AccountRole)" +
                " values(NULL,?,?,?,?)";
        int count = db.update(conn,sql,account.getAccountName(),account.getAccountPassword(),
                account.getAccountIsStop(),account.getAccountRole());
        db.closeConnection(conn);
        return count;
    }

    @Override
    public int delete(int accountID) {
        Connection conn = db.openConnection();
        String sql = "delete from account where accountID = ?";
        int count = db.update(conn,sql,accountID);
        db.closeConnection(conn);
        return count;
    }

    @Override
    public int update(Account account) {
        Connection conn = db.openConnection();
        String sql = "update account set AccountName = ? , AccountPassword = ? , AccountIsStop = ? , AccountRole = ? where AccountID = ?";
        int count = db.update(conn,sql,account.getAccountName(),account.getAccountPassword(),
                account.getAccountIsStop(),account.getAccountRole(),account.getAccountID());
        db.closeConnection(conn);
        return count;
    }

    @Override
    public Account queryByKey(int accountID) {
        Connection conn = db.openConnection();
        String sql = "select * from account where accountID = ?";
        ResultSet set = db.query(conn,sql,accountID);
        Account account = null;
        try {
            while (set.next()){
                int accountId = set.getInt("AccountID");
                String accountName = set.getString("AccountName");
                String accountPassword = set.getString("AccountPassword");
                String accountIsStop = set.getString("AccountIsStop");
                String accountRole = set.getString("AccountRole");
                account = new Account(accountId,accountName,accountPassword,accountIsStop,accountRole);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                set.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            db.closeConnection(conn);
        }
        return account;
    }

    @Override
    public int deletes(int... accountIDs) {
        Object[] params = new Object[accountIDs.length];
        Connection conn = db.openConnection();
        String sql = "delete from account where accountID in(0";
        for (int i = 0; i < accountIDs.length; i++) {
            sql = sql + ",?";
            params[i] = accountIDs[i];
        }
        sql +=")";
        int counter = db.update(conn,sql,params);
        db.closeConnection(conn);
        return counter;
    }

    @Override
    public List<Account> queryKeyWords(String accountName) {
        List<Account> aList = new ArrayList<Account>();
        Connection conn = db.openConnection();
        String sql = "select * from account where accountName like ?";
        ResultSet set = db.query(conn,sql,"%"+accountName+"%");
        try {
            while (set.next()){
                int accountID = set.getInt("AccountID");
                String accountname = set.getString("AccountName");
                String accountPassword = set.getString("AccountPassword");
                String accountIsStop = set.getString("AccountIsStop");
                String accountRole = set.getString("AccountRole");
                Account account = new Account(accountID,accountname,accountPassword,accountIsStop,accountRole);
                aList.add(account);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                set.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            db.closeConnection(conn);
        }
        return aList;
    }

    public static void main(String[] args) {
        IAccountDAO dao = new AccountDAOImpl();
        List<Account> account = dao.queryAll(0,4);
        for (Account account1 : account) {
            System.out.println(account1);
        }
    }
}
