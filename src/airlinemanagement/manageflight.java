package airlinemanagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
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

public class manageflight extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField fc;
	private JTextField s;
	private JTextField d;
	private JTextField tof;
	private JTextField nos;
	protected JTable jscrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					manageflight frame = new manageflight();
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
	public manageflight() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1363, 741);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MANAGE FLIGHT");
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 32));
		lblNewLabel.setBounds(580, 20, 278, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Flight Code");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(83, 111, 71, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Source");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(402, 112, 58, 20);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Destination");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(711, 114, 80, 17);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Take of");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(980, 118, 71, 15);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("No Of Seats");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_1.setBounds(1185, 115, 80, 15);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 273, 1329, 421);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Flight Code", "Source", "Destination", "Take Of", "No Of Seats"
			}
		));
		
		fc = new JTextField();
		fc.setBounds(83, 143, 194, 31);
		contentPane.add(fc);
		fc.setColumns(10);
		
		s = new JTextField();
		s.setColumns(10);
		s.setBounds(361, 143, 232, 31);
		contentPane.add(s);
		
		d = new JTextField();
		d.setColumns(10);
		d.setBounds(680, 143, 221, 31);
		contentPane.add(d);
		
		tof = new JTextField();
		tof.setColumns(10);
		tof.setBounds(943, 143, 167, 31);
		contentPane.add(tof);
		
		nos = new JTextField();
		nos.setColumns(10);
		nos.setBounds(1163, 143, 125, 31);
		contentPane.add(nos);
		
		JButton btnNewButton = new JButton("INSERT");
		btnNewButton.setForeground(new Color(0, 128, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection cn =DriverManager.getConnection("jdbc:mysql://localhost:3306/ams","root","");
					String sql = "insert into manageflight values(?,?,?,?,?)";
					PreparedStatement ptst = cn.prepareStatement(sql);
					ptst.setString(1, fc.getText());
					ptst.setString(2, s.getText());
					ptst.setString(3, d.getText());
					ptst.setString(4, tof.getText());
					ptst.setString(5, nos.getText());
					ptst.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Data Inserted Successfully!");
					cn.close();
				}
				catch(Exception e1)
				{
					
				}
			}
		});
		btnNewButton.setBounds(136, 222, 125, 41);
		contentPane.add(btnNewButton);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setForeground(new Color(0, 128, 255));
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection cn =DriverManager.getConnection("jdbc:mysql://localhost:3306/ams","root","");
					String id =fc.getText();
					String source =s.getText();
					String des =d.getText();
					String tak =tof.getText();
					String noofseat =nos.getText();
					
					String sql= "UPDATE `manageflight` SET `source`='"+source+"',`destination`='"+des+"',`takeof`='"+tak+"',`noofseats`='"+noofseat+"' WHERE `flightcode`='"+id+"'";
					PreparedStatement ptst = cn.prepareStatement(sql);
					ptst.execute();
					
					JOptionPane.showMessageDialog(null,"Record Updated!");
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnUpdate.setBounds(496, 222, 125, 41);
		contentPane.add(btnUpdate);
		
		JButton btnNewButton_1_1 = new JButton("SHOW");
		btnNewButton_1_1.setForeground(new Color(0, 128, 255));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try
				{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection cn =DriverManager.getConnection("jdbc:mysql://localhost:3306/ams","root","");
				Statement st = cn.createStatement();
				String sql = "SELECT * from manageflight";
				PreparedStatement ptst = cn.prepareStatement(sql);
				ResultSet rs=ptst.executeQuery();
				DefaultTableModel dt = (DefaultTableModel)table.getModel();
				dt.setRowCount(0);
				while(rs.next())
				{
					Object o[] = {rs.getString("flightcode"),rs.getString("source"),rs.getString("destination"),rs.getString("takeof"),rs.getString("noofseats")};
					dt.addRow(o);
				}
				
				
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
		});
		btnNewButton_1_1.setBounds(820, 222, 109, 41);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("DELETE");
		btnNewButton_1_1_1.setForeground(new Color(0, 128, 255));
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection cn =DriverManager.getConnection("jdbc:mysql://localhost:3306/ams","root","");
					Statement st = cn.createStatement();
					String id = fc.getText();
					String sql = "DELETE FROM manageflight WHERE flightcode='"+id+"'";
					PreparedStatement ptst = cn.prepareStatement(sql);
					ptst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data Deleted Successfully");
					cn.close();
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnNewButton_1_1_1.setBounds(1129, 222, 98, 41);
		contentPane.add(btnNewButton_1_1_1);
		
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
		lblNewLabel_2.setBounds(1299, 0, 40, 32);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\travel.png"));
		lblNewLabel_3.setBounds(500, 10, 70, 60);
		contentPane.add(lblNewLabel_3);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 78, 1329, 185);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\18776135_6017056.jpg"));
		lblNewLabel_4.setBounds(0, 0, 1329, 185);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\pexels-rovenimagescom-949587.jpg"));
		lblNewLabel_5.setBounds(0, 0, 1349, 704);
		contentPane.add(lblNewLabel_5);
	}
}
