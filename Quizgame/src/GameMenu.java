

import java.awt.EventQueue;

import java.awt.Image;
import java.awt.Window;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Icon;

public class GameMenu {

	 JFrame frameMenu;
	/**
	 * Launch the application.
	 */
	 public static void main(String[] args) {
		 
			
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						GameMenu window = new GameMenu();
						//window.frameMenu.setVisible(true);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	 
	public GameMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
	    frameMenu = new JFrame();
		frameMenu.setTitle("Trivial Benchmark");
		//frameMenu.setSize(450,300);
		frameMenu.getContentPane().setBackground(Color.ORANGE);
		frameMenu.getContentPane().setLayout(null);
		Image imgBC= new ImageIcon(this.getClass().getResource("images/help.png")).getImage();
		JButton categories = new JButton(new ImageIcon(imgBC));
		
		categories.setBounds(164, 374, 170, 75);
		frameMenu.getContentPane().add(categories);
		
		
		
		Image imgBL= new ImageIcon(this.getClass().getResource("images/MENU (2).png")).getImage();
		JButton languages = new JButton(new ImageIcon(imgBL));
		languages.setBounds(503, 464, 170, 75);
		languages.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frameMenu.setVisible(false);
				MainMenu q1 = new MainMenu();
				q1.initialize();
				
				
			}
		});
		frameMenu.getContentPane().setLayout(null);
		frameMenu.getContentPane().add(languages);
		Image imgBH= new ImageIcon(this.getClass().getResource("images/help.png")).getImage();
		
		JLabel lblNewLabel = new JLabel("GAME 1");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 44));
		lblNewLabel.setBounds(122, 11, 227, 112);
		frameMenu.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("GAME 2");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 44));
		lblNewLabel_1.setBounds(468, 11, 227, 112);
		frameMenu.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("GAME 3");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.BOLD, 44));
		lblNewLabel_2.setBounds(778, 12, 227, 110);
		frameMenu.getContentPane().add(lblNewLabel_2);
		
		Image imgG1 = new ImageIcon(this.getClass().getResource("images/quiz.jpg")).getImage();
		JButton game1 = new JButton(new ImageIcon(imgG1));
		game1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		game1.setBounds(113, 116, 254, 247);
		frameMenu.getContentPane().add(game1);
		
		Image imgG2 = new ImageIcon(this.getClass().getResource("images/trivia.jpg")).getImage();
		JButton game2 = new JButton(new ImageIcon(imgG2));
		game2.setBounds(777, 116, 254, 247);
		frameMenu.getContentPane().add(game2);
		
		Image imgG3 = new ImageIcon(this.getClass().getResource("images/hilow.jpg")).getImage();
		JButton game3 = new JButton(new ImageIcon(imgG3));
		game3.setBounds(448, 116, 254, 247);
		frameMenu.getContentPane().add(game3);
		
		Image imgH2 = new ImageIcon(this.getClass().getResource("images/help.png")).getImage();
		JButton help2 = new JButton((new ImageIcon (imgH2)));
		help2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		help2.setBounds(503, 374, 170, 75);
		frameMenu.getContentPane().add(help2);
		
		Image imgH3 = new ImageIcon(this.getClass().getResource("images/help.png")).getImage();
		JButton help3 = new JButton((new ImageIcon (imgH3)));
		help3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		}
	});
		help3.setBounds(827, 374, 170, 75);
		frameMenu.getContentPane().add(help3);
		
		
		frameMenu.setBounds(100, 100, 1141, 601);
		
		frameMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMenu.setVisible(true);
		frameMenu = new JFrame();
		frameMenu.setResizable(true);
	}
}

