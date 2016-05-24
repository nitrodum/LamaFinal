package GameWindow;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;


public class loadImageFrom {

	public static BufferedImage LoadImageFrom(Class<?> classFile, String path) {
		URL url = classFile.getResource(path);
		BufferedImage img = null;
		
		try{
			img = ImageIO.read(url);
		}catch(IOException e){
			e.printStackTrace();
			System.out.println("OUCH");
		}
		return img;
	}

}
