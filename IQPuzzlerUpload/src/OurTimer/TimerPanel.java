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
	public LocalDateTime startTime;
    public Duration pauseTime;
    public boolean paused;
    public JLabel label;
    public Timer timer;
    public Duration timeLeft;
    public Duration duration;

    private Scorer scoreMan;


    public TimerPanel(final int difficultyLevel) {
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
        add(label, gbc);

        final JButton btn = new JButton("Start");
        final JButton btnPause = new JButton("Pause");
        paused = false;

        btnPause.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(timer.isRunning()){
                    timer.stop();
                    pauseTime = timeLeft;
                    paused = true;
                    btnPause.setText("Resume");
                }
                else{
                    duration = pauseTime;
                    startTime = LocalDateTime.now();
                    timer.start();
                    paused = false;
                    pauseTime = null;
                    btnPause.setText("Pause");
                }
            }
        });
        btn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (timer.isRunning()) {
                    timer.stop();
                    startTime = null;
                    btn.setText("Start");
                    paused = false;
                    scoreMan = new Scorer(difficultyLevel, (int)(timeLeft.toMillis()/1000));
                    label.setText("The final score is " + scoreMan.getFinalScore(20));
                } else {
                    paused = false;
                    startTime = LocalDateTime.now();
                    timer.start();
                    btn.setText("Stop");
                }
            }
        });
        add(btn, gbc);
        add(btnPause,gbc);

        timer = new Timer(500, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                LocalDateTime now = LocalDateTime.now();
                Duration runningTime = Duration.between(startTime, now);
                timeLeft = duration.minus(runningTime);
                if (timeLeft.isZero() || timeLeft.isNegative()) {
                    timeLeft = Duration.ZERO;
                    btn.doClick(); // Cheat
                }

                label.setText(format(timeLeft));
            }
        });


    }


    public boolean hasEnded(){
        return paused;
    }

    protected String format(Duration duration) {

        long seconds = duration.toMillis() / 1000;
        return String.format("%02ds", seconds);
    }

}