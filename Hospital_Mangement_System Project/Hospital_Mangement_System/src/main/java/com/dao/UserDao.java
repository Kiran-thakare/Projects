package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.db.DbConnection;
import com.entity.User;
import com.mysql.cj.protocol.Resultset;

public class UserDao {

	private Connection con;

	public UserDao() {
		con = DbConnection.getConnection();
	}

	public boolean register(User u) {
		boolean f = false;

		String sql = "insert into userdtl(name,email,pass)values(?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPass());
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return f;

	}

//	public User login(User u) {
//		User ui = null;
//
//		try {
//			PreparedStatement ps = con.prepareStatement("select * from userdtl where email=? and pass=?");
//			ps.setString(1, u.getEmail());
//			ps.setString(2, u.getPass());
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				ui=new User();
//				ui.setId(rs.getInt(1));
//				ui.setName(rs.getString(2));
//				ui.setEmail(rs.getString(3));
//				ui.setPass(rs.getString(4));
//			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return ui;
//
//	}

	public User login(String email, String pass) {
		User u = null;

		try {
			PreparedStatement ps = con.prepareStatement("select * from userdtl where email=? and pass=?");
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u = new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPass(rs.getString(4));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;

	}

//	public int changePassword(String oldpass, String npass, int id) {
//		int i = 0;
//
//		 try {  
//		        // Check if the old password matches the provided id  
//		        PreparedStatement ps = con.prepareStatement("SELECT * FROM userdtl WHERE pass = ? AND id = ?");  
//		        ps.setString(1, oldpass); // Set the old password parameter  
//		        ps.setInt(2, id); // Set the user ID parameter  
//		        
//		        ResultSet rs = ps.executeQuery(); // Execute the select query  
//		        
//		        if (rs.next()) {  
//		            // Old password matched, now update with new password  
//		            PreparedStatement ps1 = con.prepareStatement("UPDATE userdtl SET pass = ? WHERE id = ?");  
//		            ps1.setString(1, npass); // Set the new password  
//		            ps1.setInt(2, id); // Set the user ID  
//		            
//		            i = ps1.executeUpdate(); // Execute the update query  
//		            
//		            // Optionally, you can add a check for whether the update was successful  
//		            if ( > 0) {  
//		                System.out.println("Password updated successfully.");  
//		            } else {  
//		                System.out.println("Password update failed.");  
//		            }  
//		            
//		            ps1.close(); // Close the update statement  
//		        } else {  
//		            System.out.println("Old password is incorrect or user ID does not exist.");  
//		        }  
//		        
//		        rs.close(); // Close the ResultSet  
//		        ps.close(); // Close the select statement  
//		        
//		    } catch (SQLException e) {  
//		        e.printStackTrace(); // Handle SQL exceptions  
//		    }
//
//		return i;
//
//	}

	public boolean checkOldPassword(int userid, String oldPassword) {
		boolean f = false;

		try {
			String sql = "select * from userdtl where id=? and pass=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userid);
			ps.setString(2, oldPassword);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public boolean changePassword(int userid, String newPassword) {
		boolean f = false;

		try {
			String sql = "update userdtl set pass=? where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, newPassword);
			ps.setInt(2, userid);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}
}
