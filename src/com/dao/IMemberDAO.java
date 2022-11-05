package com.dao;

import java.util.List;

import com.pojo.Member;

public interface IMemberDAO {

    //分页
    public List<Member> queryAll(int startIndex,int pageSize);
    //计算总数
    public int getCount();
    //查询所有
    public List<Member> queryAllM();
    //添加
    public int add(Member member);
    //删除
    public int delete(int mId);
    //修改
    public int update(Member member);
    //编辑
    public Member queryByKey(int mId);
    //批量删除
    public int deletes(int...mIds);
    //模糊查询
    public List<Member> queryByKeyWords(String mName);
}
