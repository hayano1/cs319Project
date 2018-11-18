package Mechanics;

import java.awt.event.KeyEvent;

public class Keys {

	public static boolean[] pressed = new boolean[256];
	public static boolean[] prev = new boolean[256];
	
	public static void update(){
		
		}
	
	
	public static void keyPressed(KeyEvent e){
		
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.out.println("escape");
         
        }
		
//		int key = e.getKeyCode();
//		System.out.println("hi");
	}
	
	public static void keyReleased(KeyEvent e){
		pressed[e.getKeyCode()] = false;
	}
	
}