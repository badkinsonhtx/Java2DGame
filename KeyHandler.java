package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	
	public boolean upPressed, downPressed, leftPressed, rightPressed;
	
	// Debug
	boolean checkDrawTime = false;

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
		default:
			break; 
        }
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

}
