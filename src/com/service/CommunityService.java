package com.service;

import com.dao.ICommunityDAO;
import com.daoImpl.CommunityDAOImpl;
import com.pojo.Community;
import com.util.PageUtil;

import java.util.List;

public class CommunityService {

    private ICommunityDAO dao = new CommunityDAOImpl();

    //分页
    public List<Community> queryAll(PageUtil pageUtil){
        return dao.queryAll(pageUtil.getStartIndex(),pageUtil.getPageSize());
    }
    //总笔数
    public int getCount(){
        return dao.getCount();
    }

    //查询所有
    public List<Community> queryAllC(){
        return dao.queryAllC();
    }

    //添加
    public boolean add(Community community){
        return dao.add(community) > 0;
    }

    //单删除
    public boolean delete(int cId){
        return dao.delete(cId) > 0;
    }

    //根据主键查询(编辑)
    public Community edit(int cId){
        return dao.queryByKey(cId);
    }

    //修改
    public boolean update(Community community){
        return dao.update(community) > 0;
    }

    //批量删除
    public boolean deletes(int...cIds){
        return new CommunityDAOImpl().deletes(cIds) > 0;
    }

    //模糊查询
    public List<Community> queryByKeyWords(String cName){
        return dao.queryByKeyWords(cName);
    }
}
