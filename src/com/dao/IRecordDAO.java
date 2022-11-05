package com.dao;

import java.util.List;

import com.pojo.Record;

public interface IRecordDAO {

    //分页
    public List<Record> queryAll(int startIndex,int pageSize);
    //计算总数
    public int getCount();
    //添加
    public int add(Record record);
    //删除
    public int delete(int rId);
    //修改
    public int update(Record record);
    //编辑
    public Record queryByKey(int rId);
    //批量删除
    public int deletes(int...rIds);
    //模糊查询
    public List<Record> queryByWords(String mName);
}
