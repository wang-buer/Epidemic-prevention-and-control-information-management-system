package com.daoImpl;

import com.dao.IMemberDAO;
import com.pojo.Community;
import com.pojo.Member;
import com.util.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAOImpl implements IMemberDAO {

    private DBUtils db = new DBUtils();

    @Override
    public List<Member> queryAll(int startIndex, int pageSize) {
        List<Member> mList = new ArrayList<Member>();
        Connection conn = db.openConnection();
        String sql = "SELECT member.*,community.cName FROM member,community " +
                "WHERE community.cId = member.mcId limit ?,?";
        ResultSet set = db.query(conn,sql,startIndex,pageSize);
        try {
            while (set.next()){
                int mId = set.getInt("mId");
                String mName = set.getString("mName");
                String mTel = set.getString("mTel");
                String mSex = set.getString("mSex");
                int mAge = set.getInt("mAge");
                String mHouseNum = set.getString("mHouseNum");
                String mWorkUnit = set.getString("mWorkUnit");
                String mCarNum = set.getString("mCarNum");
                String mIsHousehold = set.getString("mIsHousehold");
                int mcId = set.getInt("mcId");
                String cName = set.getString("cName");
                Member member = new Member(mId,mName,mTel,mSex,mAge,mHouseNum,mWorkUnit,
                        mCarNum,mIsHousehold,mcId,cName);
                mList.add(member);
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
        return mList;
    }

    @Override
    public int getCount() {
        int count = 0;
        Connection conn = db.openConnection();
        String sql = "select count(*) from member";
        ResultSet set = db.query(conn, sql);
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

    @Override
    public List<Member> queryAllM() {
        List<Member> mList = new ArrayList<Member>();
        Connection conn = db.openConnection();
        String sql = "select * from member";
        ResultSet set = db.query(conn,sql);
        try {
            while (set.next()){
                int mId = set.getInt("mId");
                String mName = set.getString("mName");
                String mTel = set.getString("mTel");
                String mSex = set.getString("mSex");
                int mAge = set.getInt("mAge");
                String mHouseNum = set.getString("mHouseNum");
                String mWorkUnit = set.getString("mWorkUnit");
                String mCarNum = set.getString("mCarNum");
                String mIsHousehold = set.getString("mIsHousehold");
                int mcId = set.getInt("mcId");
                Member member = new Member(mId,mName,mTel,mSex,mAge,mHouseNum,mWorkUnit,
                        mCarNum,mIsHousehold,mcId);
                mList.add(member);
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
        return mList;
    }

    //添加
    @Override
    public int add(Member member) {
        Connection conn = db.openConnection();
        String sql = "insert into member(mId,mName,mTel,mSex,mAge,mHouseNum,mWorkUnit,mCarNum,mIsHousehold,mcId) values(NULL,?,?,?,?,?,?,?,?,?)";
        int count = db.update(conn,sql,member.getmName(),member.getmTel(),member.getmSex(),
                member.getmAge(),member.getmHouseNum(),member.getmWorkUnit(),
                member.getmCarNum(),member.getmIsHousehold(),member.getMcId());
        db.closeConnection(conn);
        return count;
    }

    @Override
    public int delete(int mId) {
        Connection conn = db.openConnection();
        String sql = "delete from member where mId = ?";
        int count = db.update(conn,sql,mId);
        db.closeConnection(conn);
        return count;
    }

    @Override
    public int update(Member member) {
        Connection conn = db.openConnection();
        String sql = "update member set mName = ? , mTel = ? , mSex = ? , mAge = ? , mHouseNum = ? ," +
                " mWorkUnit = ? , mCarNum = ? , mIsHousehold = ? , mcId = ? where mId = ?";
        int count = db.update(conn,sql,member.getmName(),member.getmTel(),member.getmSex(),member.getmAge(),
                member.getmHouseNum(),member.getmWorkUnit(),member.getmCarNum(),member.getmIsHousehold(),member.getMcId(),
                member.getmId());
        return count;
    }

    @Override
    public Member queryByKey(int mId) {
        Connection conn = db.openConnection();
        String sql = "select member.*,community.cName from member,community where community.cId = member.mcId and mId = ?";
        ResultSet set = db.query(conn,sql,mId);
        Member member = null;
        try {
            while (set.next()){
                int mID = set.getInt("mId");
                String mName = set.getString("mName");
                String mTel = set.getString("mTel");
                String mSex = set.getString("mSex");
                int mAge = set.getInt("mAge");
                String mHouseNum = set.getString("mHouseNum");
                String mWorkUnit = set.getString("mWorkUnit");
                String mCarNum = set.getString("mCarNum");
                String mIsHousehold = set.getString("mIsHousehold");
                int mcId = set.getInt("mcId");
                String cName = set.getString("cName");
                member = new Member(mID,mName,mTel,mSex,mAge,mHouseNum,mWorkUnit,
                        mCarNum,mIsHousehold,mcId,cName);
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
        return member;
    }

    @Override
    public int deletes(int... mIds) {
        Object[] params = new Object[mIds.length];
        Connection conn = db.openConnection();
        String sql = "delete from member where mId in(0";
        for (int i = 0; i < mIds.length; i++) {
            sql = sql + ",?";
            params[i] = mIds[i];
        }
        sql +=")";
        int counter = db.update(conn,sql,params);
        db.closeConnection(conn);
        return counter;
    }

    @Override
    public List<Member> queryByKeyWords(String mName) {
        List<Member> mList = new ArrayList<Member>();
        Connection conn = db.openConnection();
        String sql = "select member.*,community.cName from member,community where community.cId = member.mcId and member.mName like ?";
        ResultSet set = db.query(conn, sql, "%" + mName + "%");
        try {
            while (set.next()){
                int mId = set.getInt("mId");
                String mname = set.getString("mName");
                String mTel = set.getString("mTel");
                String mSex = set.getString("mSex");
                int mAge = set.getInt("mAge");
                String mHouseNum = set.getString("mHouseNum");
                String mWorkUnit = set.getString("mWorkUnit");
                String mCarNum = set.getString("mCarNum");
                String mIsHousehold = set.getString("mIsHousehold");
                int mcId = set.getInt("mcId");
                String cName = set.getString("cName");
                Member member = new Member(mId,mname,mTel,mSex,mAge,mHouseNum,mWorkUnit,
                        mCarNum,mIsHousehold,mcId,cName);
                mList.add(member);
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
        return mList;
    }

    public static void main(String[] args) {
        IMemberDAO dao = new MemberDAOImpl();
        List<Member> member = dao.queryAllM();
        for (Member member1 : member) {
            System.out.println(member1);
        }
    }
}
