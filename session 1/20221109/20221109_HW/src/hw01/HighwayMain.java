package hw01;


public class HighwayMain {

	public static void main(String[] args) {
		Car car1 = new Car("Toyota", "altis", 1);
		Car car2 = new Car("BMW", "M3", 2);
		Car car3 = new Car("Benz", "C300", 3);
		
		
//		Car[] highway = new Car[]{
//			car1, car2, car3, null, null, null, null, null, null, null, null, null
//		};
		
		
//		Car[] highway = new Car[]{
//			car3, car2, car1, null, null, null, null, null, null, null, null, null
//		};
		
		// { null, car3, car2, car1, null, null, null, null, null, null, null, null }
		
		Car[] highway = new Car[]{
			car1, car3, car2, null, null, null, null, null, null, null, null, null, null, null, null
		};		
		//{ null, car1, null, car3, car2, null, null, null, null, null, null, null }
		
		
		int endNo = 10;
		
		// 第1秒
		// 0:null
		// 1:"Benz-C300"
		// 2:"BMW-M3"
		// 3:Toyota-altis"
		// 4 ~ end : null

	}

}

class Car {
	
	private String brand;
	
	private String type;
	
	private int speed;

	public Car(String brand, String type, int speed) {
		this.brand = brand;
		this.type = type;
		this.speed = speed;
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + ", type=" + type + ", speed=" + speed
				+ "]";
	}	
}
