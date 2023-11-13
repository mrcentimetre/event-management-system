package com.customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CustomerDBUtil {
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	
	public static List<customize> validate(String userName, String password){
		
		ArrayList<customize> cus = new ArrayList<>();
		
		
		try {
				
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from customize where username='"+userName+"' and password='"+password+"'";
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				int eventid = rs.getInt(1);
				String name = rs.getString(2);
				String type = rs.getString(3);
				String description = rs.getString(4);
				String date = rs.getString(5);
				String time = rs.getString(6);
				String location = rs.getString(7);
				String planner = rs.getString(8);
				String userU = rs.getString(9);
				String passU = rs.getString(10);
				
				customize c = new customize(eventid, name, type, description, date, time, location, planner, userU, passU);
				cus.add(c);
			}

			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return cus;
	}

	public static boolean insertevent(String name, String type, String description, String date, String time, String location, String planner, String username, String password) {
		
		boolean isSuccess = false;
		
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "insert into customize values (0, '"+name+"', '"+type+"', '"+description+"', '"+date+"', '"+time+"', '"+location+"', '"+planner+"', '"+username+"', '"+password+"')";
			int rs = stmt.executeUpdate(sql);
			
			if (rs > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
		
	}
	
	public static boolean updateEvent (String eventid, String name, String type, String date, String time, String location, String planner) {
		
				
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "update customize set name='"+name+"', type='"+type+"', date='"+date+"', time='"+time+"', location='"+location+"', planner='"+planner+"'"
					+"where eventid='"+eventid+"'";
			int rs = stmt.executeUpdate(sql);
			
			if (rs > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	public static boolean deleteEvent (String eventid) {
		
		int convID = Integer.parseInt(eventid);
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "delete from customize where eventid='"+convID+"'";
			int r = stmt.executeUpdate(sql);
			
			if (r > 0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return isSuccess;
	}

	public static List<customize> getCustomerDetails(String id) {
		
		int convertedID = Integer.parseInt(id);
		
		ArrayList<customize> cus = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from customize where eventid='"+convertedID+"'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int eventid = rs.getInt(1);
				String name = rs.getString(2);
				String type = rs.getString(3);
				String description = rs.getString(4);
				String date = rs.getString(5);
				String time = rs.getString(6);
				String location = rs.getString(7);
				String planner = rs.getString(8);
				String userU = rs.getString(9);
				String passU = rs.getString(10);
			
				customize c = new customize(eventid, name, type, description, date, time, location, planner, userU, passU);
				cus.add(c);
				
			}
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return cus;
	}
}
