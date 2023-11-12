package proiectp3;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class principalgui<IamgeIcon> implements ActionListener{
private static JButton creare;
private static JButton logare;
private  IamgeIcon imagine;
static JFrame frame = new JFrame("My First Swing Example");
 
public static void main(String[] args) {    
    frame.setSize(400, 200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
   
     
    JPanel panel = new JPanel();    
	panel.setBackground(new Color(0, 206, 209));

    frame.add(panel);
  
    placeComponents(panel);
    frame.setVisible(true);
    //ImageIcon i= new imagine();
}
public principalgui() {

}
private static void placeComponents(JPanel panel) {
		
	  panel.setLayout(null);
      JLabel titlu= new JLabel("Bine Ati venit la libraria noastra!");
      titlu.setBounds(100,10,200,40);
      panel.add(titlu);
      
	creare = new JButton("Creare ");
	creare.setBounds(50,100,80,25);
	creare.addActionListener(new principalgui());
    panel.add(creare);
    
	logare = new JButton("Logare ");
	logare.setBounds(250,100,80,25);
	logare.addActionListener(new principalgui());
    panel.add(logare);
    
	try {
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		ImageIcon imagine = new ImageIcon("flo.PNG");
		JLabel label=new  JLabel();
		label.setIcon(imagine);
		panel.add(label);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

}

	


@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==creare) {
		frame.dispose();
	gui incercare =new gui();
	incercare.NewScreen();
	}
	if(e.getSource()==logare) {
		frame.dispose();
		logaregui nw=new logaregui();
		nw.NewScreen2();
	}
}
}
	

