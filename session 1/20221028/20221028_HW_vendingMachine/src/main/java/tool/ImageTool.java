package tool;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.Part;

public class ImageTool {
	public static void uploadImage(Part image, String imageDir, String imageName) {
		try (InputStream is = image.getInputStream();
				BufferedInputStream bis = new BufferedInputStream(is);
				OutputStream os = new FileOutputStream(imageDir + File.separator + imageName);
				BufferedOutputStream bos = new BufferedOutputStream(os);){
			byte[] buffer = new byte[100];
			int len = -1;
			
			while((len=bis.read(buffer)) != -1) {
				bos.write(buffer, 0, len);
			}
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}
}
