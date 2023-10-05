package airlinemanagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import generalstoremanagementsys.dashboard;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class loginpage extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginpage frame = new loginpage();
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
	public loginpage() {
		setBackground(new Color(0, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1360, 776);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(376, 155, 687, 451);
		panel.setBackground(new Color(0, 0, 0));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(344, 10, 128, 128);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\permission (1).png"));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(209, 161, 32, 39);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\user.png"));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(209, 236, 42, 39);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\password.png"));
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		pass = new JPasswordField();
		pass.setBounds(261, 236, 297, 31);
		panel.add(pass);
		
		user = new JTextField();
		user.setBounds(261, 169, 297, 31);
		panel.add(user);
		user.setColumns(10);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setBounds(355, 307, 113, 31);
		panel.add(btnNewButton);
		btnNewButton.setForeground(new Color(0, 128, 255));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					String un = user.getText();
					String pw = pass.getText();
					
					Connection cn =DriverManager.getConnection("jdbc:mysql://localhost:3306/ams","root","");
					Statement st = cn.createStatement();
					String sql = "Select * from login";
					ResultSet rs = st.executeQuery(sql);
					while(rs.next())
					{
						String username = rs.getString("username");
						String password = rs.getString("password");
						
						if(un.equals(username) && pw.equals(password))
						{
							new dashboard().setVisible(true);
							dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Username & Password is incorrect");
						}
					}
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,"Error while establishing connection failed!!!");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\plane-g36a1654c7_640.jpg"));
		lblNewLabel_3.setBounds(176, 10, 501, 431);
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 172, 451);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\pexels-furkanfdemir-5018335.jpg"));
		lblNewLabel_5.setBounds(0, 0, 172, 451);
		panel_1.add(lblNewLabel_5);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(569, 61, 476, 39);
		panel_2.setBackground(new Color(255, 255, 0));
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("AIRLINE MANAGEMENT SYSTEM");
		lblNewLabel.setBounds(10, 0, 444, 38);
		panel_2.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(0, 255, 255));
		lblNewLabel.setFont(new Font("DialogInput", Font.BOLD, 28));
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(426, 21, 141, 119);
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\airline.png"));
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\pexels-oleksandr-pidvalnyi-1004584.jpg"));
		lblNewLabel_7.setBounds(0, 0, 1346, 739);
		contentPane.add(lblNewLabel_7);
	}
}
