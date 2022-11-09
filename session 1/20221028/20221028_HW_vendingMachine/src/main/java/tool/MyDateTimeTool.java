package tool;

import java.sql.Timestamp;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyDateTimeTool {

	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");
	
	public static String now() {
		return LocalDateTime.now().format(formatter);
	}
	
	public static Timestamp parse(String dateTimeStr) {
		return Timestamp.valueOf(LocalDateTime.parse(dateTimeStr, formatter));
	}
}
