package hw02;

import java.util.LinkedList;
import java.util.ListIterator;

public class CountRepeat2 {
	
	public static int count1(String str) {
		if(str == null)
			throw new NullPointerException("string is null");
		if(str.length() == 0)
			return 1;
		
		LinkedList<Character> list = new LinkedList<>();
		list.add(str.charAt(0));
		int count = 1;
		boolean isRepeat = false;
		ListIterator<Character> it = null;
		LinkedList<Character> supportList = new LinkedList<>();
		
		for(int i=1; i<str.length(); i++) {
			char ch = str.charAt(i);
			
			if(!isRepeat && list.peek()!=ch && count==1)
				list.add(ch);
			else if(!isRepeat && list.peek()!=ch)
				return 1;
			else if(!isRepeat) {
				
				if(count == 1)
					supportList.add(ch);
				
				isRepeat = true;
				it = list.listIterator();
				if(it.hasNext())
					it.next();
				
				if(!it.hasNext()) {
					isRepeat = false;
					count++;
				}
			}else {
				if(it.hasNext()) {
					if(count == 1)
						supportList.add(ch);
					char tempCh = it.next();
					
					if(tempCh!=ch && count==1) {
						list.addAll(supportList);
						supportList = new LinkedList<>();
						isRepeat = false;
						continue;
					}else if(tempCh != ch)
						return 1;
						
					
					if(!it.hasNext()) {
						isRepeat = false;
						count++;
					}
					continue;
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
		int len = str.length();
		LinkedList<Character> list = new LinkedList<>();
		list.add(str.charAt(0));
		
		
		int index = 1;
		char ch = ' ';
		LinkedList supportList = null;
		
		outer : while(true) {
			while(index<len && (ch=str.charAt(index))!=list.peek()) {
				list.add(ch);
				index++;
			}
			
			if(index >= len)
				return 1;
			
			supportList = new LinkedList<>();
			
			ListIterator<Character> it = null;
			while(true) {
				it = list.listIterator();
				while(index<len && it.hasNext() && (ch=str.charAt(index))==it.next()) {
					if(count == 1)
						supportList.add(ch);
					index++;
					
					if(!it.hasNext())
						count++;
				}
				
				if(index<len && it.hasNext()) {
					if(count > 1)
						return 1;
					supportList.add(ch);
					list.addAll(supportList);
					index++;
					continue outer;
				}
				if(index < len)
					continue;
				if(it.hasNext())
					return 1;
				
				break;
			}
			
			break;
		}
		
		return count;
	}
}
