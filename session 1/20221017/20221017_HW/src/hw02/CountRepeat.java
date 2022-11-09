package hw02;

import java.util.LinkedList;
import java.util.ListIterator;

public class CountRepeat {
	public static int count1(String str) {
		if(str == null)
			throw new NullPointerException("string is null");
		if(str.length() == 0)
			return 1;
		
		int count = 1;
		LinkedList<Character> list = new LinkedList<>();
		list.add(str.charAt(0));
		ListIterator<Character> it = null;
		boolean isRepeat = false;
		
		for(int i=1; i<str.length(); i++) {
			char ch = str.charAt(i);
			
			if(!isRepeat && list.peek()!=ch && count==1)// 第一組
				list.add(ch);
			else if(!isRepeat && list.peek()!=ch)// 不是第一組但錯了
				return 1;
			else if(!isRepeat) {// 每一組的第一個
				isRepeat = true;
				it = list.listIterator();
				if(it.hasNext())
					it.next();
				
				if(!it.hasNext()) {
					isRepeat = false;
					count++;
				}
			}else {// 每一組的其他
				if(it.hasNext()) {
					char tempCh = it.next();
					
					if(tempCh != ch)
						return 1;
					
					if(!it.hasNext()) {
						isRepeat = false;
						count++;
					}
				}
			}
		}
		
		if(it!=null && it.hasNext())
			return 1;
		
		return count;
	}
	
	
	public static int count2(String str) {
		if(str == null)
			throw new NullPointerException("string is null");
		if(str.length()==0 || str.length()==1)
			return 1;
		
		int count = 1;
		LinkedList<Character> list = new LinkedList<>();
		list.add(str.charAt(0));
		
		int index = 1;
		while(index<str.length() && str.charAt(index)!=list.peek()) {
			list.add(str.charAt(index));
			index++;
		}
		
		while(index < str.length()) {
			ListIterator<Character> it = list.listIterator();
			
			while(index<str.length() && it.hasNext()) {
				if(str.charAt(index) != it.next())
					return 1;
				
				index++;
			}
			if(it.hasNext())
				return 1;
			
			count++;
		}
		return count;
	}
}
