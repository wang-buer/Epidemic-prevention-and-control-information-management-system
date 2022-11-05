package com.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Objects;
import java.util.Properties;

public class DBUtils {
    public static String URL;//数据库连接信息
    public static String USERNAME;//用户名
    public static String PASSWORD;//密码
    public static String DRIVER;//mysql驱动连接

    //静态块
    static {
        InputStream in = DBUtils.class.getResourceAsStream("/db.properties");
        //读取配置文件信息
        Properties pro = new Properties();
        try {
            pro.load(in);
            //根据键得到值
            DRIVER = pro.getProperty("jdbc.driver");
            URL = pro.getProperty("jdbc.url");
            USERNAME = pro.getProperty("jdbc.username");
            PASSWORD = pro.getProperty("jdbc.password");
            //输出配置信息
            System.out.println(DRIVER+"........"+URL+"........"+USERNAME+"........"+PASSWORD+"........");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭流
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //打开连接
    public Connection openConnection(){
        //1.加载驱动
        try {
            Class.forName(DRIVER);
            //2.得到连接
            Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //关闭
    public void closeConnection(Connection conn) {
        try {
            if (conn !=null && conn.isClosed() == false) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //新增修改删除方法
    public int update(Connection conn, String sql, Object...objects){
        PreparedStatement statement;
        int count = 0;
        try {
            statement = conn.prepareStatement(sql);
            //循环
            for (int index = 1; index < objects.length+1; index++) {
                //一个个赋值
                statement.setObject(index,objects[index-1]);
            }
            //执行新增修改语法
            count = statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
    //查询
    public ResultSet query(Connection conn,String sql,Object...objects){
        PreparedStatement statement;
        try {
            statement = conn.prepareStatement(sql);
            //循环
            for (int i = 1; i < objects.length+1; i++) {
                statement.setObject(i,objects[i-1]);
            }
            //执行查询语句
            return statement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //测试
    public static void main(String[] args) throws SQLException {
        DBUtils db = new DBUtils();
        Connection conn = db.openConnection();
        //测试开启了没有
        System.out.println(conn.isClosed()+"开启");
        //测试关闭
        db.closeConnection(conn);
        System.out.println(conn.isClosed()+"关闭");
    }

}
