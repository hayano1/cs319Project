package Mechanics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import UI.GuiScreen;
import UI.LoadGamePanel;
import UI.MainMenuPanel;
import UI.creditsPanel;
import UI.inGameOptions;
import UI.newGamePanel;
import UI.optionsPanel;
import UI.pausePanel;
import UI.play2DPanel;
import UI.play3DPanel;
import UI.playPanel;
import UI.playStoryPanel;


public class Game extends JPanel implements Runnable, MouseListener, MouseMotionListener, KeyListener{

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 630;
	public static final Font main = new Font("VAG ROUNDED", Font.BOLD, 28);
	private Thread game;
	private boolean running;

	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

	private GuiScreen screen;
	
	public Game() {
		
		setFocusable(true);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
		
		
		screen = GuiScreen.getInstance();
		screen.add("Menu", new MainMenuPanel());
		screen.add("newGamePanel", new newGamePanel());
		screen.add("playPanel", new playPanel());
		screen.add("loadGamePanel", new LoadGamePanel());
		screen.add("playStoryPanel", new playStoryPanel());
		screen.add("play2DPanel", new play2DPanel());
		screen.add("play3DPanel", new play3DPanel());
		screen.add("optionsPanel", new optionsPanel());
		screen.add("creditsPanel", new creditsPanel());
		screen.add("inGameOptionsPanel", new inGameOptions());
		screen.add("pausePanel", new pausePanel());
		
		screen.setCurrentPanel("Menu");
	}
	
	private void update() {
		screen.update();
	}

	private void render() {
		Graphics2D g = (Graphics2D) image.getGraphics();
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		screen.render(g);
		g.dispose();

		Graphics2D g2d = (Graphics2D) getGraphics();
		g2d.drawImage(image, 0, 0, null);
		g2d.dispose();
	}

	public void run() {
		@SuppressWarnings("unused")
		int fps = 0, updates = 0;
		long fpsTimer = System.currentTimeMillis();
		double nsPerUpdate = 1000000000.0 / 60;

		// last update time in nanoseconds
		double then = System.nanoTime();
		double unprocessed = 0;

		while (running) {

			boolean shouldRender = false;

			double now = System.nanoTime();
			unprocessed += (now - then) / nsPerUpdate;
			then = now;

			// Update queue
			while (unprocessed >= 1) {

				// update
				updates++;
				update();
				unprocessed--;
				shouldRender = true;
			}

			// Render
			if (shouldRender) {
				fps++;
				render();
				shouldRender = false;
			}
			else {
				try {
					Thread.sleep(1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			// FPS timer
			if (System.currentTimeMillis() - fpsTimer > 1000) {
				fps = 0;
				updates = 0;
				fpsTimer += 1000;
			}
		}
	}

	public synchronized void start() {
		if (running) return;
		running = true;
		game = new Thread(this, "game");
		game.start();
	}

	public synchronized void stop() {
		if (!running) return;
		running = false;
		System.exit(0);
	}


	public void mouseClicked(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
		screen.mousePressed(e);
	}

	public void mouseReleased(MouseEvent e) {
		screen.mouseReleased(e);
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseDragged(MouseEvent e) {
		screen.mouseDragged(e);
	}

	public void mouseMoved(MouseEvent e) {
		screen.mouseMoved(e);
	}
	
	public void keyPressed(KeyEvent e) {
		if(screen.getCurrentPanel()== "play2DPanel"){
			Keys.keyPressed(e);
			screen.setCurrentPanel("pausePanel");
		}else if(screen.getCurrentPanel()== "pausePanel"){
			Keys.keyPressed(e);
			screen.setCurrentPanel("play2DPanel");
		}else{
			
		}

		
	}

	public void keyReleased(KeyEvent e) {
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
