package UI;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

class MyThread extends Thread {
	// Initially setting the flag as true
	File file = new File("bg.wav");
	Clip clip = null;
	private volatile boolean flag = true;

	// This method will set flag as false

	public void stopRunning() {
		flag = false;
		clip.stop();
		clip= null;
	}

	@Override
	public void run() {

		try {
			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(file));
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}catch (IOException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// This will make thread continue to run until flag becomes false
		clip.start();
		while (flag) {
			System.out.println("I am running....");
		}


		System.out.println("Stopped Running....");
	}
}