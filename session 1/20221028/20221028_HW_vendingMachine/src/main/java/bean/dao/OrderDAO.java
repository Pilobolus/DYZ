package bean.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Order;
import tool.DBTool;
import tool.MyDateTimeTool;

public class OrderDAO {

	public static final OrderDAO INSTANCE = new OrderDAO();
	
	private OrderDAO() {
		
	}
	
	
	public List<Order> getOrders(){
		List<Order> orderList = new ArrayList<>();
		
		String query = "SELECT * FROM BEVERAGE_ORDER";
		try(Connection connection = DBTool.INSTANCE.getConnection();
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(query);) {
			
			while(rs.next()) {
				Order o = new Order();
				o.setId(rs.getInt(1));
				o.setDate(rs.getString(2));
				o.setCustomerId(rs.getString(3));
				o.setGoodsId(rs.getInt(4));
				o.setGoodsBuyPrice(rs.getInt(5));
				o.setBuyQuantity(rs.getInt(6));
				orderList.add(o);
			}
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return orderList;
	}
	public Order getOrderById(int id) {
		Order o = new Order();
		
		
		StringBuilder querySb = new StringBuilder();
		querySb.append("SELECT * FROM BEVERAGE_ORDER WHERE ORDER_ID = ").append(id);

		try(Connection connection = DBTool.INSTANCE.getConnection();
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(querySb.toString());) {
			
			rs.next();
			o.setId(rs.getInt(1));
			o.setDate(rs.getString(2));
			o.setCustomerId(rs.getString(3));
			o.setGoodsId(rs.getInt(4));
			o.setGoodsBuyPrice(rs.getInt(5));
			o.setBuyQuantity(rs.getInt(6));
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return o;
	}
	
	public List<Order> getOrderByDate(String sDateStr, String eDateStr){

		List<Order> orderList = new ArrayList<>();
		
		String query = "SELECT * FROM BEVERAGE_ORDER WHERE ORDER_DATE BETWEEN ? AND ?";
		try(Connection connection = DBTool.INSTANCE.getConnection();
				PreparedStatement pst = connection.prepareStatement(query);) {
			
			pst.setTimestamp(1, MyDateTimeTool.parse(sDateStr));
			pst.setTimestamp(2, MyDateTimeTool.parse(eDateStr));
			
			try(ResultSet rs = pst.executeQuery();){
				while(rs.next()) {
					Order o = new Order();
					o.setId(rs.getInt(1));
					o.setDate(rs.getString(2));
					o.setCustomerId(rs.getString(3));
					o.setGoodsId(rs.getInt(4));
					o.setGoodsBuyPrice(rs.getInt(5));
					o.setBuyQuantity(rs.getInt(6));
					orderList.add(o);
				}
			}
			
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return orderList;
		
	}
	
	
	public String getCustomerNameFromOrder(Order order) {
		String customerName = "";
		
		
		StringBuilder querySb = new StringBuilder();
		querySb.append("SELECT CUSTOMER_NAME FROM BEVERAGE_MEMBER ")
			.append("INNER JOIN BEVERAGE_ORDER ON BEVERAGE_MEMBER.IDENTIFICATION_NO = BEVERAGE_ORDER.CUSTOMER_ID ")
			.append("WHERE BEVERAGE_ORDER.ORDER_ID = ?");

		try(Connection connection = DBTool.INSTANCE.getConnection();
				PreparedStatement pst = connection.prepareStatement(querySb.toString());){
			pst.setInt(1, order.getId());
			
			try(ResultSet rs = pst.executeQuery();){
				if(rs.next())
					customerName = rs.getString(1);
			}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return customerName;
		
	}
	public String getDrinkNameFromOrder(Order order) {
		String drinkName = "";
		
		
		StringBuilder querySb = new StringBuilder();
		querySb.append("SELECT GOODS_NAME FROM BEVERAGE_GOODS ")
			.append("INNER JOIN BEVERAGE_ORDER ON BEVERAGE_GOODS.GOODS_ID = BEVERAGE_ORDER.GOODS_ID ")
			.append("WHERE BEVERAGE_ORDER.ORDER_ID = ?");

		try(Connection connection = DBTool.INSTANCE.getConnection();
				PreparedStatement pst = connection.prepareStatement(querySb.toString());){
			pst.setInt(1, order.getId());
			
			try(ResultSet rs = pst.executeQuery();){
				if(rs.next())
					drinkName = rs.getString(1);
			}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return drinkName;
	}
	
	public boolean addOrder(Order order) {
		
		StringBuilder querySb = new StringBuilder();
		querySb.append("INSERT INTO BEVERAGE_ORDER ")
			.append("(ORDER_ID, ORDER_DATE, CUSTOMER_ID, GOODS_ID, GOODS_BUY_PRICE, BUY_QUANTITY) VALUES ")
			.append("(BEVERAGE_ORDER_SEQ.NEXTVAL, ?, ?, ?, ?, ?)");


		try(Connection connection = DBTool.INSTANCE.getConnection();
				PreparedStatement pst = connection.prepareStatement(querySb.toString());) {
			pst.setTimestamp(1, MyDateTimeTool.parse(order.getDate()));
			pst.setString(2, order.getCustomerId());
			pst.setInt(3, order.getGoodsId());
			pst.setInt(4, order.getGoodsBuyPrice());
			pst.setInt(5, order.getBuyQuantity());
			
			int row = pst.executeUpdate();
			
			if(row >0)
				return true;
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return false;
	}
}
