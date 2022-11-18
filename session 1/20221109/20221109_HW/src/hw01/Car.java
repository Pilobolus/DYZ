package hw01;

public class Car {
	private String brand;
	private String type;
	private int speed;
	
	
	public Car(String brand, String type, int speed) {
		this.brand = brand;
		this.type = type;
		this.speed = speed;
	}


	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}


	@Override
	public String toString() {
		return "Car [brand=" + brand + ", type=" + type + "]";
	}

}
