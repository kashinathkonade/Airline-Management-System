package airlinemanagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
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
import javax.swing.ImageIcon;
import java.awt.Color;

public class managepassenger extends JFrame {

	private JPanel contentPane;
	private JTextField pn;
	private JTextField g;
	private JTextField n;
	private JTextField pass;
	private JTextField ph;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					managepassenger frame = new managepassenger();
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
	public managepassenger() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1362, 777);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MANAGE PASSENGER");
		lblNewLabel.setForeground(new Color(0, 128, 255));
		lblNewLabel.setFont(new Font("Rockwell Condensed", Font.BOLD, 29));
		lblNewLabel.setBounds(627, 23, 264, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Passenger Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(91, 107, 117, 19);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Gender");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(365, 107, 83, 19);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Nationality");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(570, 107, 96, 19);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Passport Number");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1.setBounds(814, 107, 145, 19);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Phone");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1_1.setBounds(1094, 107, 83, 18);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\back (2).png"));
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dashboard obj = new dashboard();
				obj.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2.setBounds(1298, 10, 40, 32);
		contentPane.add(lblNewLabel_2);
		
		pn = new JTextField();
		pn.setBounds(90, 136, 241, 31);
		contentPane.add(pn);
		pn.setColumns(10);
		
		g = new JTextField();
		g.setColumns(10);
		g.setBounds(365, 136, 145, 31);
		contentPane.add(g);
		
		n = new JTextField();
		n.setColumns(10);
		n.setBounds(572, 135, 163, 31);
		contentPane.add(n);
		
		pass = new JTextField();
		pass.setColumns(10);
		pass.setBounds(814, 135, 208, 31);
		contentPane.add(pass);
		
		ph = new JTextField();
		ph.setColumns(10);
		ph.setBounds(1096, 135, 145, 31);
		contentPane.add(ph);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 252, 1311, 443);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"PassengerName", "Gender", "Nationality", "Passport Number", "Phone"
			}
		));
		
		JButton btnNewButton = new JButton("INSERT");
		btnNewButton.setForeground(new Color(0, 128, 192));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection cn =DriverManager.getConnection("jdbc:mysql://localhost:3306/ams","root","");
					String sql = "insert into managepassenger values(?,?,?,?,?)";
					PreparedStatement ptst = cn.prepareStatement(sql);
					ptst.setString(1, pn.getText());
					ptst.setString(2, g.getText());
					ptst.setString(3, n.getText());
					ptst.setString(4, pass.getText());
					ptst.setString(5, ph.getText());
					ptst.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Data Inserted Successfully!");
					cn.close();
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnNewButton.setBounds(214, 205, 117, 37);
		contentPane.add(btnNewButton);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUpdate.setForeground(new Color(0, 128, 192));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String name=pn.getText();
					String gender=g.getText();
					String nationaliy=n.getText();
					String passport=pass.getText();
					String phone=ph.getText();
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ams", "root", "");

					String sql= "UPDATE `managepassenger` SET `name`='"+name+"',`gender`='"+gender+"',`nationality`='"+nationaliy+"',`passportnumber`='"+passport+"' WHERE `phone`='"+phone+"'";
					PreparedStatement ptst = cn.prepareStatement(sql);
					ptst.execute();

					JOptionPane.showMessageDialog(null, "Record Updated!");

					}
					catch(Exception e1){
					JOptionPane.showMessageDialog(null, e);
					}
			}
		});
		btnUpdate.setBounds(527, 205, 110, 37);
		contentPane.add(btnUpdate);
		
		JButton btnNewButton_1_1 = new JButton("SHOW");
		btnNewButton_1_1.setForeground(new Color(0, 128, 192));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ams", "root", "");
					Statement st = con.createStatement();
					String sql ="SELECT * from managepassenger";
					PreparedStatement ptst= con.prepareStatement(sql);
					ResultSet rs= ptst.executeQuery();
					DefaultTableModel dt= (DefaultTableModel)table.getModel();
					dt.setRowCount(0);
					while(rs.next()){
					Object o[]= {rs.getString("name"),rs.getString("gender"),rs.getString("nationality"),rs.getString("passportnumber"),rs.getString("phone")};
					dt.addRow(o);
					}

					}
					catch(Exception e1){
					JOptionPane.showMessageDialog(null, e1);
					}
			}
		});
		btnNewButton_1_1.setBounds(849, 205, 110, 37);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("DELETE");
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_1_1.setForeground(new Color(0, 128, 192));
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ams", "root", "");
					Statement st = con.createStatement();

					String phone= ph.getText();
					String sql = "DELETE FROM `managepassenger` WHERE phone='"+phone+"'";
					PreparedStatement ptst = con.prepareStatement(sql);
					ptst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data deleted succsessfully");
					con.close();

					}
					catch(Exception e1){
					JOptionPane.showMessageDialog(null, e1);
					}
			}
		});
		btnNewButton_1_1_1.setBounds(1067, 205, 110, 37);
		contentPane.add(btnNewButton_1_1_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(27, 85, 1283, 164);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\triangles-g708308cd4_1280.png"));
		lblNewLabel_3.setBounds(0, 0, 1283, 164);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\passenger.png"));
		lblNewLabel_4.setBounds(553, 10, 64, 65);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\pexels-rovenimagescom-949587.jpg"));
		lblNewLabel_5.setBounds(0, 0, 1348, 740);
		contentPane.add(lblNewLabel_5);
	}
}
