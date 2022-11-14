package hw03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class IOFileHandler {
	
	public static List<String> readFile(String pathName) {

		ArrayList<String> lines = new ArrayList<String>();
		File file = new File(pathName);
		
		try (InputStream is = new FileInputStream(file);
				BufferedInputStream bis = new BufferedInputStream(is);
				InputStreamReader isr = new InputStreamReader(bis);){
			
			int data = -1;
			
			boolean newLine = false;
			StringBuilder sb = new StringBuilder();
			while((data=isr.read()) != -1) {
				char ch = (char)data;
				
				if(!newLine) {
					
					if(ch==' ' || data==13) {
					}else if(data == 10) {
						
						newLine = true;
						if(sb.length() > 0) {
							lines.add(sb.toString());
							sb.delete(0, sb.length());
						}
						
						

					}else {
						sb.append(ch);
					}
					
				}else {
					newLine = false;
					sb.append(ch);
				}
			}
			
			if(sb.length() > 0)
				lines.add(sb.toString());
			
		}catch(IOException ex) {
			System.out.println(ex);
		}
		
		
		return lines;
	}
	
	public static void writeFile(List<String> lines, String pathName) {
		File file = new File(pathName);
		
		try (FileOutputStream fo = new FileOutputStream(file);
				BufferedOutputStream bos = new BufferedOutputStream(fo);
				OutputStreamWriter osw = new OutputStreamWriter(bos);){
			
			for(int i=0; i<lines.size(); i++) {
				
				osw.write(lines.get(i) + '\n');
				
			}
			
		}catch(IOException ex) {
			System.out.println(ex);
		}
	}
}
