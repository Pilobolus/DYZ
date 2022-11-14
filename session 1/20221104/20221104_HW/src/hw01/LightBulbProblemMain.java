package hw01;

public class LightBulbProblemMain {

	public static void main(String[] args) {
		LightBulb bulb1 = new LightBulb("綠燈", 5);
		LightBulb bulb2 = new LightBulb("黃燈", 4);
		LightBulb bulb3 = new LightBulb("紅燈", 6);
		LightBulbProblem.lightUp(new LightBulb[] {bulb1, bulb2, bulb3}, 120);
	}
}
