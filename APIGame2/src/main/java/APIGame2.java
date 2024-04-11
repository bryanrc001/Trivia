import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;


public class APIGame2 extends JFrame {
	public APIGame2() {
		setTitle("Higher or Lower: Music Edition Main Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize frame
		setLocationRelativeTo(null); // Center the frame on the screen
		setLayout(null);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;

		int buttonW = 200;
		int buttonH = 50;
		int buttonX = (screenWidth - buttonW) / 2; // Center horizontally
		int buttonY = (screenHeight - buttonH) / 2; // Center vertically

		// Create and add components to the main menu
		JLabel label = new JLabel("Welcome to Game 2!");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		add(label);
		label.setBounds(buttonX,buttonY - 100,buttonW,buttonH);

		JButton startGameButton = new JButton("Start Game");
		add(startGameButton);
		startGameButton.setBounds(buttonX,buttonY - (buttonH + 10),buttonW,buttonH);
		JButton howToPlayButton = new JButton("How to Play");
		add(howToPlayButton);
		howToPlayButton.setBounds(buttonX,buttonY,buttonW,buttonH);

		startGameButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Open the new menu or window when the button is clicked
				GameMenu gameMenu = new GameMenu();
				gameMenu.setVisible(true);
				dispose();
			}
		});
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				APIGame2 mainMenu = new APIGame2();
				mainMenu.setVisible(true);
			}
		});
	}
}

class GameMenu extends JFrame {
	private APIGame2 mainMenu;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int screenWidth = screenSize.width;
	private int screenHeight = screenSize.height;
    private List<String> titles = new ArrayList<>();
    private List<String> artists = new ArrayList<>();
    private List<String> coverUrls = new ArrayList<>();

	
	public GameMenu() {
		setTitle("Game Menu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Dispose when closed
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null); // Center the frame on the screen
		setLayout(null);

		int buttonW = 200;
		int textW = 100;
		int buttonH = 50;
		int textH = 20;
		int buttonX = (screenWidth - buttonW) / 2; // Center horizontally
		int textX = (screenWidth - textW) / 2;
		int buttonY = (screenHeight - buttonH) / 2; // Center vertically
		int textY = (screenHeight - textH) / 2;
		
		JTextField calories = new JTextField();
		calories.setBounds(textX,textY,textW,textH);
		add(calories);
		
		try {
            initGame(); // Initialize game data
            startGame(); // Start the game loop
        } catch (UnirestException e) {
            e.printStackTrace();
        }
	}
	
	public void initGame() throws UnirestException{
		// TODO Auto-generated method stub
		HttpResponse<String> response = Unirest.get("https://billboard-api5.p.rapidapi.com/api/charts/billboard-200?week=2024-04-01")
				.header("X-RapidAPI-Key", "4efe3fdfb0msh34328b148c8fafbp1bb973jsnae95fb41493d")
				.header("X-RapidAPI-Host", "billboard-api5.p.rapidapi.com")
				.asString();
		
		String toDisplay = response.getBody();
		//System.out.println(toDisplay);
		
        int titleLoc = -1;
        while ((titleLoc = toDisplay.indexOf("title", titleLoc + 1)) != -1) {
        	int artistLoc = toDisplay.indexOf("artist", titleLoc + 1);
            int coverLoc = toDisplay.indexOf("cover", titleLoc + 1);

            // Extract title
            String titleSubstring = toDisplay.substring(titleLoc, artistLoc);
            int titleCommaLoc = titleSubstring.indexOf(",");
            titles.add(titleSubstring.substring(8, titleCommaLoc - 1));

            // Extract artist
            String artistSubstring = toDisplay.substring(artistLoc, coverLoc);
            int artistCommaLoc = artistSubstring.indexOf(",");
            artists.add(artistSubstring.substring(9, artistCommaLoc - 1));

            // Extract cover URL
            int coverUrlStartIndex = toDisplay.indexOf(":", coverLoc) + 2;
            int coverUrlEndIndex = toDisplay.indexOf("\"", coverUrlStartIndex);
            coverUrls.add(toDisplay.substring(coverUrlStartIndex, coverUrlEndIndex));
        }
       
	}
	
	public void startGame() {
        // Random object for generating random indices
        Random random = new Random();

        // Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Game loop
        while (true) {
            // Generate two random indices
            int index1 = random.nextInt(coverUrls.size());
            int index2 = random.nextInt(coverUrls.size());
            while (index2 == index1) {
                index2 = random.nextInt(coverUrls.size());
            }
            
            URL url1 = new URL(coverUrls.get(index1));
            BufferedImage poster1_buff = ImageIO.read(url1);
            Image poster1_scaled = poster1_buff.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
            ImageIcon poster1 = new ImageIcon(poster1_scaled);
            JLabel poster1_label = new JLabel(poster1);
            poster1_label.setBounds(0,0,scaledWidth,500);
            add(poster1_label);
            
            URL url2 = new URL(coverUrls.get(index2));
            BufferedImage poster2_buff = ImageIO.read(url2);
            Image poster2_scaled = poster2_buff.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
            ImageIcon poster2 = new ImageIcon(poster2_scaled);
            JLabel poster2_label = new JLabel(poster2);
            poster2_label.setBounds(300,0,scaledWidth,scaledHeight);
            add(poster2_label);
            
            // Get the titles and ask the user to guess
            /*
            String title1 = titles.get(index1);
            String title2 = titles.get(index2);
            String coverUrl1 = coverUrls.get(index1);
            String coverUrl2 = coverUrls.get(index2);
            System.out.println("Which song is ranked higher?");
            System.out.println("1. " + title1);
            System.out.println("2. " + title2);
            System.out.print("Enter your choice (1 or 2): ");
			
            // Get user input
            int userChoice = scanner.nextInt();

            // Compare the indices to determine the winner
            
            URL url1 = new URL(coverUrls.get(index1));
            BufferedImage poster1_buff = ImageIO.read(url1);
            Image poster1_scaled = poster1_buff.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
            ImageIcon poster1 = new ImageIcon(poster1_scaled);
            JLabel poster1_label = new JLabel(poster1);
            poster1_label.setBounds(0,0,scaledWidth,500);
            frame.add(poster1_label);
            
            URL url2 = new URL(coverUrls.get(index2));
            BufferedImage poster2_buff = ImageIO.read(url2);
            Image poster2_scaled = poster2_buff.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
            ImageIcon poster2 = new ImageIcon(poster2_scaled);
            JLabel poster2_label = new JLabel(poster2);
            poster2_label.setBounds(300,0,scaledWidth,scaledHeight);
            frame.add(poster2_label);
            */
            
            
            int correctAnswer = (index1 < index2) ? 1 : 2;
            
            // Check user's guess
            if (userChoice == correctAnswer) {
                System.out.println("Correct! The song \"" + (correctAnswer == 1 ? title1 : title2) + "\" is ranked higher.");
            } else {
                System.out.println("Incorrect! The song \"" + (correctAnswer == 1 ? title1 : title2) + "\" is ranked higher.");
            }

            // Ask if the user wants to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break; // Exit the game loop if the user doesn't want to play again
            }
        }

        // Close the scanner
        scanner.close();
    }
	
}