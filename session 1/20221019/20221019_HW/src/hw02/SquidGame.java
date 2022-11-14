package hw02;

public class SquidGame {

	public static int edge(String str){
		if(str == null)
			throw new NullPointerException("string is null");
		if(str.length() == 0)
			return 0;
		
		int ans = 0;
		
		for(int i=0; i<str.length(); i++){
			char ch = str.charAt(i);
			
			switch(ch){
			case '△':
				ans += 3;
				break;
			case '⭕':
				ans += 1;
				break;
			case '□':
				ans += 4;
				break;
			case '☆':
				ans += 10;
				break;
			}
		}
		
		return ans;
		
		
	}
}
