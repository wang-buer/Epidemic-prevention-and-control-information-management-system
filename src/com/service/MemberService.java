package com.service;

import com.dao.IMemberDAO;
import com.daoImpl.MemberDAOImpl;
import com.pojo.Member;
import com.pojo.Record;
import com.util.PageUtil;

import java.util.List;

public class MemberService {

    private IMemberDAO dao = new MemberDAOImpl();

    public List<Member> queryAll(PageUtil pageUtil){
        return dao.queryAll(pageUtil.getStartIndex(),pageUtil.getPageSize());
    }

    public int getCount(){
        return dao.getCount();
    }

    public List<Member> queryAllM(){
        return dao.queryAllM();
    }

    public boolean add(Member member){
        return dao.add(member) > 0;
    }

    public boolean delete(int mId){
        return dao.delete(mId) > 0;
    }

    public boolean update(Member member){
        return dao.update(member) > 0;
    }

    public Member edit(int mId){
        return dao.queryByKey(mId);
    }

    public boolean deletes(int...mIds){
        return new MemberDAOImpl().deletes(mIds) > 0;
    }

    public List<Member> queryByKeyWords(String mName){
        return dao.queryByKeyWords(mName);
    }
}
