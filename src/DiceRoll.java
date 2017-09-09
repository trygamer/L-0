

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DiceRoll{
	JFrame window = new JFrame("Roll the Dice!");
	JPanel panel = new JPanel();
	JButton rollButton = new JButton("CLICK HERE TO ROLL");
	JLabel label = new JLabel();
	
	BufferedImage oneImg;
	BufferedImage twoImg;
	BufferedImage threeImg;
	BufferedImage fourImg;
	BufferedImage fiveImg;
	BufferedImage sixImg;
	
	public void run(){
		try {
			oneImg = ImageIO.read(this.getClass().getResourceAsStream("https://pixabay.com/p-312625/?no_redirect"));
			twoImg = ImageIO.read(this.getClass().getResourceAsStream("https://orig07.deviantart.net/0dcc/f/2011/191/b/0/two_dots_by_stomper6-d3lm7ma.jpg"));
			threeImg = ImageIO.read(this.getClass().getResourceAsStream("https://image.flaticon.com/icons/svg/57/57013.svg"));
			fourImg = ImageIO.read(this.getClass().getResourceAsStream("https://i.ytimg.com/vi/k25k4jhPwf0/maxresdefault.jpg"));
			fiveImg = ImageIO.read(this.getClass().getResourceAsStream("https://image.freepik.com/free-icon/five-dots-like-a-dice_318-44438.jpg"));
			sixImg = ImageIO.read(this.getClass().getResourceAsStream("https://noahsarkhomeschoolacademy.files.wordpress.com/2012/10/dice-06.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		label.setIcon(new ImageIcon(oneImg));
		
		rollButton.addActionListener((e)->{
			
			//1. Make randomChoice equal to a random number between 1 and 6
			Random bob= new Random();
			
			int randomChoice = (6)+1;
			
			
			//2. Fix the code below so that it displays the correct image
			if(randomChoice == 0){
				label.setIcon(new ImageIcon(oneImg));
			}else if(randomChoice == 0){
				label.setIcon(new ImageIcon(twoImg));
			}else if(randomChoice == 0){
				label.setIcon(new ImageIcon(threeImg));
			}
			else if(randomChoice == 0){
				label.setIcon(new ImageIcon(fourImg));
			}
			else if(randomChoice == 0){
				label.setIcon(new ImageIcon(fiveImg));
			}
			else{
				label.setIcon(new ImageIcon(sixImg));
			}
		});
		
		panel.setPreferredSize(new Dimension(700, 700));
		panel.add(rollButton);
		panel.add(label);
		window.add(panel);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
	}
	
	public static void main(String[] args) {
		new DiceRoll().run();
	}
}