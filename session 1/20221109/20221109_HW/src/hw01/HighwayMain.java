package hw01;

public class HighwayMain {

	public static void main(String[] args) {
		Car car1 = new Car("Toyota", "altis", 1);
		Car car2 = new Car("BMW", "M3", 2);
		Car car3 = new Car("Benz", "C300", 3);
		
		
		Car[] cars = {car3, car2, car1, null, null, null, null, null, null, null, null};
		Highway.printCar(cars, 5);
	}

}
