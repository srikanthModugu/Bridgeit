package com.bridgeit.springJdbcDemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

public class CustomerDaoImpl implements CustomerDao {

	private DataSource dataSource;
	
	
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void addCustomer(Customer coustomer) {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
		String query = "insert into srikanth.customer(id,name,age) values(?,?,?)";
		con = dataSource.getConnection();
		PreparedStatement pr = con.prepareStatement(query);
		pr.setInt(1, coustomer.getId());
		pr.setString(2, coustomer.getName());
		pr.setInt(3, coustomer.getAge());
		pr.execute();
		pr.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
			 if(con != null)
			 {
				 try {
					con.close();
				} catch (Exception e2) {
					
				}
			 }
			
		}
		

	}

	@Override
	public Customer getCustomerByID(int id) {
	Connection con = null;
	
 try {
	 Customer cs = null;
	 String query = "select * from srikanth.customer where id = ?";
	con = dataSource.getConnection();
	PreparedStatement prg = con.prepareStatement(query);
	prg.setInt(1, id);
	ResultSet rs = prg.executeQuery();
	if(rs.next())
	{
		 cs = new Customer(rs.getInt("id"), rs.getString("name"), rs.getInt("age"));
	}
	prg.close();
	rs.close();
	return cs;
}
 catch (Exception e) {
	e.printStackTrace();
	return null;
}
 finally {
	 if(con != null)
	 {
		 try {
			con.close();
		} catch (Exception e2) {
			
		}
	 }
	
}
	}

}
