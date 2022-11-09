package hw02;

public class SquidGameMain {

	public static void main(String[] args) {
		// △ ⭕ □ ☆
		String str = "☆△⭕☆";
		int ans = SquidGame.edge(str);
		
		System.out.println(ans);

	}

}
