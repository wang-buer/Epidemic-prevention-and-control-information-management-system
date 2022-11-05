package com.daoImpl;

import com.dao.IRecordDAO;
import com.pojo.Record;
import com.util.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecordDAOImpl  implements IRecordDAO {

    private DBUtils db = new DBUtils();

    //分页
    @Override
    public List<Record> queryAll(int startIndex, int pageSize) {
        List<Record> rList = new ArrayList<Record>();
        Connection conn = db.openConnection();
        String sql = "SELECT record.*,community.cName,member.mName FROM record,community,member " +
                "WHERE community.cId = record.rcId and member.mId = record.rmId LIMIT ?,?";
        ResultSet set = db.query(conn,sql,startIndex,pageSize);
        try {
            while (set.next()){
                int rId = set.getInt("rId");
                int rmId = set.getInt("rmId");
                int rcId = set.getInt("rcId");
                String risOutCity = set.getString("risOutCity");
                String risFromHB = set.getString("risFromHB");
                String risHousehold = set.getString("risHousehold");
                String rNowTime = set.getString("rNowTime");
                String cName = set.getString("cName");
                String mName = set.getString("mName");
                Record record = new Record(rId,rmId,rcId,risOutCity,risFromHB,
                        risHousehold,rNowTime,cName,mName);
                rList.add(record);
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
        return rList;
    }

    //计算总数
    @Override
    public int getCount() {
        int count = 0;
        Connection conn = db.openConnection();
        String sql = "select count(*) from record";
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
    public int add(Record record) {
        Connection conn = db.openConnection();
        String sql = "insert into record(rId,rmId,rcId,risOutCity,risFromHB,risHousehold,rNowTime) values(NULL,?,?,?,?,?,?)";
        int count = db.update(conn,sql,record.getRmId(),record.getRcId(),
                record.getRisOutCity(),record.getRisFromHB(),record.getRisHousehold(),record.getrNowTime());
        db.closeConnection(conn);
        return count;
    }

    @Override
    public int delete(int rId) {
        Connection conn = db.openConnection();
        String sql = "delete from record where rId = ?";
        int count = db.update(conn,sql,rId);
        db.closeConnection(conn);
        return count;
    }

    @Override
    public int update(Record record) {
        Connection conn = db.openConnection();
        String sql = "update record set rmId = ? , rcId = ? , risOutCity = ? , risFromHB = ? , risHousehold = ? , rNowTime = ? where rId = ?";
        int count = db.update(conn,sql,record.getRmId(),record.getRcId(),record.getRisOutCity(),record.getRisFromHB(),record.getRisHousehold(),
                record.getrNowTime(),record.getrId());
        db.closeConnection(conn);
        return count;
    }

    @Override
    public Record queryByKey(int rId) {
        Connection conn = db.openConnection();
        String sql = "select record.*,community.cName,member.mName from record,community,member where community.cId = record.rcId and member.mId = record.rmId and rId = ?";
        ResultSet set = db.query(conn,sql,rId);
        Record record = null;
        try {
            while (set.next()){
                int rID = set.getInt("rId");
                int rmId = set.getInt("rmId");
                int rcId = set.getInt("rcId");
                String risOutCity = set.getString("risOutCity");
                String risFromHB = set.getString("risFromHB");
                String risHousehold = set.getString("risHousehold");
                String rNowTime = set.getString("rNowTime");
                String cName = set.getString("cName");
                String mName = set.getString("mName");
                record = new Record(rID,rmId,rcId,risOutCity,risFromHB,
                        risHousehold,rNowTime,cName,mName);
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
        return record;
    }

    @Override
    public int deletes(int... rIds) {
        Object[] params = new Object[rIds.length];
        Connection conn = db.openConnection();
        String sql = "delete from record where rId in(0";
        for (int i = 0; i < rIds.length; i++) {
            sql = sql + ",?";
            params[i] = rIds[i];
        }
        sql +=")";
        int counter = db.update(conn,sql,params);
        db.closeConnection(conn);
        return counter;
    }

    @Override
    public List<Record> queryByWords(String mName) {
        List<Record> rList = new ArrayList<Record>();
        Connection conn = db.openConnection();
        String sql = "SELECT record.*,community.cName,member.mName FROM record,community,member WHERE community.cId = record.rcId and member.mId = record.rmId and member.mName like ?";
        ResultSet set = db.query(conn,sql,"%"+mName+"%");
        try {
            while (set.next()){
                int rId = set.getInt("rId");
                int rmId = set.getInt("rmId");
                int rcId = set.getInt("rcId");
                String risOutCity = set.getString("risOutCity");
                String risFromHB = set.getString("risFromHB");
                String risHousehold = set.getString("risHousehold");
                String rNowTime = set.getString("rNowTime");
                String cName = set.getString("cName");
                String mname = set.getString("mName");
                Record record = new Record(rId,rmId,rcId,risOutCity,risFromHB,
                        risHousehold,rNowTime,cName,mname);
                rList.add(record);
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
        return rList;
    }

    public static void main(String[] args) {
        IRecordDAO dao = new RecordDAOImpl();
        List<Record> list = dao.queryAll(0,5);
        for (Record record : list) {
            System.out.println(record.toString());
        }
    }
}
