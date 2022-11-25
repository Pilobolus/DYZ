package hw01;

public class DuplicateNumberCount {

	public static int count(int[] numbers){
		int len = numbers.length;
		
		int[] buffer = new int[len];
		int count = 0;
		
		loop:for(int i=0; i<len; i++){
			for(int j=0; j<count; j++){
				if(numbers[i] == buffer[j])
					continue loop;
			}
			
			buffer[count++] = numbers[i];
		}
		
		for(int i=0; i<count; i++){
			System.out.print(buffer[i] + " ");
		}
		System.out.println();
		
		return count+1;
	}
}
