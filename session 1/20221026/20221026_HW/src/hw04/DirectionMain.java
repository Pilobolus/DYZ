package hw04;

public class DirectionMain {

	public static void main(String[] args) {
		
		String[][] map = {
				{"A", "B", "C"},
				{"F", "G", "H", "I", "J"},
				{"K", "L", "M", "N", "O"},
				{"P"},
				{"U", "V", "W", "X", "Y"}
		};
		String direction = "↓↑→←↓↓↘↖↘↗↗→→↓↖→↓↙";
		String direction2 = "";
		System.out.println(Direction.direction(map, direction));

	}

}
