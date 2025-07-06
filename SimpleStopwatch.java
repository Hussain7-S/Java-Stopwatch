import javax.swing.*;
import java.awt.event.*;
public class SimpleStopwatch {
    static int seconds = 0;
    static Timer timer;
    public static void main(String[] args) {
        // Create the main window
        JFrame frame = new JFrame("Stopwatch");
        frame.setSize(300, 200);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Time display label
        JLabel timeLabel = new JLabel("Time: 0 sec");
        timeLabel.setBounds(100, 20, 150, 30);
        frame.add(timeLabel);

        // Start button
        JButton startButton = new JButton("Start");
        startButton.setBounds(30, 70, 70, 30);
        frame.add(startButton);

        // Stop button
        JButton stopButton = new JButton("Stop");
        stopButton.setBounds(110, 70, 70, 30);
        frame.add(stopButton);

        // Reset button
        JButton resetButton = new JButton("Reset");
        resetButton.setBounds(190, 70, 70, 30);
        frame.add(resetButton);

        // Timer updates every 1 second (1000ms)
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                seconds++;
                timeLabel.setText("Time: " + seconds + " sec");
            }
        });

        // Start button logic
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timer.start();
            }
        });

        // Stop button logic
        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timer.stop();
            }
        });

        // Reset button logic
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timer.stop();
                seconds = 0;
                timeLabel.setText("Time: 0 sec");
            }
        });

        // Show the window
        frame.setVisible(true);
    }
}