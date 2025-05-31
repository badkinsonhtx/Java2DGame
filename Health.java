package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Health extends SuperObject {

	GamePanel gp;
	public Health(GamePanel gp) {
		this.gp = gp;
		name = "Heart";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/heart_full.png"));
			image2 = ImageIO.read(getClass().getResourceAsStream("/objects/heart_half.png"));
			image3 = ImageIO.read(getClass().getResourceAsStream("/objects/heart_blank.png"));
			uTool.scaleImage(image, gp.tileSize, gp.tileSize);
			uTool.scaleImage(image2, gp.tileSize, gp.tileSize);
			uTool.scaleImage(image3, gp.tileSize, gp.tileSize);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}