package hw01;

public class Jump {

	public static int jump(String[][] map){
		int rowLen = map.length;
		int colLen = map[rowLen-1].length;
		
		int ans = 0;
		int lastNum = 0;
		for(int i=0; i<colLen; i++){
			for(int j=rowLen-1; j>=0; j--){
				if(map[j][i].equals("▇")){
					int num = ((rowLen-1-j)- lastNum);
					if(num > 0)
						ans += num;
					lastNum = rowLen-1-j;
					break;
				}else if(map[j][i].equals("╳")){
					break;
				}
			}
		}
		
		return ans;
		
	}
}
