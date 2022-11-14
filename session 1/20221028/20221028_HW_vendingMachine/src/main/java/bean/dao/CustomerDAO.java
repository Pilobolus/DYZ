package bean.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Customer;
import tool.DBTool;

public class CustomerDAO {

	public static final CustomerDAO INSTANCE = new CustomerDAO();
	
	private CustomerDAO() {
	}
	
	public List<Customer> getCustomers(){
		List<Customer> customerList = new ArrayList<>();
		
		String query = "SELECT * FROM BEVERAGE_MEMBER";
		try(Connection connection = DBTool.INSTANCE.getConnection();
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(query);) {
			
			while(rs.next()) {
				Customer c = new Customer();
				c.setId(rs.getString(1));
				c.setPassword(rs.getString(2));
				c.setName(rs.getString(3));
				customerList.add(c);
			}
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return customerList;
	}
	public Customer getCustomerById(String id) {
		Customer c = new Customer();
		
		
		StringBuilder querySb = new StringBuilder();
		querySb.append("SELECT * FROM BEVERAGE_MEMBER ")
			.append("WHERE IDENTIFICATION_NO = \'")
			.append(id)
			.append("\'");
		
		try(Connection connection = DBTool.INSTANCE.getConnection();
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(querySb.toString());) {
			
			rs.next();
			c.setId(rs.getString(1));
			c.setPassword(rs.getString(2));
			c.setName(rs.getString(3));
			
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return c;
	}
}
