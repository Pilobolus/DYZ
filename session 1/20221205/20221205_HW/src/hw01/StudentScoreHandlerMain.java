package hw01;


public class StudentScoreHandlerMain {

	public static void main(String[] args) {
		
		String srcPathName = "StudentsScoreData.csv";
		String srcPathName1 = "StudentsScoreData1.csv";
		String srcPathName2 = "StudentsScoreData2.csv";
		String targetPathName = "result.csv";
		
		boolean b = StudentScoreHandler.handleStudentScore(srcPathName, targetPathName);
		
		System.out.println(b ? "success" : "fail");
	}

}
