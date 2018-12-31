/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs319;

import AllPanels.mainMenu;
import com.bulenkov.darcula.DarculaLaf;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.sound.sampled.FloatControl;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicLookAndFeel;
import javazoom.jl.player.Player;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

/**
 *
 * @author skerd
 */
public class main {

    /**
     * @param args the command line arguments
     */
        
    public static JFrame window;
    public static AudioPlayer MGP;
    public static InputStream bgMusic;
    
    public static void main(String[] args) {
       
        try {
            
           BasicLookAndFeel darcula = new DarculaLaf();
           UIManager.setLookAndFeel(darcula);

           //UIManager.setLookAndFeel( "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        }
        catch (Exception ex) {
        
        }
        
        KeyListener keyss = new KeyListener(){

            public void keyTyped(KeyEvent e) {
               
            }


            public void keyPressed(KeyEvent e) {
              
            }


            public void keyReleased(KeyEvent e) {
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            }
            
            
        };
        
        
        mainMenu mainMenuPanel = new mainMenu();
        
        window = new JFrame("IQ Puzzler Pro");
        //window.addKeyListener(keyss);
        //window.requestFocus();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //window.setUndecorated(true);
        
        window.setLayout(new BorderLayout());
        window.add(mainMenuPanel, BorderLayout.CENTER);
        
        window.pack();
        window.setVisible(true);
        
        
        MGP = AudioPlayer.player;
        ContinuousAudioDataStream loop = null;
        try{
            InputStream bgMusic = new FileInputStream("Music/bfg.wav");

            //AudioPlayer.player.start(bgMusic);

            
        }catch(IOException e){
            e.printStackTrace();
        }

        MGP.start(loop);
        
       

        
    }
    
}
