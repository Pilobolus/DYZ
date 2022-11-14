package tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

public class RequestInputStreamReader {

	public static String readInputStream(HttpServletRequest req) {
		try(InputStream is = req.getInputStream();
				InputStreamReader isr = new InputStreamReader(is, "utf-8");
				BufferedReader br = new BufferedReader(isr);) {
			StringBuilder sb = new StringBuilder();

			String buffer = "";
			while((buffer=br.readLine()) != null) {
				sb.append(buffer);
			}
			return sb.toString();
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		
		return null;
	}
}
