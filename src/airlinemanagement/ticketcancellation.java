package airlinemanagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class ticketcancellation extends JFrame {

	private JPanel contentPane;
	private JTextField tid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ticketcancellation frame = new ticketcancellation();
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
	public ticketcancellation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1045, 620);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TICKET CANCELLATION");
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 30));
		lblNewLabel.setBounds(358, 45, 416, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cancel Ticket Enter Ticket ID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_1.setBounds(99, 290, 285, 31);
		contentPane.add(lblNewLabel_1);
		
		tid = new JTextField();
		tid.setBounds(394, 290, 405, 37);
		contentPane.add(tid);
		tid.setColumns(10);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.setForeground(new Color(0, 128, 192));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ams", "root", "");
					Statement st = con.createStatement();

					String ticketid= tid.getText();
					String sql = "DELETE FROM `ticketbooking` WHERE id='"+ticketid+"'";
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
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(454, 394, 121, 37);
		contentPane.add(btnNewButton);
		
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
		lblNewLabel_2.setBounds(984, 0, 37, 31);
		contentPane.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(85, 200, 845, 259);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\triangles-g708308cd4_1280.png"));
		lblNewLabel_4.setBounds(0, 0, 845, 259);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\cancel.png"));
		lblNewLabel_3.setBounds(270, 10, 82, 76);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\pexels-rovenimagescom-949587.jpg"));
		lblNewLabel_5.setBounds(0, 0, 1031, 583);
		contentPane.add(lblNewLabel_5);
	}

}
