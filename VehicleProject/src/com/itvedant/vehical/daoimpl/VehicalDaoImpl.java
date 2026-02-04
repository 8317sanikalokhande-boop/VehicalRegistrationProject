package com.itvedant.vehical.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.itvedant.vehical.dao.VehicalDao;
import com.itvedant.vehical.model.Vehical;


	
public class VehicalDaoImpl implements VehicalDao{
	
	
	@Override
	public boolean addVehicle(Vehical v)  {
	Connection con =null;
	PreparedStatement ps =null;
	
		
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		//System.out.println("Connection successfully");
		
		String url= "jdbc:mysql://localhost:3306/vehical_db";
		String user = "root";
		String password="root";
		 con= DriverManager.getConnection(url,user,password);
		ps= con.prepareStatement("insert into vehical(ownerName, vehicleNumber, vehicleType, registrationDate) VALUES (?, ?, ?, ?)");
		
		ps.setString(1, v.ownerName);
		ps.setString(2,v.vehicleNumber);
		ps.setString(3, v.vehicleType);
		ps.setDate(4, v.registrationDate == null ? null : Date.valueOf(v.registrationDate));
		
		int count = ps.executeUpdate();
		if(count ==1) {
			return true;
		}
		else {
			return false;
		}
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		try {
			con.close();
		}
		catch(SQLException e1) {
			e1.printStackTrace();
			
		}
	}
		
		return false;
	}

	@Override
	public boolean updateVehicle(Vehical v) {
		// TODO Auto-generated method stub
		Connection con =null;
		PreparedStatement ps =null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			String url= "jdbc:mysql://localhost:3306/vehical_db";
			String user = "root";
			String password="root";
			 con= DriverManager.getConnection(url,user,password);
			ps= con.prepareStatement("update vehical set ownerName=?, vehicleNumber=?,vehicleType=?,registrationDate=? where id=? ");
			
			ps.setString(1, v.ownerName);
			ps.setString(2,v.vehicleNumber);
			ps.setString(3, v.vehicleType);
			ps.setDate(4, v.registrationDate == null ? null : Date.valueOf(v.registrationDate));
			ps.setInt(5, v.id);
			int count = ps.executeUpdate();
			if(count ==1) {
				return true;
			}
			else {
				return false;
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			}
			catch(SQLException e1) {
				e1.printStackTrace();
				
			}
		}
			
		
		return false;
	}

	@Override
	public boolean deleteVehicle(int id) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/vehical_db";
			String user="root";
			String password="root";
			
			con=DriverManager.getConnection(url,user,password);
			ps= con.prepareStatement("delete from vehical where id=?");
			
			ps.setInt(1, id);
			int count = ps.executeUpdate();
			if(count ==1) {
				return true;
			}
			else {
				return false;
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Vehical> getAllVehicle() {
		// TODO Auto-generated method stub
		Connection con =null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Vehical> list = new ArrayList<>();
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url= "jdbc:mysql://localhost:3306/vehical_db";
			String user ="root";
			String password="root";
			
			con=DriverManager.getConnection(url,user,password);
			ps=con.prepareStatement("Select * from vehical order by id");
			rs=ps.executeQuery();
			
			while (rs.next()) {
                int id = rs.getInt("id");
                String owner = rs.getString("ownerName");
                String number = rs.getString("vehicleNumber");
                String type = rs.getString("vehicleType");
                Date date = rs.getDate("registrationDate");
                LocalDate regDate = (date == null) ? null : date.toLocalDate();
                
                Vehical v = new Vehical(id, owner, number, type, regDate);
                list.add(v);
                
			}			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	
	@Override
	public Vehical getVehicleById(int id) {
		// TODO Auto-generated method stub
		Connection con =null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Vehical v= null;
		
		

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url= "jdbc:mysql://localhost:3306/vehical_db";
			String user ="root";
			String password="root";
			
			con=DriverManager.getConnection(url,user,password);
			ps=con.prepareStatement("Select * from vehical where id=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				 String owner = rs.getString("ownerName");
		            String number = rs.getString("vehicleNumber");
		            String type = rs.getString("vehicleType");
		            Date date = rs.getDate("registrationDate");
		            java.time.LocalDate regDate = (date == null) ? null : date.toLocalDate();
		            
		            v = new Vehical(id,owner,number,type,regDate);
		            	
			}
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return v;
	}

	@Override
	public Vehical getVehicleByNumber(String vehicleNumber) {
		// TODO Auto-generated method stub
		
		Connection con =null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		Vehical v =null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url= "jdbc:mysql://localhost:3306/vehical_db";
			String user ="root";
			String password="root";
			
			con=DriverManager.getConnection(url,user,password);
			
	        ps = con.prepareStatement("SELECT * FROM vehical WHERE vehicleNumber = ?");
	        ps.setString(1, vehicleNumber);

	        rs = ps.executeQuery();

	        if (rs.next()) {
	            int id = rs.getInt("id");
	            String owner = rs.getString("ownerName");
	            String number = rs.getString("vehicleNumber");
	            String type = rs.getString("vehicleType");
	            Date date = rs.getDate("registrationDate");
	            LocalDate regDate = (date == null) ? null : date.toLocalDate();

	            v = new Vehical(id, owner, number, type, regDate);
	        }
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return v;
	}
	
}

	
