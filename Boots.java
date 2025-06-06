package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Boots extends SuperObject {

	GamePanel gp;
	public Boots(GamePanel gp) {
		this.gp = gp;
		name = "Boots";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/boots.png"));
			uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
