package com.transwarp.unicom.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseDao {

	protected static final String DBURL= "jdbc:hive2://192.168.20.102:10000/unicomtest";
	protected static final String DRIVERNAME = "org.apache.hive.jdbc.HiveDriver";
	
	protected Connection con = null;
	protected PreparedStatement ps = null;
	protected ResultSet rs = null;
	
	static{
		try{
			Class.forName(DRIVERNAME);
		}catch(Exception e){
			System.out.println("DataBaseDAO()"+e.getMessage());
		}
	}
	
	public ResultSet query(String sql){
		try{
			ps = connection().prepareStatement(sql);
			rs = ps.executeQuery(sql);
		}catch(Exception e){
		    close();
			System.out.println("DataBaseDAO query():"+e.getMessage());
		}
		return rs;
	}
	
	public Connection connection() {
		try {
			if(null == con){
				con = DriverManager.getConnection(DBURL);
			}
		} catch (SQLException e) {
			System.out.println("DataBaseDAO Connection():" + e.getMessage());
		}
		return con;
	}
	
	//关闭数据库连接
	public void close(){
		try{
			if(null !=rs){
				rs.close();
				rs = null;
			}
			if(null != ps){
				ps.close();
				ps = null;
			}
			if(null !=con){
				con.close();
				con = null;
			}
		}catch(SQLException e){
			System.out.println("DataBaseDAO:"+e.getMessage());
		}
	}
}
