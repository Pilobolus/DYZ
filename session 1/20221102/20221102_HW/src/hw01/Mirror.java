package hw01;

public class Mirror {

	public static String[][] mirror(String[][] array){
		for(int i=0; i<array.length; i++){
			int len = array[i].length;
			
			for(int j=len/2, k=len/2-1; j<len; j++, k--){
				array[i][j] = array[i][k];
			}
		}
		
		return array;
	}
}
