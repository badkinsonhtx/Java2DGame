package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;
import main.UtilityTool;

public class Player extends Entity {

	KeyHandler keyH;
	
	public final int screenX;
	public final int screenY;
	//public int hasKey = 0;
	int standCounter = 0;
	boolean moving = false;
	int pixelCounter = 0;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		super(gp);
		this.keyH = keyH;
		
		screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
		screenY = gp.screenHeight / 2 - (gp.tileSize / 2);
		
		solidArea = new Rectangle();
		solidArea.x = 1;
		solidArea.y = 1;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 46;
		solidArea.height = 46;
		
		setDefaultValues();
		getPlayerImage();
	}
	
	public void setDefaultValues() {
		worldX = gp.tileSize * 23;
		worldY = gp.tileSize * 21;
		speed = 4;
		direction = "down";
	}
	
	public void getPlayerImage() {
		up1 = setUp("/player/boy_up_1");
		up2 = setUp("/player/boy_up_2");
		down1 = setUp("/player/boy_down_1");
		down2 = setUp("/player/boy_down_2");
		left1 = setUp("/player/boy_left_1");
		left2 = setUp("/player/boy_left_2");
		right1 = setUp("/player/boy_right_1");
		right2 = setUp("/player/boy_right_2");
	}
	
	public void update() {
        if(moving == false) {
            if(keyH.upPressed == true || keyH.downPressed == true || 
    	      keyH.leftPressed == true || keyH.rightPressed == true) {
    	        if(keyH.upPressed == true) {
    	           direction = "up";
                }else if(keyH.downPressed == true) {
    	            direction = "down";
    	        }else if(keyH.leftPressed == true) {
    	            direction = "left";
    	        }else if(keyH.rightPressed == true) {
    	            direction = "right";	
    	        }
    	        moving = true;
    	        		
    	        // Check Tile Collision
    	        collisionOn = false;
    	        gp.cc.checkTile(this);
    	        		
    	        // Check Object Collision
    	        int objIndex = gp.cc.checkObject(this, true);
    	        pickUpObject(objIndex);
            }else {
			    standCounter++;
			   	if(standCounter == 20) {
			   	    spriteNum = 1;
			   		standCounter = 0;
			   	}
			}	
    	}
        if(moving == true) {
            // If Collision Is False, Player Can Move
        	if(collisionOn == false) {
        		switch(direction) {
        			case "up":
        				worldY -= speed;
        				break;
        			case "down":
        				worldY += speed;
        				break;
        			case "left":
        				worldX -= speed;
        				break;
        			case "right":
        				worldX += speed;
        				break;
        			default:
        				break;	
        		}
        	}
        	spriteCounter++;
        	if(spriteCounter > 12) {
        		if(spriteNum == 1) {
        			spriteNum = 2;
        		}else if(spriteNum == 2) {
        			spriteNum = 1;
        		}
        		spriteCounter = 0;
        	}
        	pixelCounter += speed;
        	if(pixelCounter == 48) {
        		moving = false;
        		pixelCounter = 0;
        	}
        }
    }
		
	public void pickUpObject(int i) {
		if(i != 999) {
			/*String objectName = gp.obj[i].name;
			switch(objectName) {
			case "Key":
				gp.playSE(1);
				hasKey++;
				gp.obj[i] = null;
				gp.ui.showMessage("You Got A Key");
				break;
			case "Door":
				if(hasKey > 0) {
					gp.playSE(3);
					gp.obj[i] = null;
					hasKey--;
					gp.ui.showMessage("You Opened The Door");
				}else {
					gp.ui.showMessage("You Need A Key");
				}
				System.out.println("Keys: " + hasKey);
				break;
			case "Boots":
				gp.playSE(2);
    			System.out.println(speed);
    			speed += 4;
    			System.out.println(speed);
    			gp.obj[i] = null;
    			gp.ui.showMessage("Speed Up");
    			Thread t1 = new Thread(new Runnable() {
    			    @Override
    			    public void run() {
    			    	bootsPowerUp();
    			    }//int length = (int)g2.getFontMetrics().getStringBounds(text,  g2).getWidth();
    			});  
    			t1.start();
    			System.out.println(t1.isAlive());
    			t1 = null;
				break;
			case "Chest":
				gp.ui.gameOver = true;
				gp.stopMusic();
				gp.playSE(4);
				break;
			default:
				break;
			}*/
			
		}
	}
	
	public void draw(Graphics2D g2) {
		BufferedImage image = null;
		switch(direction) {
		case "up":
			if(spriteNum == 1) {
				image = up1;
			}
			if(spriteNum == 2) {
				image = up2;
			}
			break;
		case "down":
			if(spriteNum == 1) {
				image = down1;
			}
			if(spriteNum == 2) {
				image = down2;
			}
			break;
		case "left":
			if(spriteNum == 1) {
				image = left1;
			}
			if(spriteNum == 2) {
				image = left2;
			}
			break;
		case "right":
			if(spriteNum == 1) {
				image = right1;
			}
			if(spriteNum == 2) {
				image = right2;
			}
			break;
		default:
			break;
		}
		g2.drawImage(image, screenX, screenY, null);
		// Debug
		//g2.setColor(Color.red);
		//g2.drawRect(screenX + solidArea.x, screenY + solidArea.y, solidArea.width, solidArea.height);
	}
	
	/*private void bootsPowerUp() {
    	long lastTime = System.currentTimeMillis();
    	long timer = 0;
        while(timer <= 30000) {
        	long currentTime = System.currentTimeMillis();
        	timer += (currentTime - lastTime);
			lastTime = currentTime;
        }
        speed -= 4;
        System.out.println(speed);
    
    }*/
	
}
