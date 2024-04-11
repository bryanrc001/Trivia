


import java.awt.EventQueue;


import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;


import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class MainMenu {

	 JFrame frame;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		 
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					//window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainMenu() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		
		frame.getContentPane().setBackground(Color.ORANGE);		
	
		Image imgBP= new ImageIcon(this.getClass().getResource("images/PLAY (2).png")).getImage();
		JButton play = new JButton(new ImageIcon(imgBP));
		play.setBounds(483, 371, 170, 75);
		play.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				GameMenu m1 = new GameMenu();
				//m1.initialize();
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(play);
		
		Image imgBM= new ImageIcon(this.getClass().getResource("images/SIGN-UP.png")).getImage();
		JButton signup = new JButton(new ImageIcon(imgBM));
		signup.setBounds(483, 458, 170, 75);
		frame.getContentPane().add(signup);
		signup.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				log m2 = new log();
				//m2.initialize();
			}
		});
		
			
		JLabel lblNewLabel = new JLabel("");
		Image img= new ImageIcon(this.getClass().getResource("images/LOGO2.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(376, 0, 576, 670);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		
		frame.setBounds(100, 100, 1141, 601);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	 
}
