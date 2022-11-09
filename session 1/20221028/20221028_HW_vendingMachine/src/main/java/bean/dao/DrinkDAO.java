package bean.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Drink;
import tool.DBTool;

public class DrinkDAO {

	public static final DrinkDAO INSTANCE = new DrinkDAO();
	
	private DrinkDAO() {
		
	}
	
	public List<Drink> getDrinks(){
		List<Drink> drinkList = new ArrayList<>();
		
		String query = "SELECT * FROM BEVERAGE_GOODS";
		try(Connection connection = DBTool.INSTANCE.getConnection();
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(query);) {
			
			while(rs.next()) {
				Drink d = new Drink();
				d.setId(rs.getInt(1));
				d.setName(rs.getString(2));
				d.setDescription(rs.getString(3));
				d.setPrice(rs.getInt(4));
				d.setQuantity(rs.getInt(5));
				d.setImage(rs.getString(6));
				d.setStatus(rs.getString(7));
				drinkList.add(d);
			}
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return drinkList;
	}
	
	public List<Drink> getDrinkOnSale() {
		List<Drink> list = new ArrayList<>();

		
		String query = "SELECT * FROM BEVERAGE_GOODS WHERE STATUS = \'1\' AND QUANTITY>0";
		try(Connection connection = DBTool.INSTANCE.getConnection();
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(query);) {
			
			while(rs.next()) {
				Drink d = new Drink();
				d.setId(rs.getInt(1));
				d.setName(rs.getString(2));
				d.setDescription(rs.getString(3));
				d.setPrice(rs.getInt(4));
				d.setQuantity(rs.getInt(5));
				d.setImage(rs.getString(6));
				d.setStatus(rs.getString(7));
				list.add(d);
			}
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		
		return list;
	}
	
	public Drink getDrinkById(int id) {
		Drink d = new Drink();
		
		
		StringBuilder querySb = new StringBuilder();
		querySb.append("SELECT * FROM BEVERAGE_GOODS ")
			.append("WHERE GOODS_ID = \'")
			.append(id)
			.append("\'");
		try(Connection connection = DBTool.INSTANCE.getConnection();
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(querySb.toString());) {
			
			rs.next();
			d.setId(rs.getInt(1));
			d.setName(rs.getString(2));
			d.setDescription(rs.getString(3));
			d.setPrice(rs.getInt(4));
			d.setQuantity(rs.getInt(5));
			d.setImage(rs.getString(6));
			d.setStatus(rs.getString(7));
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return d;
	}
	
	public int addDrink(Drink drink) {
		
		
		StringBuilder querySb = new StringBuilder();
		querySb.append("INSERT INTO BEVERAGE_GOODS ")
			.append("(GOODS_ID, GOODS_NAME, DESCRIPTION, PRICE, QUANTITY, IMAGE_NAME, STATUS) VALUES ")
			.append("(BEVERAGE_GOODS_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?)");
		
		int generatedKey = 0;
		try(Connection connection = DBTool.INSTANCE.getConnection();
				PreparedStatement pst = connection.prepareStatement(querySb.toString(), Statement.RETURN_GENERATED_KEYS);) {
			
			pst.setString(1, drink.getName());
			pst.setString(2, drink.getDescription());
			pst.setInt(3, drink.getPrice());
			pst.setInt(4, drink.getQuantity());
			pst.setString(5, drink.getImage());
			pst.setString(6, drink.getStatus());
			
			int rowAffect = pst.executeUpdate();

			if(rowAffect > 0) {
				try (Statement st = connection.createStatement();
						ResultSet keys = st.executeQuery("SELECT BEVERAGE_GOODS_SEQ.CURRVAL FROM dual");){
					if(keys.next())
						generatedKey = keys.getInt(1);
				}
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return generatedKey;
	}
	
	public boolean update(Drink drink) {
		
		StringBuilder querySb = new StringBuilder();
		querySb.append("UPDATE BEVERAGE_GOODS SET ")
			.append("GOODS_NAME = ?, DESCRIPTION = ?, PRICE = ?, ")
			.append("QUANTITY = ?, IMAGE_NAME = ?, STATUS = ? WHERE GOODS_ID = ?");


		
		try(Connection connection = DBTool.INSTANCE.getConnection();
				PreparedStatement pst = connection.prepareStatement(querySb.toString());) {
			
			pst.setString(1, drink.getName());
			pst.setString(2, drink.getDescription());
			pst.setInt(3, drink.getPrice());
			pst.setInt(4, drink.getQuantity());
			pst.setString(5, drink.getImage());
			pst.setString(6, drink.getStatus());
			pst.setInt(7, drink.getId());
			
			int rowAffect = pst.executeUpdate();
			if(rowAffect > 0)
				return true;
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return false;
	}
	
	public boolean update(int id, int price, int quantity, String status) {
		String query = "UPDATE BEVERAGE_GOODS SET PRICE = ?, QUANTITY = ?, STATUS = ? WHERE GOODS_ID = ?";

		
		try(Connection connection = DBTool.INSTANCE.getConnection();
				PreparedStatement pst = connection.prepareStatement(query);) {
			
			
			pst.setInt(1, price);
			pst.setInt(2, quantity);
			pst.setString(3, status);
			pst.setInt(4, id);
			
			int rowAffect = pst.executeUpdate();
			if(rowAffect > 0)
				return true;
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return false;
	}
	
	
	public List<Drink> searchOnSale(String keyword){
		List<Drink> list = new ArrayList<>();

		String query = "SELECT * FROM BEVERAGE_GOODS WHERE GOODS_NAME LIKE \'%%%s%%\'";
		
		try(Connection connection = DBTool.INSTANCE.getConnection();
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(String.format(query, keyword));) {
			
			while(rs.next()) {
				Drink d = new Drink();
				d.setId(rs.getInt(1));
				d.setName(rs.getString(2));
				d.setDescription(rs.getString(3));
				d.setPrice(rs.getInt(4));
				d.setQuantity(rs.getInt(5));
				d.setImage(rs.getString(6));
				d.setStatus(rs.getString(7));
				list.add(d);
			}
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		
		return list;
	}
}
