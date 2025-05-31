package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

import object.Key;

public class UI {

	GamePanel gp;
	Graphics2D g2;
	Font arial_40, arial_80;
	
	//BufferedImage keyImage;
	public boolean messageOn = false;
	public String message = "";
	int messageCounter;
	public boolean gameOver = false;
	public String currentDialogue = "";
	public int commandNum = 0;
	
	/*double playTime, bestTime;
	DecimalFormat df = new DecimalFormat("#0.00");*/
	
	public UI(GamePanel gp) {
		this.gp = gp;
		arial_40 = new Font("Arial", Font.PLAIN, 40);
		arial_80 = new Font("Arial", Font.BOLD, 80);
		//Key key = new Key(gp);
		//keyImage = key.image;
	}
	
	public void showMessage(String text) {
		message = text;
		messageOn = true;
	}
	
	public void draw(Graphics2D g2) {
		this.g2 = g2;
		g2.setFont(arial_40);
		g2.setColor(Color.white);
		
		// Title State 
		if(gp.gameState == gp.titleState) {
			drawTitleScreen();
		}
		// Play State
		if(gp.gameState == gp.playState) {
			
		}
		// Pause State
		if(gp.gameState == gp.pauseState) {
			drawPauseScreen();
		}
		// Dialogue State
		if(gp.gameState == gp.dialogueState) {
			drawDialogueScreen();
		}
	}
	
	public void drawTitleScreen() {
		g2.setColor(new Color(0, 0, 0));
		g2.fillRect(0,  0,  gp.screenWidth, gp.screenHeight);
		// Title Name
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 96F));
		
		currentDialogue = "Blue Boy";	
		int x = getXForCenteredText(currentDialogue);
		int y = gp.tileSize * 3;
		
		// Shadow
		g2.setColor(Color.gray);
		g2.drawString(currentDialogue, x + 5, y + 5);
		
		g2.setColor(Color.white);
		g2.drawString(currentDialogue, x, y);
		
		currentDialogue = "Adventure";
		x = getXForCenteredText(currentDialogue);
		y = gp.tileSize * 5;
		g2.setColor(Color.gray);
		g2.drawString(currentDialogue, x + 5, y + 5);
		
		g2.setColor(Color.white);
		g2.drawString(currentDialogue, x, y);
		
		// Blue Boy Image
		x = gp.screenWidth / 2 - (gp.tileSize * 2) / 2;
		y += gp.tileSize * 1;
		g2.drawImage(gp.player.down1, x, y, gp.tileSize * 2, gp.tileSize * 2, null);
		
		// Menu
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 48F));
		
		currentDialogue = "New Game";
		x = getXForCenteredText(currentDialogue);
		y += gp.tileSize * 3;
		g2.drawString(currentDialogue, x, y);
		
		if(commandNum == 0) {
			g2.drawString(">", x - gp.tileSize, y);
		}
		currentDialogue = "Load Game";
		x = getXForCenteredText(currentDialogue);
		y += gp.tileSize;
		g2.drawString(currentDialogue, x, y);
		
		if(commandNum == 1) {
			g2.drawString(">", x - gp.tileSize, y);
		}
		currentDialogue = "Exit";
		x = getXForCenteredText(currentDialogue);
		y += gp.tileSize;
		g2.drawString(currentDialogue, x, y);
		
		if(commandNum == 2) {
			g2.drawString(">", x - gp.tileSize, y);
		}
	}

	public void drawPauseScreen() {
		String text = "PAUSED";
        int x = getXForCenteredText(text);		
		int y = gp.screenHeight / 2 - 175;
		g2.drawString(text, x, y);
		
	}
	
	public void drawDialogueScreen() {
		// Window
		int x = gp.tileSize * 2;
		int y = gp.tileSize / 2;
		int width = gp.screenWidth - (gp.tileSize * 4);
		int height = gp.tileSize * 4;
		drawSubWindow(x, y, width, height);
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 32F));
		x += gp.tileSize;
		y += gp.tileSize;
		for(String line : currentDialogue.split("\n")) {
			g2.drawString(line, x, y);
			y += 40;
		}
	}
	
	public void drawSubWindow(int x, int y, int width, int height) {
		Color c = new Color(0, 0, 0, 220);
		g2.setColor(c);
		g2.fillRoundRect(x, y, width, height, 35, 35);
		c = new Color(255, 255, 255);
		g2.setColor(c);
		g2.setStroke(new BasicStroke(5));
		g2.drawRoundRect(x + 5, y + 5, width - 10, height -10, 25, 25);
	}
 	
	public int getXForCenteredText(String text) {
		int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = gp.screenWidth / 2 - length / 2;
		return x;
	}
}
