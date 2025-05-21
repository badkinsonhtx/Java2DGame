package main;

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
	
	double playTime, bestTime;
	DecimalFormat df = new DecimalFormat("#0.00");
	
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
		if(gp.gameState == gp.playState) {
			
		}
		if(gp.gameState == gp.pauseState) {
			drawPauseScreen();
		}
	}

	public void drawPauseScreen() {
		String text = "PAUSED";
        int x = getXforCenteredText(text);		
		int y = gp.screenHeight / 2 - 175;
		
		g2.drawString(text, x, y);
		
	}
	
	public int getXforCenteredText(String text) {
		int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = gp.screenWidth / 2 - length / 2;
		return x;
	}
}
