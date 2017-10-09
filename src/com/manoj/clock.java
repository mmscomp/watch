package com.manoj;

import java.awt.event.*;
import java.awt.*;
import java.time.LocalDateTime;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

final public class clock {

	JFrame f;
	JButton b;
	Watch watch;
	double s = LocalDateTime.now().getSecond();
	double m = LocalDateTime.now().getMinute();
	double h = LocalDateTime.now().getHour();
	private int x = 200;
	private int y = 200;
	private int r = 200;
	private int count = 0;

	public static void main(String... args) {
		// TODO Auto-generated method stub
		new clock().go();
     System.out.println(LocalDateTime.now());
	}
	
	private void go(){
     f = new JFrame("Clock");
     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     b = new JButton("Digital Watch");
     b.setBounds(250,50,100,50);
     f.add(b);
     watch = new Watch();
     f.getContentPane().add(BorderLayout.CENTER,watch);
     f.setVisible(true);
     f.setSize(600,600);
     moveIt();	
	}
class Watch extends JPanel{
	private static final long serialVersionUID = 1L;

	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		setBackground(Color.BLUE);
		setForeground(Color.RED);
		g.drawOval(x-25, y-25, 250, 250);
		g.drawOval(x,y,r,200);
		g.setColor(Color.BLACK);
		g.drawString("XII",x+100,y+15);
		g.drawString("III",x+175,y+100);
		g.drawString("VI",x+100,y+175);
		g.drawString("IX",x+15,y+100);
		g.setColor(Color.GREEN);
		g2.setStroke(new BasicStroke(3));
		g.drawLine(x+100, y+100,(int)( x+100+90*Math.sin(s*Math.PI/(30))), (int)(y+100-90*Math.cos(s*Math.PI/(30))));	
		g.setColor(Color.BLUE);
		g.drawLine(x+100, y+100,(int)( x+100+80*Math.sin(m*Math.PI/(30))), (int)(y+100-80*Math.cos(m*Math.PI/(30))));	
		g.setColor(Color.CYAN);
		g.drawLine(x+100, y+100,(int)( x+100+70*Math.sin((5*h+(m/12))*Math.PI/(30))), (int)(y+100-70*Math.cos((5*h+m/12)*Math.PI/(30))));	
		g.setColor(Color.BLACK);
		b.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent e){
			count++;
			System.out.println(count);
			   }
			   
			});
        if(count%2!=0)
		g.drawString(Integer.toString((int)h)+":"+String.format("%02d",((int)m))+":"+String.format("%02d",((int)s)), x+80, y+150);

	}
}

private void moveIt(){	
  while(true){
try{	  
	  Thread.sleep(1000);
	  s = LocalDateTime.now().getSecond();
	  m = LocalDateTime.now().getMinute();
	  h = LocalDateTime.now().getHour();
	  if (h>12) h = h-12;
  }
  catch(Exception e){
	  e.printStackTrace();
  }
  f.repaint();
  }
}
}
