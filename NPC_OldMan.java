package entity;

import java.util.Random;

import main.GamePanel;

public class NPC_OldMan extends Entity {

	public NPC_OldMan(GamePanel gp) {
		super(gp);
		direction = "down";
		speed = 1;
		getImage();
		setDialogue();
	}
	
	public void getImage() {
		up1 = setUp("/npc/oldman_up_1");
		up2 = setUp("/npc/oldman_up_2");
		down1 = setUp("/npc/oldman_down_1");
		down2 = setUp("/npc/oldman_down_2");
		left1 = setUp("/npc/oldman_left_1");
		left2 = setUp("/npc/oldman_left_2");
		right1 = setUp("/npc/oldman_right_1");
		right2 = setUp("/npc/oldman_right_2");
	}
	
	public void setDialogue() {
		dialogues[0] = "Hello, young man.";
		dialogues[1] = "So you've come to this island to \nfind the treasure?";
		dialogues[2] = "I used to be a great wizard but \nnow... \nI'm a bit too old for taking an \nadventure.";
		dialogues[3] = "Well, good luck to you!";
		dialogues[4] = "";
		
	}
	
	public void setAction() {
		actionLockCounter++;
		if(actionLockCounter == 120) {
			Random random = new Random();	
		    int i = random.nextInt(100) + 1;
		    if(i <= 25) {
		    	direction = "up";
		    }
		    if(i > 25 && i <= 50) {
		    	direction = "down";
		    }
		    if(i > 50 && i <= 75) {
		    	direction = "left";
		    }
		    if(i > 75 && i <= 100) {
		    	direction = "right";
		    }
		    actionLockCounter = 0;
		}
	}
	
	public void speak() {
		super.speak();
	}
}
