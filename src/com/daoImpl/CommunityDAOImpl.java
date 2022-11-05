package com.daoImpl;

import com.dao.ICommunityDAO;
import com.pojo.Community;
import com.util.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommunityDAOImpl implements ICommunityDAO {

    private DBUtils db = new DBUtils();

    //分页
    @Override
    public List<Community> queryAll(int startIndex, int pageSize) {
        List<Community> list = new ArrayList<Community>();
        Connection conn = db.openConnection();
        String sql = "select * from community limit ?,?";
        ResultSet set = db.query(conn, sql, startIndex, pageSize);
        try {
            while (set.next()){
                int cId = set.getInt("cId");
                String cName = set.getString("cName");
                String province = set.getString("province");
                String city = set.getString("city");
                String street = set.getString("street");
                String cTel = set.getString("cTel");
                Community community = new Community(cId,cName,province,city,street,cTel);
                list.add(community);
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
        return list;
    }

    //查询总笔数
    @Override
    public int getCount() {
        int count = 0;
        Connection conn = db.openConnection();
        String sql ="select count(*) from community";
        ResultSet set = db.query(conn, sql);
        try {
            if (set.next()) {
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

    @Override
    public List<Community> queryAllC() {
        List<Community> list = new ArrayList<Community>();
        Connection conn = db.openConnection();
        String sql = "select * from community ";
        ResultSet set = db.query(conn, sql);
        try {
            while (set.next()){
                int cId = set.getInt("cId");
                String cName = set.getString("cName");
                String province = set.getString("province");
                String city = set.getString("city");
                String street = set.getString("street");
                String cTel = set.getString("cTel");
                Community community = new Community(cId,cName,province,city,street,cTel);
                list.add(community);
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
        return list;
    }

    //添加
    @Override
    public int add(Community community) {
        Connection conn = db.openConnection();
        String sql = "insert into community(cId,cName,province,city,street,cTel) values(NULL,?,?,?,?,?)";
        int count = db.update(conn,sql,community.getcName(),community.getProvince(),community.getCity(),
        community.getStreet(),community.getcTel());
        db.closeConnection(conn);
        return count;
    }

    @Override
    public int delete(int cId) {
        Connection conn = db.openConnection();
        String sql ="delete from community where cId = ?";
        int count = db.update(conn,sql,cId);
        db.closeConnection(conn);
        return count;
    }

    @Override
    public Community queryByKey(int cId) {
        Connection conn = db.openConnection();
        String sql = "select * from community where cId = ?";
        ResultSet set = db.query(conn,sql,cId);
        Community community = null;
        try {
            while (set.next()){
                int cID = set.getInt("cId");
                String cName = set.getString("cName");
                String province = set.getString("province");
                String city = set.getString("city");
                String street = set.getString("street");
                String cTel = set.getString("cTel");
                community = new Community(cID,cName,province,city,street,cTel);
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
        return community;
    }

    @Override
    public int update(Community community) {
        Connection conn = db.openConnection();
        String sql = "update community set cName = ? , province = ? , city = ? ," +
                "street = ? , cTel = ? where cId = ?";
        int count = db.update(conn,sql,community.getcName(),community.getProvince(),community.getCity(),
                community.getStreet(),community.getcTel(),community.getcId());
        db.closeConnection(conn);
        return count;
    }

    //批量删除
    @Override
    public int deletes(int... cIds) {
        Object[] params = new Object[cIds.length];
        Connection conn = db.openConnection();
        String sql = "delete from community where cId in(0";
        for (int i = 0; i < cIds.length; i++) {
            sql = sql + ",?";
            params[i] = cIds[i];
        }
        sql +=")";
        int counter = db.update(conn,sql,params);
        db.closeConnection(conn);
        return counter;
    }

    //模糊查询
    @Override
    public List<Community> queryByKeyWords(String cName) {
        List<Community> cLists = new ArrayList<Community>();
        Connection conn = db.openConnection();
        String sql = "select * from community where cName like ?";
        ResultSet set = db.query(conn,sql,"%"+cName+"%");
        try {
            while (set.next()){
                int cId = set.getInt("cId");
                String cname = set.getString("cName");
                String province = set.getString("province");
                String city = set.getString("city");
                String street = set.getString("street");
                String cTel = set.getString("cTel");
                Community community = new Community(cId,cname,province,city,street,cTel);
                cLists.add(community);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                set.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            db.closeConnection(conn);
        }
        return cLists;
    }
}
