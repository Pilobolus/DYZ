package hw02;

public class SearchText {

	public static int[] search(String str, String[] keyWords){
		
		if(str == null)
			throw new NullPointerException("str is null");
		if(keyWords == null)
			throw new NullPointerException("keyWords is null");
		
		int len = keyWords.length;
		int[] ans = new int[len];
		
		for(int i=0; i<len; i++){
			int count = 0;
			int index = 0;
			
			while(index<str.length() && (index=str.indexOf(keyWords[i], index)) != -1){
				count++;
				index++;
			}
			ans[i] = count;
		}
		
		return ans;
	}
}
