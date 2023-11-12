package proiectp3;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField; 

public class gui implements ActionListener{

	    private static JLabel nume;
	    private static JTextField numeText;
	    private static JLabel cnp;
	    private static JPasswordField cnpText;
	    private static JLabel adresa;
	    private static JTextField adresaText;
	    private static JLabel varsta;
	    private static JTextField varstaText;
	    private static JButton button;
	    private static JButton logare;
	    private static JLabel succes;
	    List<Legitimatie> ListaLegitimatie=new ArrayList<>();
	static JFrame frame = new JFrame("My First Swing Example");
	   
    public static void NewScreen() {    
        
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
        JLabel titlu= new JLabel("Legitimatie");
        titlu.setBounds(150,50,100,40);
        panel.add(titlu);
        
         nume = new JLabel("Nume");
        nume.setBounds(10,110,80,25);
        panel.add(nume);
        
        
         numeText = new JTextField(20);
        numeText.setBounds(100,110,165,25);
        panel.add(numeText);

         adresa = new JLabel("Adresa");
        adresa.setBounds(10,190,80,25);
        panel.add(adresa);
        
         adresaText = new JTextField(20);
        adresaText.setBounds(100,190,165,25);
        panel.add(adresaText);
        
         cnp = new JLabel("CNP");
        cnp.setBounds(10,150,80,25);
        panel.add(cnp);

        cnpText = new JPasswordField(20);
        cnpText.setBounds(100,150,165,25);
        panel.add(cnpText);
        
         varsta = new JLabel("Varsta");
        varsta.setBounds(10,230,80,25);
        panel.add(varsta);
        
         varstaText= new JTextField(20);
        varstaText.setBounds(100,230,165,25);
        panel.add(varstaText);
         
        succes= new JLabel("");
        succes.setBounds(230,300,200,50);
        panel.add(succes);
        
        // Creating login button
         button = new JButton("Creare legitimatie");
        button.setBounds(10, 300, 200, 50);
        button.addActionListener(new gui());
        panel.add(button);
        
       
    }

	@Override
	public void actionPerformed(ActionEvent e) {
			if(e.getSource()==button) {
		String nume = numeText.getText();
		String cnp = String.valueOf(cnpText.getPassword());
		String adresa =adresaText.getText();
		int varsta  =Integer.parseInt(varstaText.getText());	
		 try{ frame.dispose();
	           Class.forName("com.mysql.jdbc.Driver");
	            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/legitimatie","root","");
	           String sql="INSERT INTO legitimatii (nume,cnp,adresa,varsta) VALUES (?,?,?,?)";
	           PreparedStatement stmt=con.prepareStatement(sql);

	            stmt.setString(1, nume);
	            stmt.setString(2, cnp);
	            stmt.setString(3, adresa);
	            stmt.setInt(4, varsta);
	            
	            stmt.executeUpdate();
	                
	                MeniuPrincipal nnw=new MeniuPrincipal();
	                nnw.NewScreen3();
	                	
	            
		succes.setText("Legitimatie Creata!");
		 }
		 catch(Error err){
			  
		 } catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		
		
					
}
	}
}
