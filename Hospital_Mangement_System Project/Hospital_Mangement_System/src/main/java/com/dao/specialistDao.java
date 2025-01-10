package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.DbConnection;
import com.entity.Specalist;
import com.mysql.cj.protocol.Resultset;

public class specialistDao {
   
	Connection con;
	
	public specialistDao() {
		con=DbConnection.getConnection();
	}
	
	public boolean addSpecialist(String spec) {
		
		boolean f=false;
		
		String sql="insert into specialist(sname)values(?)";
		try {
			PreparedStatement ps=con .prepareStatement(sql);
			ps.setString(1, spec);
			
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
		
	}
	
	public List<Specalist> getAllSpecialist(){
		List<Specalist> list=new ArrayList<Specalist>();
		
		try {
			PreparedStatement ps=con.prepareStatement("select * from specialist");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				Specalist sp=new Specalist();
				sp.setId(rs.getInt(1));
				sp.setSpecialistName(rs.getString(2));
				list.add(sp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
		
	}
}
