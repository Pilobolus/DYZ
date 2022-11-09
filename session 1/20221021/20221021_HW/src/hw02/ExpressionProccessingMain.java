package hw02;

public class ExpressionProccessingMain {

	public static void main(String[] args) {
		String ex1 = "2+5";// 加法
		String ex2 = "2+5*2";// 先乘除後加減
		String ex3 = "2-14/3+8";// 先乘除後加減
		String ex4 = "5*3-6%4+4";// 先乘除(同餘)後加減
		String ex5 = "05*3-6%04+4";// 數字前補0自動忽略
		String ex6 = "+05*3--6%-04+4";// 數字前可以加正負號
		String ex7 = "(+5)*3-(-6)%(-4)+4";// 可以加括號
		String ex8 = "(+5)*(3-(-6))%(-4)+4";// 括號影響運算順序
		String ex9 = "(+005)*(+03-(-6))%(-04)+4";// 括號搭配數字前補0
		String ex10 = "2*-(23-4)/5";// 括號前可放正負號
		String ex11 = "3(5+(-10))";// 括號與數字相鄰代表乘
		String ex12 = "3((-1)5+(-10))(2)";// 括號與括號相鄰代表乘
		String ex13 = " 3 ((-1)5+   (-10))       (2) ";// 空格自動忽略
		
		
		// exception
		String error1 = "2+5-";// 結尾不可為運算元
		String error2 = "2+5!";// 不可有其他字元
		String error3 = "2+5//9";// 乘除(同餘)不可連續重複
		String error4 = "2*++5";// 正負號不可重複
		String error5 = "2+5-()";// 括號內不可無內容
		String error6 = "10(/5-2)*3";// 左括號不可緊接運算元(+-視為正負)
		String error7 = "10/(5-2*)3";// 右括號前不可為運算元
		String error8 = "10/(5-2)*3)";// 左右括號數量不一
		String error9 = "10/((5-2*3)";// 左右括號數量不一
		
		
		
		System.out.println(ex1 + " = " + ExpressionProccessing.calculate(ex1));
		System.out.println(ex2 + " = " + ExpressionProccessing.calculate(ex2));
		System.out.println(ex3 + " = " + ExpressionProccessing.calculate(ex3));
		System.out.println(ex4 + " = " + ExpressionProccessing.calculate(ex4));
		System.out.println(ex5 + " = " + ExpressionProccessing.calculate(ex5));
		System.out.println(ex6 + " = " + ExpressionProccessing.calculate(ex6));
		System.out.println(ex7 + " = " + ExpressionProccessing.calculate(ex7));
		System.out.println(ex8 + " = " + ExpressionProccessing.calculate(ex8));
		System.out.println(ex9 + " = " + ExpressionProccessing.calculate(ex9));
		System.out.println(ex10 + " = " + ExpressionProccessing.calculate(ex10));
		System.out.println(ex11 + " = " + ExpressionProccessing.calculate(ex11));
		System.out.println(ex12 + " = " + ExpressionProccessing.calculate(ex12));
		System.out.println(ex13 + " = " + ExpressionProccessing.calculate(ex13));
		
//		System.out.println(error1 + " = " + ExpressionProccessing.calculate(error1));
//		System.out.println(error2 + " = " + ExpressionProccessing.calculate(error2));
//		System.out.println(error3 + " = " + ExpressionProccessing.calculate(error3));
//		System.out.println(error4 + " = " + ExpressionProccessing.calculate(error4));
//		System.out.println(error5 + " = " + ExpressionProccessing.calculate(error5));
//		System.out.println(error6 + " = " + ExpressionProccessing.calculate(error6));
//		System.out.println(error7 + " = " + ExpressionProccessing.calculate(error7));
//		System.out.println(error8 + " = " + ExpressionProccessing.calculate(error8));
//		System.out.println(error9 + " = " + ExpressionProccessing.calculate(error9));
		
	}

}
