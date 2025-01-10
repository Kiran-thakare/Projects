package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.DbConnection;
import com.entity.Doctor;
import com.entity.Specalist;

public class DoctorDao {

	Connection con;

	public DoctorDao() {
		con = DbConnection.getConnection();

	}

	public int addDoctor(Doctor d) {
		int i = 0;

		String sql = "insert into doctor(dname,dob,email,qualification,specialist,mob,pass)values(?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, d.getName());
			ps.setString(2, d.getDob());
			ps.setString(3, d.getEmail());
			ps.setString(4, d.getQualification());
			ps.setString(5, d.getSpecialist());
			ps.setString(6, d.getMobNo());
			ps.setString(7, d.getPass());

			i = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return i;

	}

	public List<Doctor> getAllDoctor() {
		List<Doctor> list = new ArrayList<Doctor>();

		try {
			PreparedStatement ps = con.prepareStatement("select * from doctor ");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Doctor d = new Doctor();

				d.setId(rs.getInt(1));
				d.setName(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setEmail(rs.getString(4));
				d.setQualification(rs.getString(5));
				d.setSpecialist(rs.getString(6));
				d.setMobNo(rs.getString(7));
				d.setPass(rs.getString(8));
				list.add(d);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	public Doctor getDoctorById(int id) {
		Doctor d = null;
		try {
			PreparedStatement ps = con.prepareStatement("select * from doctor where id=? ");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				d = new Doctor();

				d.setId(rs.getInt(1));
				d.setName(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setEmail(rs.getString(4));
				d.setQualification(rs.getString(5));
				d.setSpecialist(rs.getString(6));
				d.setMobNo(rs.getString(7));
				d.setPass(rs.getString(8));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;

	}

	public int updateDoctor(Doctor d) {
		int i = 0;

		String sql = "update doctor set dname=?,dob=?,email=?,qualification=?,specialist=?,mob=?,pass=? where id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, d.getName());
			ps.setString(2, d.getDob());
			ps.setString(3, d.getEmail());
			ps.setString(4, d.getQualification());
			ps.setString(5, d.getSpecialist());
			ps.setString(6, d.getMobNo());
			ps.setString(7, d.getPass());
			ps.setInt(8, d.getId());

			i = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return i;

	}

	public int deleteDoctor(int id) {
		int i = 0;

		try {
			PreparedStatement ps = con.prepareStatement("delete from doctor where id=?");
			ps.setInt(1, id);
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;

	}

	public Doctor login(String email, String pass) {
		Doctor d = null;

		String sql = "select * from doctor where email=? and pass=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, pass);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				d = new Doctor();
				d.setId(rs.getInt(1));
				d.setName(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setEmail(rs.getString(4));
				d.setQualification(rs.getString(5));
				d.setSpecialist(rs.getString(6));
				d.setMobNo(rs.getString(7));
				d.setPass(rs.getString(8));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return d;

	}

	public int countDoctor() {
		int i = 0;

		String sql = "select * from doctor";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				i++;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;

	}

	public int countUser() {
		int i = 0;

		String sql = "select * from userdtl";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				i++;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;

	}

	public int countSpecialist() {
		int i = 0;

		String sql = "select * from specialist";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				i++;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;

	}

	public int countAppointment() {
		int i = 0;

		String sql = "select * from appointment";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				i++;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;

	}

	public int countAppointmentByDrId(int did) {

		System.out.println(did);
		int i = 0;

		String sql = "select * from appointment where doc_id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, did);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				i++;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;

	}

	public boolean checkOldPassword(int userid, String oldPassword) {
		boolean f = false;

		try {
			String sql = "select * from doctor  where pass=? and id=?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, oldPassword);
			ps.setInt(2, userid);

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
			String sql = "update doctor set pass=? where id=?";
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

	public int editDoctorprofile(Doctor d) {
		int i = 0;

		String sql = "update doctor set dname=?,dob=?,email=?,qualification=?,specialist=?,mob=? where id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, d.getName());
			ps.setString(2, d.getDob());
			ps.setString(3, d.getEmail());
			ps.setString(4, d.getQualification());
			ps.setString(5, d.getSpecialist());
			ps.setString(6, d.getMobNo());

			ps.setInt(7, d.getId());

			i = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return i;

	}

}
