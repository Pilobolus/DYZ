package hw03;

import java.util.Stack;

public class InterviewResult {

	public static void main(String[] args){
		interview(4);
		
	}
	
	
	public static void interview(int n){
		if(n < 0)
			throw new IllegalArgumentException("n < 0");
		if(n == 0)
			return;
		
		char[] result = new char[n];
		String[] names = new String[n];
		
		for(int i=0; i<n; i++){
			names[i] = getName(i);
		}
		
		int[] rowNum = new int[]{1};
		interviewRecur(n, result, names, 0, rowNum);
	}
	private static void interviewRecur(int n, char[] result, String[] names, int index, int[] rowNum){
		if(index >= n){
			String str = rowNum[0] + ". ";
			
			
			for(int i=0; i<n; i++){
				if(i != 0)
					str += ", ";
				str += (names[i] + ":" + result[i]);
			}
			
			System.out.println(str);
			
			rowNum[0] += 1;
			return;
		}
		
		result[index] = 'o';
		interviewRecur(n, result, names, index+1, rowNum);
		result[index] = 'x';
		interviewRecur(n, result, names, index+1, rowNum);
		return;
	}
	
	private static String getName(int n){
		
		
		int num = 26;
		int index = 1;
		
		while((n-num) >= 0){
			n -= num;
			num *= 26;
			index++;
		}
		Stack<Character> stack = new Stack<>();
		
		
		for(int i=1; i<=index; i++){
			stack.push((char)(n%26 + 65));
			n /= 26;
		}
		
		String name = "";
		for(int i=1; i<=index; i++){
			name += stack.pop();
		}
		
		return name;
	}
}
