package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.util.Dbutil;

import Test.Comment;

public class CommentDao {
	Dbutil dbtuil=new Dbutil();
	public ResultSet CommentList(Connection con) throws Exception{
		String sql="select * from  ����";
		PreparedStatement pstmt=con.prepareStatement(sql);
		return pstmt.executeQuery();
	}
	public void addComment(String str) {
		Connection con = null;
		try {
			int count =0;
			con=dbtuil.getCon();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM ����");
			while(rs.next()) {
				count++;
			}
            Comment cm=new Comment(count++,str);
            String sql="insert into ���� values(?,?)";
           PreparedStatement pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, count++);
			pstmt.setString(2, str);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		CommentDao A=new CommentDao();
		A.addComment("������Խ���ô��");
	}
}
