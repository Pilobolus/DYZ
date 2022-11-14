package hw01;

public class PathPrint {

	public static void path(char[][] points){
		if(points == null)
			throw new NullPointerException("points is null");
		
		int[] colNums = new int[points.length];
		int[] pathNum = new int[]{1};
		
		pathRecur(points, colNums, 0, pathNum);
	}
	
	private static void pathRecur(char[][] points, int[] colNums, int rowNum, int[] pathNum){
		if(rowNum >= points.length){
			String str = pathNum[0] + ". ";
			
			for(int i=0; i<points.length; i++){
				
				if(i > 0)
					str += ", ";
				str += points[i][colNums[i]];
			}
			
			pathNum[0]++;
			
			System.out.println(str);
			return;
		}
		
		colNums[rowNum] = -1;
		for(int i=0; i<points[rowNum].length; i++){
			colNums[rowNum]++;
			pathRecur(points, colNums, rowNum+1, pathNum);
		}
		
		return;
	}
}
