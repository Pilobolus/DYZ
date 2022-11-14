package hw02;

import java.util.ArrayList;
import java.util.Stack;

public class ExpressionProccessing {
	
	public static int calculate(String expression) {
		StringBuilder sb = new StringBuilder(expression);
		for(int i=0; i<sb.length(); i++) {
			if(sb.charAt(i) == ' ') {
				sb.deleteCharAt(i);
				i--;
			}
		}
		
		Stack<Integer> parentheses = new Stack<>();
		
		for(int i=0; i<sb.length(); i++) {
			char ch = sb.charAt(i);
			if(ch == '(') {
				
				if((i-1)>=0 && isNumber(DigitProperty.classify(sb.charAt(i-1)))) {
					sb.insert(i, "*");
					i++;
				}
					
				parentheses.push(i);
				
			}else if(ch == ')') {
				if(parentheses.isEmpty())
					throwExceptionIllegalExpression();
				int leftPar = parentheses.pop();
				if(leftPar+1 == i)
					throwExceptionIllegalExpression();
				if(i+1<sb.length() && (sb.charAt(i+1)=='(' || isNumber(DigitProperty.classify(sb.charAt(i+1)))))
					sb.insert(i+1, "*");
				
				
				int num = calculateSubstring(sb.substring(leftPar+1, i));
				
				sb.delete(leftPar, i+1);
				sb.insert(leftPar, num);
				i = leftPar;
			}
		}
		
		if(!parentheses.isEmpty())
			throwExceptionIllegalExpression();
		
		
		int ans = calculateSubstring(sb.toString());
		
		return ans;
		
	}
	private static int calculateSubstring(String subexpression) {
		if(subexpression == null)
			throw new NullPointerException("subexpression is null");
		if(subexpression.length() == 0)
			return 0;
		
		ArrayList[] lists = breakDown(subexpression);
		ArrayList<Integer> numbers = lists[0];
		ArrayList<Character> operators = lists[1];
		
		for(int i=0; i<operators.size(); i++) {
			char operator = operators.get(i);
			
			if(operator == '*') {
				int num = numbers.get(i) * numbers.get(i+1);
				numbers.set(i, num);
				numbers.remove(i+1);
				operators.remove(i);
				i--;
			}else if(operator == '/') {
				int num = numbers.get(i) / numbers.get(i+1);
				numbers.set(i, num);
				numbers.remove(i+1);
				operators.remove(i);
				i--;
			}else if(operator == '%') {
				int num = numbers.get(i) % numbers.get(i+1);
				numbers.set(i, num);
				numbers.remove(i+1);
				operators.remove(i);
				i--;
			}
		}
		
		
		int ans = numbers.get(0);
		
		for(int i=0; i<operators.size(); i++) {
			char operator = operators.get(i);

			if(operator == '+')
				ans += numbers.get(i+1);
			else if(operator == '-')
				ans -= numbers.get(i+1);
		}
		
		
		return ans;
	}
	
	private static ArrayList[] breakDown(String str) {
		if(str == null)
			throw new NullPointerException("str is null");
		
		ArrayList[] lists = new ArrayList[3];
		ArrayList<Integer> numbers = new ArrayList<>();
		ArrayList<Character> operators = new ArrayList<>();
		lists[0] = numbers;
		lists[1] = operators;
		
		
		int len = str.length();
		if(len == 0)
			return lists; 
		
		DigitProperty[] dps = new DigitProperty[len];
		
		for(int i=0; i<len; i++) {
			DigitProperty dpOfCh = DigitProperty.classify(str.charAt(i));
			if(!isValid(dpOfCh))
				throwExceptionIllegalExpression();
			dps[i] = dpOfCh;
		}
		
		
		
		int digit = 1;
		boolean isNumber = false;
		int startIndex = 0;
		boolean isMinus = false;
		boolean hasSigned = false;
		
		for(int curIndex=0; curIndex<len; curIndex++) {
			
			char ch = str.charAt(curIndex);
			DigitProperty dp = dps[curIndex];
			
			if(!isNumber) {
				
				if(curIndex == len-1) {
					
					if(isNumber(dp)) {
						int digitInInt = (int)(str.charAt(len-1) - '0');
						if(isMinus)
							digitInInt *= -1;
						numbers.add(digitInInt);
						
					}else {
						throwExceptionIllegalExpression();
					}
					break;
				}
				
				if(isNumberNotZero(dp)) {
					
					isNumber = true;
					startIndex = curIndex;
					digit = 1;
				}else if(isZero(dp)) {
					continue;
				}else if(isSign(dp)) {
					if(hasSigned)
						throwExceptionIllegalExpression();
					if(ch == '-')
						isMinus = true;
					hasSigned = true;
				}else {
					throwExceptionIllegalExpression();
				}
				
			}else {
				
				if(curIndex == len-1) {
					
					if(isNumber(dp)) {
						
						digit *= 10;
						int num = 0;
						for(int i=startIndex; i<=len-1; i++) {
							int digitInInt = (int)(str.charAt(i) - '0');
							num += (digit * digitInInt);
							digit /= 10;
						}
						
						if(isMinus)
							num *= -1;
						
						numbers.add(num);
					}else {
						throwExceptionIllegalExpression();
					}
					break;
				}
				
				if(isOperator(dp)) {
					isNumber = false;
					
					int num = 0;
					for(int i=startIndex; i<curIndex; i++) {
						int digitInInt = (int)(str.charAt(i) - '0');
						num += (digit * digitInInt);
						digit /= 10;
					}
					
					if(isMinus)
						num *= -1;
					
					numbers.add(num);
					operators.add(ch);
					
					isMinus = false;
					hasSigned = false;
					
				}else if(isNumber(dp)) {
					digit *= 10;
				}else {
					throwExceptionIllegalExpression();
				}
			}

			
		}
		
		return lists;
	}
	
	
	private static boolean isNumberNotZero(DigitProperty dp) {
		return (dp == DigitProperty.IS_NUMBER_NOT_ZERO);
	}
	private static boolean isZero(DigitProperty dp) {
		return (dp == DigitProperty.IS_ZERO);
	}
	private static boolean isNumber(DigitProperty dp) {
		return (isNumberNotZero(dp) || isZero(dp));
	}
	
	
	private static boolean isSign(DigitProperty dp) {
		return (dp == DigitProperty.IS_SIGN);
	}
	
	private static boolean isOperatorNotAddOrSub(DigitProperty dp) {
		return (dp == DigitProperty.IS_OPERATOR_NOT_ADD_OR_SUB);
	}
	private static boolean isOperator(DigitProperty dp) {
		return (isOperatorNotAddOrSub(dp) || isSign(dp));
	}
	
	private static boolean isValid(DigitProperty dp) {
		return dp != DigitProperty.INVALID;
	}
	
	
	private static void throwExceptionIllegalExpression() {
		throw new IllegalArgumentException("illegal expression");
	}
	
	
	private enum DigitProperty{
		IS_NUMBER_NOT_ZERO, IS_ZERO, IS_SIGN, IS_OPERATOR_NOT_ADD_OR_SUB, INVALID;
		
		private static DigitProperty classify(char ch) {
			if(ch>='1' && ch<='9')
				return IS_NUMBER_NOT_ZERO;
			if(ch == '0')
				return IS_ZERO;
			if(ch=='+' || ch=='-')
				return IS_SIGN;
			if(ch=='*' || ch=='/' || ch=='%')
				return IS_OPERATOR_NOT_ADD_OR_SUB;
			return INVALID;
		}
	}
}
