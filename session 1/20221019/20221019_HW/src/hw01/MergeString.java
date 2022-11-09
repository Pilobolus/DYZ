package hw01;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class MergeString {

	public static Set<Integer> merge(String str){
		if(str == null)
			throw new NullPointerException("string is null");
		
		Set<Integer> ans = new HashSet<>();
		
		if(str.length() == 0)
			return ans;
		
		int[] array = new int[9];
		for(int i=0; i<str.length(); i++){
			char ch = str.charAt(i);
			if(ch<'1' || ch>'9')
				throw new NumberFormatException("has to be number 1-9");
			
			int num = (int)ch - 48;
			
			array[num-1]++;
		}
		
		for(int i=0; i<8; i++){
			array[i+1] += array[i]/2;
			array[i] %= 2;
		}
		for(int i=0; i<8; i++){
			if(array[i] != 0)
				ans.add(i+1);
		}
		
		int n = array[8];
		int index = 9;
		while(n > 0){
			if(n%2 == 1)
				ans.add(index);
			n /= 2;
			index++;
		}
		
		return ans;
	}
}
