package bean;

import java.util.Objects;

public class Order {

	private int id;
	private String date;
	private String customerId;
	private int goodsId;
	private int goodsBuyPrice;
	private int buyQuantity;
	
	
	public Order() {
	}
	public Order(int id, String date, String customerId, int goodsId, int goodsBuyPrice, int buyQuantity) {
		this.id = id;
		this.date = date;
		this.customerId = customerId;
		this.goodsId = goodsId;
		this.goodsBuyPrice = goodsBuyPrice;
		this.buyQuantity = buyQuantity;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public int getGoodsBuyPrice() {
		return goodsBuyPrice;
	}
	public void setGoodsBuyPrice(int goodsBuyPrice) {
		this.goodsBuyPrice = goodsBuyPrice;
	}
	public int getBuyQuantity() {
		return buyQuantity;
	}
	public void setBuyQuantity(int buyQuantity) {
		this.buyQuantity = buyQuantity;
	}
	
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", date=" + date + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return id == other.id;
	}
	
	
}
