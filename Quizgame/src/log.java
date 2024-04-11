import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.beans.Statement;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.util.Properties;

public class log {

	 JFrame frame;
	 private JPanel panel;
	 private JTextField textField;
	 private JLabel lblNewLabel;
	 private JButton btnNewButton;
	 private JLabel lblNewLabel_2;
	 
	 private JPasswordField passwordField;
	 private static final String dbClassname = "com.mysql.cj.jdbc.Driver";
	 private static final String CONNECTION = "jdbc:mysql://127.0.0.1/quizgame";
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args){
		 // TODO Auto-generated method stub
	 EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					log window = new log();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public log() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 */
	public void initialize() {
		frame = new JFrame();
		
		panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("C:\\Users\\icarb\\OneDrive\\Desktop\\BR.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JLabel imgs = new JLabel(new ImageIcon(img));
		panel.add(imgs);
		imgs.setBounds(10,66,950,249);
		
		lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(257, 233, 114, 29);
		
		textField = new JTextField();
		textField.setBounds(390, 228, 212, 45);
		textField.setColumns(10);
		panel.setLayout(null);
		panel.add(lblNewLabel);
		panel.add(textField);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(257, 292, 114, 23);
		panel.add(lblNewLabel_1);
		
		btnNewButton = new JButton("Log-in");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
				System.out.println(dbClassname);
				 Properties p = new Properties();
				 p.put("user", "root");
				 p.put("password", "TreePad!");
				 
				try {
					//Class.forName("com.mysql.jdbc.Driver");
					Connection c = DriverManager.getConnection(CONNECTION,p);
					Statement s = (Statement) c.createStatement();
					ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT * FROM users");
				while (rs.next()) {
				 System.out.println(rs.getString("item"));
				 } 
				c.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
				 
				 
			}
		});
		btnNewButton.setBounds(413, 359, 165, 54);
		panel.add(btnNewButton);
		
		lblNewLabel_2 = new JLabel("TRIVIAL");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
		lblNewLabel_2.setBounds(216, 11, 538, 79);
		panel.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(390, 284, 212, 45);
		panel.add(passwordField);
		
		Image imgBP= new ImageIcon(this.getClass().getResource("images/PLAY (2).png")).getImage();
		JButton play = new JButton(new ImageIcon(imgBP));
		play.setBounds(152, 377, 170, 75);
		

		
		frame.setBounds(100, 70, 1000, 601);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
}
