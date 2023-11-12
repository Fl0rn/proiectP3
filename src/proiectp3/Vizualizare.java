package proiectp3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;

public class Vizualizare extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void VZ() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vizualizare frame = new Vizualizare();
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
	public Vizualizare() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 618, 439);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(184, 134, 11));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(222, 106, 372, 157);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Titlu", "Autor", "Pret", "NR_bucati"
			}
		));
		contentPane.add(table);
		
		JButton btnNewButton = new JButton("Show data");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 Class.forName("com.mysql.jdbc.Driver");
			            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/legitimatie","root","");
			            Statement st =(Statement) con.createStatement();
			            String sql="select * from carti";
			            ResultSet rs= (ResultSet) st.executeQuery(sql);
			            while(rs.next()) {
			            	String titlu=rs.getString("titlu");
			            	String autor=rs.getString("autor");
			            	String pret=String.valueOf(rs.getInt("pret"));
			            	String nr_buc=String.valueOf(rs.getInt("nr_bucati"));
			            	String data[]= {titlu,autor,pret,nr_buc};
			            	DefaultTableModel tb =(DefaultTableModel)table.getModel();
			            	tb.addRow(data);
			            }
			            con.close();
				}catch(Exception e1){
					
					
				}
			}
		});
		btnNewButton.setBounds(10, 155, 147, 77);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(btnNewButton);
	}
}
