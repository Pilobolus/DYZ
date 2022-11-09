package hw01;

public class MutiplicationTable {

	public static void printTable1() {
		for(int i=2; i<=9; i++) {
			for(int j=2; j<=9; j++) {
				
				System.out.print(String.format("%d*%d=%2d", i, j, i*j));
				if(j < 9)
					System.out.print(" ");
			}
			
			System.out.println();
		}
	}
	
	public static void printTable2() {
		for(int i=2; i<=9; i++) {
			for(int j=i; j<=9; j++) {
				
				System.out.print(String.format("%d*%d=%2d", i, j, i*j));
				if(j < 9)
					System.out.print(" ");
			}
			
			System.out.println();
		}
	}
}
