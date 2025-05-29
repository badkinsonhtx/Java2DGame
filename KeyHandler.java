package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	
	GamePanel gp;
	public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed;
	
	// Debug
	boolean checkDrawTime = false;
	
	public KeyHandler(GamePanel gp) {
		this.gp = gp;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		switch(code) {
		case KeyEvent.VK_UP:
			upPressed = true;
			break;
		case KeyEvent.VK_DOWN:
			downPressed = true;
			break;
		case KeyEvent.VK_LEFT:
			leftPressed = true;
			break;
		case KeyEvent.VK_RIGHT:
			rightPressed = true;
			break;
		case KeyEvent.VK_ESCAPE:
			if(gp.gameState == gp.playState) {
				gp.gameState = gp.pauseState;
			}else if(gp.gameState == gp.pauseState) {
				gp.gameState = gp.playState;
			}
			break;
		case KeyEvent.VK_ENTER:
			enterPressed = true;
		default:
			break;
		}
		
		// Debug
	    if(code == KeyEvent.VK_T) {
	    	if(checkDrawTime == false) {
	    		checkDrawTime = true;
	    	}else if(checkDrawTime == true) {
	    		checkDrawTime = false;
	    	}
	    }
	    if(gp.gameState == gp.dialogueState) {
	    	if(code == KeyEvent.VK_ENTER) {
	    		gp.gameState = gp.playState;
	    	}
	    }
	}

	@Override
	public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        switch(code) {
        case KeyEvent.VK_UP:
			upPressed = false;
			break;
		case KeyEvent.VK_DOWN:
			downPressed = false;
			break;
		case KeyEvent.VK_LEFT:
			leftPressed = false;
			break;
		case KeyEvent.VK_RIGHT:
			rightPressed = false;
			break;
		case KeyEvent.VK_ESCAPE:
			rightPressed = false;
			break;
		default:
			break; 
        }
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

}
