package com.dao;

import java.util.List;

import com.pojo.Community;

public interface ICommunityDAO {
    //分页查询所有
    public List<Community> queryAll(int startIndex,int pageSize);
    //查询总数
    public int getCount();
    //查询所有
    public List<Community> queryAllC();
    //添加
    public int add(Community community);
    //单删
    public int delete(int cId);
    //根据主键查询
    public Community queryByKey(int cId);
    //修改
    public int update(Community community);
    //批量删除
    public int deletes(int...cIds);
    //模糊查询
    public List<Community> queryByKeyWords(String cName);
}
