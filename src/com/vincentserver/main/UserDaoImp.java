package com.vincentserver.main;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.vincentserver.bean.User;

public class UserDaoImp {

	public static Connection getConnection(){  
	    Connection con=null;  
	    try{  
	        Class.forName("com.mysql.cj.jdbc.Driver");  
	        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","12345");  
	    }catch(Exception e){System.out.println(e);}  
	    return con;  
	}  
	public static int save(User t) {
		int status=0;
		try {
			Connection con = getConnection();
			String statement = "insert into userInfo(userID,userName,pass) values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(statement);
			ps.setInt(1, t.getId());
			ps.setString(2, t.getName());
			ps.setString(3, t.getPassword());
			status = ps.executeUpdate();
		}catch(Exception e) {System.out.println(e);}
		return status;
	}

	public static int update(User t) {
		int status=0;
		try {
			Connection con = getConnection();
			String statement = "update userInfo set userName = ?, pass = ?, where userID = ?";
			PreparedStatement ps = con.prepareStatement(statement);
			ps.setString(1, t.getName());
			ps.setString(2, t.getPassword());
			ps.setInt(4, t.getId());
			status = ps.executeUpdate();
		}catch(Exception e) {System.out.println(e);}
		return status;
	}

	public static int delete(User t) {
		int status=0;
		try {
			Connection con = getConnection();
			String statement = "delete from userInfo where userID = ?";
			PreparedStatement ps = con.prepareStatement(statement);
			ps.setInt(1, t.getId());
			status = ps.executeUpdate();
		}catch(Exception e) {System.out.println(e);}
		return status;
	}

	public static User findByID(int id) {
		ResultSet result = null;
		User u = null;
		try {
			Connection con = getConnection();
			String statement = "select * from userInfo where userID = ?";
			PreparedStatement ps = con.prepareStatement(statement);
			ps.setInt(1, id);
			result = ps.executeQuery();
			if(result.next())
			{
				u = new User();
				u.setId(id);
				u.setName(result.getString("userName"));
				u.setPassword(result.getString("pass"));
			}
		}catch(Exception e) {System.out.println(e);}
		return u;
	}

	public static int findByNameAndPassword(String name, String password) {
		ResultSet result = null;
		int resultID = 0;
		try {
			Connection con = getConnection();
			String statement = "select * from userInfo where userName = ? and pass = ?";
			PreparedStatement ps = con.prepareStatement(statement);
			ps.setString(1, name);
			ps.setString(2, password);
			result = ps.executeQuery();
			if(result.next())
			{
				resultID = result.getInt("userID");
			}
		}catch(Exception e) {System.out.println(e);}
		return resultID;
	}
	
	public static List<User> findAllRecord() {
		ResultSet result = null;
		List<User> list = new ArrayList<User>();
		try {
			Connection con = getConnection();
			String statement = "select * from userInfo";
			PreparedStatement ps = con.prepareStatement(statement);
			result = ps.executeQuery();
			while(result.next())
			{
				User u = new User();
				u.setId(result.getInt("userID"));
				u.setName(result.getString("userName"));
				u.setPassword(result.getString("pass"));
				list.add(u);
			}
		}catch(Exception e) {System.out.println(e);}
		return list;
	}

}
