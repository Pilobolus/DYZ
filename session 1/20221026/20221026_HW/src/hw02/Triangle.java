package hw02;

public class Triangle {

	public static void printTriangle(int n) {
		if(n <= 0)
			throw new IllegalArgumentException("n<=0");
		
		for(int i=1; i<=n; i++) {
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}
			System.out.println(String.format("(%d)", i));
		}
		for(int i=n-1; i>=1; i--) {
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}
			System.out.println(String.format("(%d)", i));
		}
	}
}
