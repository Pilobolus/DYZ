package hw03;

public class ChristmasTree {

	public static void printChristmasTree(int n) {
		if(n <= 0)
			throw new IllegalArgumentException("n<=0");
		
		for(int i=1; i<=n; i++) {
			
			for(int j=0; j<n-i; j++) {
				System.out.print("x");
			}
			System.out.print(n-i);
			
			for(int j=0; j<(2*i-1); j++) {
				System.out.print("*");
			}
			System.out.println(String.format("(%d)", 2*i-1));

		}
	}
}
