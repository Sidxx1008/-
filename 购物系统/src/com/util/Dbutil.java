package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbutil {
	private String  dbUrl="jdbc:mysql://localhost:3306/db_shop?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	private String dbUserName="root";
	private String dbPassword="12345678";
	private String jdbcName="com.mysql.jdbc.Driver";
	

	public Connection getCon()throws Exception{
		Class.forName(jdbcName);
		Connection Con=DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		return Con;
		
	}
	public void closeCon(Connection con)throws Exception{
		if(con!=null){
			con.close();
		}
	}
	public static void main(String[] args) {
		Dbutil dbUtil=new Dbutil(); 
		try {
			dbUtil.getCon();
			System.out.println("数据库连接成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
