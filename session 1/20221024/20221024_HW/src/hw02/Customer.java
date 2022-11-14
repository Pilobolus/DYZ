package hw02;

public class Customer {

	public static String maskName(String name) {
		if(name == null)
			throw new NullPointerException("name is null");
		
		int len = name.length();
		StringBuilder sb = new StringBuilder(name);
		if(len==0 || len==1) {
			return sb.toString();
		}else if(len == 2) {
			sb.replace(1, 2, "O");
		}else {
			for(int i=1; i<len-1; i++) {
				sb.replace(i, i+1, "O");
			}
			
		}
		
		return sb.toString();
	}
}
