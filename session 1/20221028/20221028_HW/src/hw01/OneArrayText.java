package hw01;

public class OneArrayText {

	public static void print(String[] array){
		if(array == null)
			throw new NullPointerException("array is null");
		
		int len = array.length;
		for(int i=len-1; i>0; i--){
			System.out.println(String.format("%d字結果", i));
			for(int j=0; (j+i-1)<len; j++){
				for(int k=j; k<=j+i-1; k++){
					System.out.print(array[k]);
				}
				System.out.println();
			}
		}
	}
}
