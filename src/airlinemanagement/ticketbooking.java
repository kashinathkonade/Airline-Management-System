package airlinemanagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class ticketbooking extends JFrame {

	private JPanel contentPane;
	private JTextField pid;
	private JTextField pn;
	private JTextField fc;
	private JTextField g;
	private JTextField pass;
	private JTextField amt;
	private JTextField n;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ticketbooking frame = new ticketbooking();
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
	public ticketbooking() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1353, 759);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 64, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TICKET BOOKING");
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setFont(new Font("Lucida Bright", Font.BOLD, 27));
		lblNewLabel.setBounds(560, 26, 270, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Nationality");
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(1111, 119, 81, 13);
		contentPane.add(lblNewLabel_1_1_1_1_1_1_1);
		
		n = new JTextField();
		n.setColumns(10);
		n.setBounds(1111, 144, 121, 31);
		contentPane.add(n);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.setForeground(new Color(0, 128, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.mysql.cj.jdbc.Driver");

					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ams", "root", "");
					String sql = "insert into ticketbooking values (?,?,?,?,?,?,?)";
					PreparedStatement ptst= con.prepareStatement(sql);
					ptst.setString(1,pid.getText());
					ptst.setString(2,pn.getText());
					ptst.setString(3,fc.getText());
					ptst.setString(4,g.getText());
					ptst.setString(5,pass.getText());
					ptst.setString(6,amt.getText());
					ptst.setString(7,n.getText());

					ptst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data inserted Succesfully!");
					con.close();
					}
					catch(Exception e1){
					JOptionPane.showMessageDialog(null, e1);
					}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(205, 237, 116, 39);
		contentPane.add(btnNewButton);
		
		JButton btnReset = new JButton("RESET");
		btnReset.setForeground(new Color(0, 128, 255));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pid.setText("");
				pn.setText("");
				fc.setText("");
				g.setText("");
				pass.setText("");
				amt.setText("");
				n.setText("");
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReset.setBounds(526, 237, 116, 39);
		contentPane.add(btnReset);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\back (2).png"));
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dashboard obj = new dashboard();
				obj.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(1283, 10, 46, 31);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("SHOW");
		btnNewButton_1.setForeground(new Color(0, 128, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ams", "root", "");
					Statement st = con.createStatement();
					String sql ="SELECT * from ticketbooking";
					PreparedStatement ptst= con.prepareStatement(sql);
					ResultSet rs= ptst.executeQuery();
					DefaultTableModel dt= (DefaultTableModel)table.getModel();
					dt.setRowCount(0);
					while(rs.next()){
					Object o[]= {rs.getString("id"),rs.getString("name"),rs.getString("flightcode"),rs.getString("gender"),rs.getString("passportnumber"),rs.getString("amount"),rs.getString("nationality")};
					dt.addRow(o);
					}
					}
					catch(Exception e1){
					JOptionPane.showMessageDialog(null, e);
					}
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(872, 237, 110, 39);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 286, 1307, 436);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Passenger ID", "Passenger Name", "Flight Code", "Gender", "Passport Number", "Amount", "Nationality"
			}
		));
		
		JPanel panel = new JPanel();
		panel.setBounds(22, 100, 1307, 184);
		contentPane.add(panel);
		panel.setLayout(null);
		
		pid = new JTextField();
		pid.setBounds(43, 44, 116, 31);
		panel.add(pid);
		pid.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Passenger ID");
		lblNewLabel_1.setBounds(43, 17, 91, 17);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		amt = new JTextField();
		amt.setBounds(933, 44, 121, 31);
		panel.add(amt);
		amt.setColumns(10);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Amount");
		lblNewLabel_1_1_1_1_1_1.setBounds(933, 17, 75, 17);
		panel.add(lblNewLabel_1_1_1_1_1_1);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		pass = new JTextField();
		pass.setBounds(748, 44, 143, 31);
		panel.add(pass);
		pass.setColumns(10);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Passport Number");
		lblNewLabel_1_1_1_1_1.setBounds(748, 19, 121, 13);
		panel.add(lblNewLabel_1_1_1_1_1);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		g = new JTextField();
		g.setBounds(574, 44, 132, 31);
		panel.add(g);
		g.setColumns(10);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Gender");
		lblNewLabel_1_1_1_1.setBounds(574, 17, 67, 17);
		panel.add(lblNewLabel_1_1_1_1);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		fc = new JTextField();
		fc.setBounds(400, 44, 121, 31);
		panel.add(fc);
		fc.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Flight Code");
		lblNewLabel_1_1_1.setBounds(400, 17, 81, 17);
		panel.add(lblNewLabel_1_1_1);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		pn = new JTextField();
		pn.setBounds(192, 44, 179, 31);
		panel.add(pn);
		pn.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Passenger Name");
		lblNewLabel_1_1.setBounds(192, 19, 116, 13);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\empty-save-texture-room-light.jpg"));
		lblNewLabel_3.setBounds(0, 0, 1307, 184);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\Java Project Images\\Images\\ticket.png"));
		lblNewLabel_4.setBounds(475, 10, 81, 80);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\pexels-rovenimagescom-949587.jpg"));
		lblNewLabel_5.setBounds(0, 0, 1339, 722);
		contentPane.add(lblNewLabel_5);
	}
}
