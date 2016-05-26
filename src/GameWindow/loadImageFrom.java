package GameWindow;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;


public class loadImageFrom {

	public static BufferedImage LoadImageFrom(Class<?> classFile, String path) {
		
		BufferedImage img = null;
		URL url = classFile.getResource(path);
		System.out.println(url);
		try{		
			img = ImageIO.read(url);
		}catch(IOException e){
			e.printStackTrace();
		}
		return img;
	}

}
