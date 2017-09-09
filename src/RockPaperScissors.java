

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class RockPaperScissors extends JPanel implements ActionListener{
    Random randy = new Random();
    JFrame window = new JFrame("Rock Paper Scissors");
    JButton rockButton = new JButton();
    JButton paperButton = new JButton();
    JButton scissorsButton = new JButton();
    
    JLabel instructionLabel = new JLabel();
    
    BufferedImage rockImage;
    BufferedImage paperImage;
    BufferedImage scissorsImage;
    
    Dimension buttonDim = new Dimension(300, 200);
    
    public void run(){
        URL url;
        try {
            //1. Find a picture of a rock, paper, and scissors on the internet. Replace the URL's below with your images
            rockImage = ImageIO.read(new URL("https://lh5.googleusercontent.com/-ukhrKTRumL4/TYelBj9fKWI/AAAAAAAAAMc/IaUefusBFa4/s1600/pet+rocks.jpg"));  
            paperImage = ImageIO.read(new URL("https://i5.walmartimages.com/asr/950a3698-948a-4b03-b9a2-749e60647413_1.4159329e4088f2c525b3a0bbf37b3caf.jpeg")); 
            scissorsImage = ImageIO.read(new URL("http://hotshotdeals.com/media/catalog/product/cache/2/image/1200x1200/aa09b53e3ffc514f973fcfacfc971ec1/l/a/laser_scissors_1_.jpg")); 
        } catch (MalformedURLException ex) {
            Logger.getLogger(RockPaperScissors.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RockPaperScissors.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        rockButton.setIcon(new ImageIcon(rockImage));
        paperButton.setIcon(new ImageIcon(paperImage));
        scissorsButton.setIcon(new ImageIcon(scissorsImage));
        
        rockButton.addActionListener(this);
        paperButton.addActionListener(this);
        scissorsButton.addActionListener(this);
        
        rockButton.setPreferredSize(buttonDim);
        paperButton.setPreferredSize(buttonDim);
        scissorsButton.setPreferredSize(buttonDim);
        
        instructionLabel.setText("Choose Your Weapon!");
        
        add(instructionLabel);
        add(rockButton);
        add(paperButton);
        add(scissorsButton);
        
        window.add(this);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.pack();
    }
    
    public static void main(String[] args) {
        new RockPaperScissors().run();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int selection = 0;
        //2. Run the program multiple times. Does the computer always choose the same thing?
        //3. Make oppenentSelection a random number between 0 and 2;
        Random random=new Random();
       int opponentSelection = random.nextInt(3);
       
        //4. Run the program again. Is the result better?
        
        if(e.getSource() == paperButton){
            selection = 1;
        }else if(e.getSource() == scissorsButton){
            selection = 2;
        }
        JOptionPane.showMessageDialog(null, "You chose: " + convertSelection(selection) + ".\n"
                    + "The computer chose: " + convertSelection(opponentSelection) + ".\n");
        
        if(selection == opponentSelection){
            JOptionPane.showMessageDialog(null, "No Winner.  Play again.");
        }else if((selection == 0 && opponentSelection == 2) || 
                 (selection == 1 && opponentSelection == 0) ||
                 (selection == 2 && opponentSelection == 1)){
            JOptionPane.showMessageDialog(null, "You Win!");
        }else{
            JOptionPane.showMessageDialog(null, "You Lose!");
        }
    }
    
    private String convertSelection(int s){
        switch(s){
            case 0: return "ROCK";
            case 1: return "PAPER";
            case 2: return "SCISSORS";
            default: return "";
        }
    }
    
}
