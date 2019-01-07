package com.vincentserver.main;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.vincentserver.bean.User;

public class UserDaoImp {

	public static Connection getConnection(){  
	    Connection con=null;  
	    try{  
	        Class.forName("com.mysql.jdbc.Driver");  
	        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","","");  
	    }catch(Exception e){System.out.println(e);}  
	    return con;  
	}  
	public static int save(User t) {
		int status=0;
		try {
			Connection con = getConnection();
			String statement = "insert into db(id,name,password,data) values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(statement);
			ps.setInt(1, t.getId());
			ps.setString(2, t.getName());
			ps.setString(3, t.getPassword());
			ps.setString(4, t.getData());
			status = ps.executeUpdate();
		}catch(Exception e) {System.out.println(e);}
		return status;
	}

	public static int update(User t) {
		int status=0;
		try {
			Connection con = getConnection();
			String statement = "update db set name = ?, password = ?, data = ? where id = ?";
			PreparedStatement ps = con.prepareStatement(statement);
			ps.setString(1, t.getName());
			ps.setString(2, t.getPassword());
			ps.setString(3, t.getData());
			ps.setInt(4, t.getId());
			status = ps.executeUpdate();
		}catch(Exception e) {System.out.println(e);}
		return status;
	}

	public static int delete(User t) {
		int status=0;
		try {
			Connection con = getConnection();
			String statement = "delete from db where id = ?";
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
			String statement = "select * from db where id = ?";
			PreparedStatement ps = con.prepareStatement(statement);
			ps.setInt(1, id);
			result = ps.executeQuery();
			u = new User();
			u.setId(id);
			u.setName(result.getString("name"));
			u.setPassword(result.getString("password"));
			u.setData(result.getString("data"));
		}catch(Exception e) {System.out.println(e);}
		return u;
	}

	public static List<User> findAllRecord() {
		ResultSet result = null;
		List<User> list = new ArrayList<User>();
		try {
			Connection con = getConnection();
			String statement = "select * from db";
			PreparedStatement ps = con.prepareStatement(statement);
			result = ps.executeQuery();
			while(result.next())
			{
				User u = new User();
				u.setId(result.getInt("id"));
				u.setName(result.getString("name"));
				u.setPassword(result.getString("password"));
				u.setData(result.getString("data"));
				list.add(u);
			}
		}catch(Exception e) {System.out.println(e);}
		return list;
	}

}
