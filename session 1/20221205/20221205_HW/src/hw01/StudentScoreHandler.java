package hw01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import hw01.model.Student;
import hw01.service.StudentService;
import hw01.util.IOTool;

public class StudentScoreHandler {

	public static boolean handleStudentScore(String srcPathName, String targetPathName) {
		List<String> studentStrings = IOTool.read(srcPathName);
		List<Student> students = StudentService.stringToStudent(studentStrings);
		Map<Integer, List<Student>> studentGroups = StudentService.getStudentAfterGrouping(students);
		List<String> resultStrings = StudentService.studentGroupsToString(studentGroups, studentStrings.get(0), new StringBuilder());
		List<String> outputStrings = new ArrayList<>();
		outputStrings.add(studentStrings.get(0) + ",總分,平均");
		outputStrings.addAll(resultStrings);
		return IOTool.write(targetPathName, outputStrings);
	}
	
	
}
