package proiectp3;	



import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MeniuPrincipal implements ActionListener{
private static JButton comanda;
private static JButton carti;
static JFrame frame = new JFrame("My First Swing Example");
public static void NewScreen3() {    
    
    frame.setSize(400, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
   
     
    JPanel panel = new JPanel();  
	panel.setBackground(new Color(0, 206, 209));

    frame.add(panel);
  
    placeComponents(panel);
    frame.setVisible(true);
}
private static void placeComponents(JPanel panel) {
	  panel.setLayout(null);
      JLabel titlu= new JLabel("MENIU PRICIPAL");
      titlu.setBounds(100,10,200,40);
      panel.add(titlu);
      
      comanda = new JButton("Comanda ");
      comanda.setBounds(50,100,100,30);
      comanda.addActionListener(new MeniuPrincipal());
    panel.add(comanda);
    
    carti = new JButton("Vizualizare oferte ");
    carti.setBounds(220,100,150,30);
    carti.addActionListener(new MeniuPrincipal());
    panel.add(carti);
    


}
@Override
public void actionPerformed(ActionEvent e) {
	
	if(e.getSource()==comanda) {
		frame.dispose();
	MeniuComanda2 nw5;
	nw5 = new MeniuComanda2();

	nw5.MC2();
}
	if(e.getSource()==carti) {
		frame.dispose();
	Vizualizare n;
	n = new Vizualizare();
	n.VZ();
	
	

}
}}
