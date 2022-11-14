package hw02;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class CountRepeatMain {

	public static void main(String[] args) {
		
		String str1 = null;// throws Exception
		String str2 = "";// 1
		String str3 = "我是誰";// 1
		String str4 = "我是誰我是誰";// 2
		String str5 = "我是誰我4誰";// 1
		String str6 = "我是誰他是誰";// 1
		String str7 = "我是誰他4誰";// 1
		String str8 = "我";// 1
		String str9 = "我我";// 2
		String str10 = "我他";// 1
		String str11 = "我是誰我是";// 1
		String str12 = "我是誰我";// 1
		String str13 = "我是誰我是誰我是";// 1
		String str14 = "我是誰我是誰我";// 1
		String str15 = "我是誰他是誰我是誰他是誰";// 2
		
		String str16 = "我是誰我4誰我是誰我4誰";// depends on classes
		String str17 = "我是誰我4誰我誰我是誰我4誰我誰";// depends on classes
		String str18 = "我是誰我4誰我誰我是誰我4誰我";// 1
		
		
		System.out.println("===================CountRepeat.count1=====================");
//		System.out.println("str1 " + str1 + " : " + CountRepeat.count1(str1));
		System.out.println("str2 " + str2 + " : " + CountRepeat.count1(str2));
		System.out.println("str3 " + str3 + " : " + CountRepeat.count1(str3));
		System.out.println("str4 " + str4 + " : " + CountRepeat.count1(str4));
		System.out.println("str5 " + str5 + " : " + CountRepeat.count1(str5));
		System.out.println("str6 " + str6 + " : " + CountRepeat.count1(str6));
		System.out.println("str7 " + str7 + " : " + CountRepeat.count1(str7));
		System.out.println("str8 " + str8 + " : " + CountRepeat.count1(str8));
		System.out.println("str9 " + str9 + " : " + CountRepeat.count1(str9));
		System.out.println("str10 " + str10 + " : " + CountRepeat.count1(str10));
		System.out.println("str11 " + str11 + " : " + CountRepeat.count1(str11));
		System.out.println("str12 " + str12 + " : " + CountRepeat.count1(str12));
		System.out.println("str13 " + str13 + " : " + CountRepeat.count1(str13));
		System.out.println("str14 " + str14 + " : " + CountRepeat.count1(str14));
		System.out.println("str15 " + str15 + " : " + CountRepeat.count1(str15));
		System.out.println("str16 " + str16 + " : " + CountRepeat.count1(str16));
		System.out.println("str17 " + str17 + " : " + CountRepeat.count1(str17));
		System.out.println("str18 " + str18 + " : " + CountRepeat.count1(str18));


		System.out.println("===================CountRepeat.count2=====================");
//		System.out.println("str1 " + str1 + " : " + CountRepeat.count2(str1));
		System.out.println("str2 " + str2 + " : " + CountRepeat.count2(str2));
		System.out.println("str3 " + str3 + " : " + CountRepeat.count2(str3));
		System.out.println("str4 " + str4 + " : " + CountRepeat.count2(str4));
		System.out.println("str5 " + str5 + " : " + CountRepeat.count2(str5));
		System.out.println("str6 " + str6 + " : " + CountRepeat.count2(str6));
		System.out.println("str7 " + str7 + " : " + CountRepeat.count2(str7));
		System.out.println("str8 " + str8 + " : " + CountRepeat.count2(str8));
		System.out.println("str9 " + str9 + " : " + CountRepeat.count2(str9));
		System.out.println("str10 " + str10 + " : " + CountRepeat.count2(str10));
		System.out.println("str11 " + str11 + " : " + CountRepeat.count2(str11));
		System.out.println("str12 " + str12 + " : " + CountRepeat.count2(str12));
		System.out.println("str13 " + str13 + " : " + CountRepeat.count2(str13));
		System.out.println("str14 " + str14 + " : " + CountRepeat.count2(str14));
		System.out.println("str15 " + str15 + " : " + CountRepeat.count2(str15));
		System.out.println("str16 " + str16 + " : " + CountRepeat.count2(str16));
		System.out.println("str17 " + str17 + " : " + CountRepeat.count2(str17));
		System.out.println("str18 " + str18 + " : " + CountRepeat.count2(str18));
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("===================CountRepeat2.count1=====================");
//		System.out.println("str1 " + str1 + " : " + CountRepeat2.count1(str1));
		System.out.println("str2 " + str2 + " : " + CountRepeat2.count1(str2));
		System.out.println("str3 " + str3 + " : " + CountRepeat2.count1(str3));
		System.out.println("str4 " + str4 + " : " + CountRepeat2.count1(str4));
		System.out.println("str5 " + str5 + " : " + CountRepeat2.count1(str5));
		System.out.println("str6 " + str6 + " : " + CountRepeat2.count1(str6));
		System.out.println("str7 " + str7 + " : " + CountRepeat2.count1(str7));
		System.out.println("str8 " + str8 + " : " + CountRepeat2.count1(str8));
		System.out.println("str9 " + str9 + " : " + CountRepeat2.count1(str9));
		System.out.println("str10 " + str10 + " : " + CountRepeat2.count1(str10));
		System.out.println("str11 " + str11 + " : " + CountRepeat2.count1(str11));
		System.out.println("str12 " + str12 + " : " + CountRepeat2.count1(str12));
		System.out.println("str13 " + str13 + " : " + CountRepeat2.count1(str13));
		System.out.println("str14 " + str14 + " : " + CountRepeat2.count1(str14));
		System.out.println("str15 " + str15 + " : " + CountRepeat2.count1(str15));
		System.out.println("str16 " + str16 + " : " + CountRepeat2.count1(str16));
		System.out.println("str17 " + str17 + " : " + CountRepeat2.count1(str17));
		System.out.println("str18 " + str18 + " : " + CountRepeat2.count1(str18));


		System.out.println("===================CountRepeat2.count2=====================");
//		System.out.println("str1 " + str1 + " : " + CountRepeat2.count2(str1));
		System.out.println("str2 " + str2 + " : " + CountRepeat2.count2(str2));
		System.out.println("str3 " + str3 + " : " + CountRepeat2.count2(str3));
		System.out.println("str4 " + str4 + " : " + CountRepeat2.count2(str4));
		System.out.println("str5 " + str5 + " : " + CountRepeat2.count2(str5));
		System.out.println("str6 " + str6 + " : " + CountRepeat2.count2(str6));
		System.out.println("str7 " + str7 + " : " + CountRepeat2.count2(str7));
		System.out.println("str8 " + str8 + " : " + CountRepeat2.count2(str8));
		System.out.println("str9 " + str9 + " : " + CountRepeat2.count2(str9));
		System.out.println("str10 " + str10 + " : " + CountRepeat2.count2(str10));
		System.out.println("str11 " + str11 + " : " + CountRepeat2.count2(str11));
		System.out.println("str12 " + str12 + " : " + CountRepeat2.count2(str12));
		System.out.println("str13 " + str13 + " : " + CountRepeat2.count2(str13));
		System.out.println("str14 " + str14 + " : " + CountRepeat2.count2(str14));
		System.out.println("str15 " + str15 + " : " + CountRepeat2.count2(str15));
		System.out.println("str16 " + str16 + " : " + CountRepeat2.count2(str16));
		System.out.println("str17 " + str17 + " : " + CountRepeat2.count2(str17));
		System.out.println("str18 " + str18 + " : " + CountRepeat2.count2(str18));
	}

}
