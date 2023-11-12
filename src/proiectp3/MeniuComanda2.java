package proiectp3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;

public class MeniuComanda2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	static Connection con;
	static PreparedStatement pst,pst2,pst3;
	static ResultSet rs,rs2,rs3;
	static String cty;
	
	private static int  suma=0;
	public static int getSuma() {
		return suma;
	}
	
	public void connect() {
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/legitimatie","root","");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void dyna() {
		connect();
		try {
			
			pst=con.prepareStatement("select distinct autor from carti");
			rs=pst.executeQuery();
			while(rs.next()) {
			autorBox.addItem(rs.getString(1));
			
			}
			cty=autorBox.getSelectedItem().toString();
			cityc();
		}catch (SQLException ex) {
			
		}
	}
	public void cityc() {
		try {connect();
		pst2=con.prepareStatement("Select titlu from carti where autor=?");
		pst2.setString(1, cty);
		rs2=pst2.executeQuery();
		titluBox.removeAllItems();
		while(rs2.next()) {
			titluBox.addItem(rs2.getString(1));
			
		}
		}catch(SQLException ex) {
			
		}
	}
	public static void MC2() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MeniuComanda2 frame = new MeniuComanda2();
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
	static JComboBox<String> titluBox = new JComboBox<String>();
	static JComboBox<String> autorBox = new JComboBox<String>();

	public MeniuComanda2()  {
	//	initComponents();
		dyna();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 483);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(210, 180, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Meniu Comanda");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(232, 20, 196, 51);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Selecteaza autorul cartii pe care o doresti");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(21, 88, 291, 38);
		contentPane.add(lblNewLabel_1);
		autorBox.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent e) {
			}
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
				cty=autorBox.getSelectedItem().toString();
				cityc();
			}
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
			}
		});
		
		
		autorBox.setBounds(21, 136, 254, 30);
		contentPane.add(autorBox);
		
		JLabel lblNewLabel_2 = new JLabel("Selecteaza titlul cartii pe care o doresti");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(21, 196, 301, 38);
		contentPane.add(lblNewLabel_2);
		
		titluBox.setBounds(21, 254, 254, 30);
		contentPane.add(titluBox);
		
		JButton btnNewButton = new JButton("Adauga in cos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btnNewButton) {
				String titlu_carte=titluBox.getSelectedItem().toString();
				String autor_carte=autorBox.getSelectedItem().toString();
			
				connect();
				try {
					pst3=con.prepareStatement("Select pret from carti where titlu='"+ titlu_carte +"' and autor='"+autor_carte+"'");
					rs3=pst3.executeQuery();
					while(rs3.next()) {
						suma= suma+ rs3.getInt("pret");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
					
						}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(98, 357, 354, 38);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Confirmare l= new Confirmare();
				l.setVisible(true);
				MeniuComanda2.this.dispose();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\flo\\Pictures\\cart2.png"));
		
		
				
		btnNewButton_1.setBounds(566, 47, 75, 75);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MeniuComanda2.this.dispose();
				MeniuPrincipal nw5;
				nw5 = new MeniuPrincipal();
				nw5.NewScreen3();
				
			}
		});
		btnNewButton_2.setBounds(520, 359, 110, 38);
		contentPane.add(btnNewButton_2);
		
	}
	
}
