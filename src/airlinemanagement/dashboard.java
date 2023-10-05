package airlinemanagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class dashboard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dashboard frame = new dashboard();
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
	public dashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1360, 687);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DASHBOARD");
		lblNewLabel.setBounds(594, 42, 245, 40);
		lblNewLabel.setFont(new Font("Imprint MT Shadow", Font.BOLD, 30));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(1295, 10, 41, 26);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\back (2).png"));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loginpage obj = new loginpage();
				obj.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Manage Flight");
		btnNewButton.setBounds(40, 403, 227, 40);
		btnNewButton.setForeground(new Color(0, 128, 192));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manageflight obj = new manageflight();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Manage Passenger");
		btnNewButton_1.setBounds(393, 403, 212, 40);
		btnNewButton_1.setForeground(new Color(0, 128, 192));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				managepassenger obj = new managepassenger();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Ticket Booking");
		btnNewButton_1_1.setBounds(742, 404, 218, 39);
		btnNewButton_1_1.setForeground(new Color(0, 128, 192));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ticketbooking obj = new ticketbooking();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Ticket Cancellation");
		btnNewButton_1_2.setBounds(1084, 406, 205, 35);
		btnNewButton_1_2.setForeground(new Color(0, 128, 192));
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ticketcancellation obj = new ticketcancellation();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(btnNewButton_1_2);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(707, 155, 253, 213);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\ticket (1).png"));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(40, 142, 261, 251);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\airline (3).png"));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(370, 142, 253, 251);
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\traveler.png"));
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(1042, 128, 271, 268);
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\multiply (1).png"));
		contentPane.add(lblNewLabel_5);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 117, 1326, 355);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(0, 0, 1326, 355);
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\18776135_6017056.jpg"));
		panel.add(lblNewLabel_6);
		
		JLabel label = new JLabel("New label");
		label.setBounds(0, 0, 45, 13);
		panel.add(label);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(512, 10, 72, 82);
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\menu (1).png"));
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\pexels-pixabay-104826.jpg"));
		lblNewLabel_8.setBounds(0, 0, 1346, 650);
		contentPane.add(lblNewLabel_8);
	}
}
