package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.DbConnection;
import com.entity.Appointment;
import com.entity.User;

public class AppointmentDao {

	Connection con;

	public AppointmentDao() {
		con = DbConnection.getConnection();
	}

	public int addAppointment(Appointment ap) {
		int i = 0;

		String sql = "insert into appointment values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, 0);
			ps.setInt(2, ap.getUserId());
			ps.setString(3, ap.getName());
			ps.setString(4, ap.getGender());
			ps.setString(5, ap.getAge());
			ps.setString(6, ap.getAppoinDate());
			ps.setString(7, ap.getEmail());
			ps.setString(8, ap.getPhNo());
			ps.setString(9, ap.getDiseases());
			ps.setInt(10, ap.getDoctorId());
			ps.setString(11, ap.getAddress());
			ps.setString(12, ap.getStatus());
			i = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;

	}

	public ArrayList<Appointment> getAllAppointment(int id) {
		ArrayList<Appointment> list = new ArrayList<Appointment>();
		Appointment ap = null;
		try {
			PreparedStatement ps = con.prepareStatement("select *from appointment where userid=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ap = new Appointment();
				ap.setId(rs.getInt(1));
				ap.setUserId(rs.getInt(2));
				ap.setName(rs.getString(3));
				ap.setGender(rs.getString(4));
				ap.setAge(rs.getString(5));
				ap.setAppoinDate(rs.getString(6));
				ap.setEmail(rs.getString(7));
				ap.setPhNo(rs.getString(8));
				ap.setDiseases(rs.getString(9));
				ap.setDoctorId(rs.getInt(10));
				ap.setAddress(rs.getString(11));
				ap.setStatus(rs.getString(12));
				list.add(ap);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

	public ArrayList<Appointment> getAppointmentDr(int drid) {
		ArrayList<Appointment> list = new ArrayList<Appointment>();
		Appointment ap = null;
		try {
			PreparedStatement ps = con.prepareStatement("select *from appointment where doc_id=?");
			ps.setInt(1, drid);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ap = new Appointment();
				ap.setId(rs.getInt(1));
				ap.setUserId(rs.getInt(2));
				ap.setName(rs.getString(3));
				ap.setGender(rs.getString(4));
				ap.setAge(rs.getString(5));
				ap.setAppoinDate(rs.getString(6));
				ap.setEmail(rs.getString(7));
				ap.setPhNo(rs.getString(8));
				ap.setDiseases(rs.getString(9));
				ap.setDoctorId(rs.getInt(10));
				ap.setAddress(rs.getString(11));
				ap.setStatus(rs.getString(12));
				list.add(ap);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

	public Appointment getAppointmentById(int id) {

		Appointment ap = null;
		try {
			PreparedStatement ps = con.prepareStatement("select *from appointment where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ap = new Appointment();
				ap.setId(rs.getInt(1));
				ap.setUserId(rs.getInt(2));
				ap.setName(rs.getString(3));
				ap.setGender(rs.getString(4));
				ap.setAge(rs.getString(5));
				ap.setAppoinDate(rs.getString(6));
				ap.setEmail(rs.getString(7));
				ap.setPhNo(rs.getString(8));
				ap.setDiseases(rs.getString(9));
				ap.setDoctorId(rs.getInt(10));
				ap.setAddress(rs.getString(11));
				ap.setStatus(rs.getString(12));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ap;

	}

	public int updateCommentStatus(int id, int drid, String comm) {
		int i = 0;
		String sql = "update appointment set status=? where id=? and doc_id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, comm);
			ps.setInt(2, id);
			ps.setInt(3, drid);
			i = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return i;
	}

	public ArrayList<Appointment> getAllAppointment() {
		ArrayList<Appointment> list = new ArrayList<Appointment>();
		Appointment ap = null;
		try {
			PreparedStatement ps = con.prepareStatement("select *from appointment");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ap = new Appointment();
				ap.setId(rs.getInt(1));
				ap.setUserId(rs.getInt(2));
				ap.setName(rs.getString(3));
				ap.setGender(rs.getString(4));
				ap.setAge(rs.getString(5));
				ap.setAppoinDate(rs.getString(6));
				ap.setEmail(rs.getString(7));
				ap.setPhNo(rs.getString(8));
				ap.setDiseases(rs.getString(9));
				ap.setDoctorId(rs.getInt(10));
				ap.setAddress(rs.getString(11));
				ap.setStatus(rs.getString(12));
				list.add(ap);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}
	
	
}
