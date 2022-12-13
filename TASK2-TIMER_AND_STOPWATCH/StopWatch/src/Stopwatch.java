import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// we implemented the ActionListener interface
public class Stopwatch implements ActionListener{

// we declared few global variables outside constructor
 JFrame frame = new JFrame("STOP_WATCH");
 JButton startButton = new JButton("START");
 JButton resetButton = new JButton("RESET");
 JLabel timeLabel = new JLabel();
 //elapsed-time is used to hold the time after stop_watch starts 
 int elapsedTime = 0;
 int seconds =0;
 int minutes =0;
 int hours =0;
 // started: used to determine whether stop_watch is started or not
 boolean started = false;
 String seconds_string = String.format("%02d", seconds);
 String minutes_string = String.format("%02d", minutes);
 String hours_string = String.format("%02d", hours);
 
 //we created a timer out here for every 1sec
 Timer timer = new Timer(1000, new ActionListener() {
  public void actionPerformed(ActionEvent e) {
   // increased the elapsed time by 1sec
   elapsedTime=elapsedTime+1000;
   hours = (elapsedTime/3600000);
   minutes = (elapsedTime/60000) % 60;
   seconds = (elapsedTime/1000) % 60;
   seconds_string = String.format("%02d", seconds);
   minutes_string = String.format("%02d", minutes);
   hours_string = String.format("%02d", hours);
   timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
  }
 }
 );
 
 // we included the constructor Stop-watch()
 Stopwatch(){
  
 //we add time label to hold hours, minutes & seconds
  timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
  timeLabel.setBounds(100,100,200,100);
 //we set font style,create border & setting the alignment
  timeLabel.setFont(new Font("Verdana",Font.PLAIN,40));
  timeLabel.setBorder(BorderFactory.createBevelBorder(1));
  timeLabel.setOpaque(true);
  timeLabel.setHorizontalAlignment(JTextField.CENTER);
  
  startButton.setBounds(100,200,100,50);
  startButton.setFont(new Font("Verdana",Font.PLAIN,15));
  startButton.setFocusable(false);
  startButton.addActionListener(this);
  
  resetButton.setBounds(200,200,100,50);
  resetButton.setFont(new Font("Verdana",Font.PLAIN,15));
  resetButton.setFocusable(false);
  resetButton.addActionListener(this);
  
 //we are adding frame for start, reset button and time label respectively
  frame.add(startButton);
  frame.add(resetButton);
  frame.add(timeLabel);
  
//adding frames inside constructor
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setSize(450,450); //size of the frame
  frame.setLayout(null);
  frame.setVisible(true);
 }
 
 @Override
 public void actionPerformed(ActionEvent e) {
  if(e.getSource()==startButton) {
   
   if(started==false) {
    started=true;
    startButton.setText("STOP");
    start();
   }
   else {
    started=false;
    //start button can be used as stop button
    startButton.setText("START");
    stop();
   }
  }
  if(e.getSource()==resetButton) {
   started=false;
   startButton.setText("START");
   reset();
  }
 }

 // we created 3 methods: start(),stop(), reset() for framework
 //stop-watch starts on clicking the start button
 void start() {
  timer.start();
 }
 
 //stop-watch stops with by toggling the start button
 void stop() {
  timer.stop();
 }
 
 //stop_watch resets on clicking the reset button 
 void reset() {
  timer.stop();
  elapsedTime=0;
  seconds =0;
  minutes=0;
  hours=0;
  seconds_string = String.format("%02d", seconds);
  minutes_string = String.format("%02d", minutes);
  hours_string = String.format("%02d", hours);       
  timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
 }
}