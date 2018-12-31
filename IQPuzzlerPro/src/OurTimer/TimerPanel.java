package OurTimer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.LocalDateTime;

public class TimerPanel extends JPanel {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    public static LocalDateTime startTime;
    public static Duration pauseTime;
    public static boolean paused;
    public JLabel label;
    public static Timer timer;
    public static Duration timeLeft;
    public static Duration duration;
    public int difficultyLevel;

    private Scorer scoreMan;


    public TimerPanel(final int difficultyLevell) {
    	
    	difficultyLevel = difficultyLevell;
        timeLeft = Duration.ofSeconds(30);
    	
        if (difficultyLevel == 1) {
            duration = Duration.ofMinutes(5);

        } else if (difficultyLevel == 2) {
            duration = Duration.ofMinutes(4);

        } else if (difficultyLevel == 3) {
            duration = Duration.ofMinutes(3);

        } else if (difficultyLevel == 4) {
            duration = Duration.ofMinutes(2);

        } else if (difficultyLevel == 5) {
            duration = Duration.ofMinutes(1);

        } else if (difficultyLevel == 6) {
            duration = Duration.ofSeconds(30);
        }
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 2, 2, 2);
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        label = new JLabel("...");
        label.setFont(new Font("Gadugi", Font.BOLD, 24));
        add(label, gbc);

        final JButton btn = new JButton("Start");
        final JButton btnPause = new JButton("Pause");
        paused = false;

        btnPause.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pauseTime();
            }
        });
        btn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
            	startTime();
            }
        });
        //add(btn, gbc);
        //add(btnPause,gbc);

        timer = new Timer(500, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                LocalDateTime now = LocalDateTime.now();
                Duration runningTime = Duration.between(startTime, now);
                timeLeft = duration.minus(runningTime);
                if (timeLeft.isZero() || timeLeft.isNegative()) {
                    timeLeft = Duration.ZERO;
                    btn.doClick(); // Cheat
                    System.out.println("ASFDFASDFASDfljasdhgfjasdfjhsadkjhfas");
                    
                    cs319.main.window.getContentPane().removeAll();
                   
                    AllPanels.timeIsUp timeIsUp = new AllPanels.timeIsUp();  
                   
                    
                    cs319.main.window.add(timeIsUp);
                    cs319.main.window.revalidate();
                    cs319.main.window.repaint();
                    
                    
                }

                label.setText("Time: " + format(timeLeft));
            }
        });


    }

    public boolean hasEnded(){
        return paused;
    }
    
    public void startTime() {
    	
    	 if (timer.isRunning()) {
             timer.stop();
             startTime = null;
             paused = false;
             scoreMan = new Scorer(difficultyLevel, (int)(timeLeft.toMillis()/1000));
             label.setText("Congratulations!! You earned:  " + scoreMan.getFinalScore(20) + " points");
         } else {
             paused = false;
             startTime = LocalDateTime.now();
             timer.start();
         }
    	
    }
    
    public static void pauseTime() {
    	
    	if(timer.isRunning()){
            timer.stop();
            pauseTime = timeLeft;
            paused = true;
        }
        else{
            duration = pauseTime;
            startTime = LocalDateTime.now();
            timer.start();
            paused = false;
            pauseTime = null;
        }
    	
    }
    
    public void stoptime() {
    	
    }

    protected String format(Duration duration) {

        long seconds = duration.toMillis() / 1000;
        return String.format("%02ds", seconds);
    }

    public static long getTimeLeft(){
        return timeLeft.toMillis();
 
    }
    
    public static void setTimeLeft(long timee){
        duration = Duration.ofMillis(timee);
    }
    
}