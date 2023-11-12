package proiectp3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AdaugaCarte extends JFrame  {

	private JPanel contentPane;
	private JTextField Autor;
	private JTextField Nr_bucati;
	private JTextField Pret;
	private JTextField Titlu;

	/**
	 * Launch the application.
	 */
	public static void NewSAdaugare() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdaugaCarte frame = new AdaugaCarte();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdaugaCarte() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 443);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(184, 134, 11));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Adauga Carte");
		lblNewLabel.setBounds(232, 10, 262, 82);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Titlu : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(20, 89, 60, 58);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Autor:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(20, 173, 60, 35);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nr_buc");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(20, 248, 60, 35);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Pret:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(20, 304, 60, 43);
		contentPane.add(lblNewLabel_4);
		
		Autor = new JTextField();
		Autor.setBounds(90, 176, 278, 35);
		contentPane.add(Autor);
		Autor.setColumns(10);
		
		Nr_bucati = new JTextField();
		Nr_bucati.setBounds(90, 251, 278, 35);
		contentPane.add(Nr_bucati);
		Nr_bucati.setColumns(10);
		
		Pret = new JTextField();
		Pret.setBounds(90, 319, 278, 35);
		contentPane.add(Pret);
		Pret.setColumns(10);
		
		Titlu = new JTextField();
		Titlu.setBounds(90, 112, 278, 35);
		contentPane.add(Titlu);
		Titlu.setColumns(10);
		
		JButton btnNewButton = new JButton("Adauga carte");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String autor = Autor.getText();
				int nr_bucati = Integer.parseInt(Nr_bucati.getText());
				int pret =Integer.parseInt(Pret.getText());
				String titlu=(Titlu.getText());
				 try{ AdaugaCarte.this.dispose();
			           Class.forName("com.mysql.jdbc.Driver");
			            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/legitimatie","root","");
			           String sql="INSERT INTO carti (titlu,autor,pret,nr_bucati) VALUES (?,?,?,?)";
			           PreparedStatement stmt=con.prepareStatement(sql);

			            stmt.setString(1, titlu	);
			            stmt.setString(2, autor);
			            stmt.setInt(3, pret);
			            stmt.setInt(4, nr_bucati);
			            
			            stmt.executeUpdate();
			            JOptionPane.showMessageDialog(null, "Succes!");
			                
			                MeniuA nnw=new MeniuA();
			                nnw.NewScreenA();
			            
			            
			
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
	
			
		});
	
        	
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(417, 299, 213, 43);
		contentPane.add(btnNewButton);
	}		
	
}
	