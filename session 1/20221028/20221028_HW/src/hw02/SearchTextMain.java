package hw02;

import java.util.Arrays;

public class SearchTextMain {

	public static void main(String[] args) {
		String str = "鉛筆牛肉鉛筆豬肉鉛筆牛肉";
		String[] strArray = {"鉛筆", "肉鉛筆", "鉛筆牛"};
		
		System.out.println(Arrays.toString(SearchText.search(str, strArray)));

	}

}
