package proiectp3;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class logaregui implements ActionListener {
		private static JLabel nume;
	    private static JTextField numeText;
	    private static JLabel cnp;
	    private static JPasswordField cnpText;
	    private static JButton logare;
	    private static JButton creare;
	    private static JComboBox admin;
	    private static JLabel succes;
  static JPanel panel = new JPanel();    
 static JFrame frame = new JFrame("My First Swing Example");
	public static void NewScreen2() {    
	   
		
	    frame.setSize(400, 400);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
		panel.setBackground(new Color(0, 206, 209));

	     
	   
	    frame.add(panel);
	  
	    placeComponents(panel);
	    frame.setVisible(true);
	}
	private static void placeComponents(JPanel panel) {
		  panel.setLayout(null);
	      JLabel titlu= new JLabel("Logare");
	      titlu.setBounds(100,10,200,40);
	      panel.add(titlu);
	         nume = new JLabel("Nume");
	         nume.setBounds(10,110,80,25);
	         panel.add(nume);
	         
	         
	          numeText = new JTextField(20);
	         numeText.setBounds(100,110,165,25);
	         panel.add(numeText);
	         cnp = new JLabel("CNP");
	         cnp.setBounds(10,150,80,25);
	         panel.add(cnp);

	         cnpText = new JPasswordField(20);
	         cnpText.setBounds(100,150,165,25);
	         panel.add(cnpText);
	         
	         succes= new JLabel("");
	         succes.setBounds(230,200,150,25);
	         panel.add(succes);
	         
	         String[] users= {"legitimatie","admin"};
	         admin= new JComboBox(users);
	         admin.setBounds(130,200,100,20);
	         panel.add(admin);
	         
	     	logare = new JButton("Logare ");
	    	logare.setBounds(60,270,80,25);
	    	logare.addActionListener(new logaregui());
	        panel.add(logare);
}
	@Override
	public void actionPerformed(ActionEvent e) {
		String nume= numeText.getText();
		String cnp = String.valueOf(cnpText.getPassword()); 
		int loginType = (int) admin.getSelectedIndex();
		

		
		 try{
	           Class.forName("com.mysql.jdbc.Driver");
	            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/legitimatie","root","");
	            String sql="Select NUME,CNP from legitimatii where nume='"+ nume +"' and cnp='"+cnp+"'";	  
	            String sql2="Select NUME,CNP from admin where nume='"+ nume +"' and cnp='"+cnp+"'";
	            
	            if(loginType== 0) {
	           PreparedStatement stmt=con.prepareStatement(sql);

	            ResultSet rs=stmt.executeQuery(sql);
	            if(rs.next())
	            { 
	                frame.dispose();
	                MeniuPrincipal nnw=new MeniuPrincipal();
	                nnw.NewScreen3();
	                	
	            
	          
		                	
	              
	            }
	              else {succes.setText("logare esuata!");
	     	creare = new JButton("Creaza legitimatie ");
	    	creare.setBounds(60,270,200,40);
	    	creare.addActionListener(new ActionListener()
	    	{
	    		  public void actionPerformed(ActionEvent e) {
	    		        frame.dispose();
	    		        gui incercare =new gui();
	    		    	incercare.NewScreen();
	    		    }
	    	});
	    		
	    	         
	        panel.add(creare);
	              
			
				
			}
	                rs.close();

	            stmt.close();

	            con.close();
	           
		 }
	            else {
	                PreparedStatement stmt=con.prepareStatement(sql2);

		            ResultSet rs=stmt.executeQuery(sql2);
		            int stop=1;
		            if(rs.next()&&stop==1)
		            { 
		                frame.dispose();
		                System.out.println(2);
		             MeniuA nnw=new MeniuA();
		                nnw.NewScreenA();	
		                stop=0;
		                
		            
		          
			                	
		              
		            }
		              else {succes.setText("logare esuata!");
		     	creare = new JButton("Creaza legitimatie ");
		    	creare.setBounds(60,270,200,40);
		    	creare.addActionListener(new ActionListener()
		    	{
		    		  public void actionPerformed(ActionEvent e) {
		    		        frame.dispose();
		    		        gui incercare =new gui();
		    		    	incercare.NewScreen();
		    		    }
		    	});
		    		
		    	         
		        panel.add(creare);
		              
				
					
				}
		                rs.close();

		            stmt.close();

		            con.close();
	            }
	           
	           
	       } 
		 catch(Exception e1)
	        {
	            JOptionPane.showMessageDialog(null,e1);
	}
		
		 
		 
		}
	
	
		
		
		

	
	}