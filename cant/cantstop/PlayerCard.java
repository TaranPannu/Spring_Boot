import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.util.*;

import javax.imageio.ImageIO;

public class PlayerCard extends JPanel{
    String colorSelected;
    JLabel playerLabel;
    JLabel playerNum;
    BufferedImage player;
    JTextField PlayerName;
    String[] diffi = {"Level","Easy","Hard"};
    String[] Colour = {"Color", "red", "blue","yellow","green"};

    JComboBox<String> diff = new JComboBox<>(diffi); 
    JComboBox<String> color = new JComboBox<>(Colour);
    JCheckBox confirm = new JCheckBox();
       

    public PlayerCard(Set<String> AlreadySelectedcolor){
        this.setPreferredSize(new Dimension(200,200));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.LIGHT_GRAY);

        confirm.setText("Computer Player");
        player = null;
        playerLabel = new JLabel();
        PlayerName=new JTextField();
        // when checkbox is selected.
        confirm.addActionListener(i->{
            this.setBackground(Color.LIGHT_GRAY);
            this.remove(diff);
            if(confirm.isSelected())
{            this.setBackground(Color.GRAY);
    difficulty();
}
        });

        //When player will select color
        color.addActionListener(i->{
          colorSelected=(String)color.getSelectedItem();
            try{
                if(AlreadySelectedcolor.add(colorSelected))
                player = ImageIO.read(new File("assets/" +colorSelected+"man.png"));
                else
                player = ImageIO.read(new File("assets/" +"whiteman.png"));
                
            }
            catch(Exception f){
                System.out.println("Error: File not Found");
            }
             playerLabel.setIcon(new ImageIcon(player)); 
         this.add(playerLabel);
         SwingUtilities.updateComponentTreeUI(this);
         this.invalidate();
         this.validate();
         this.repaint();
        });
        
        //default white color of user.
        try{
            player = ImageIO.read(new File("assets/" +"whiteman.png"));
        }
        catch(Exception f){
            System.out.println("Error: File not Found");
        }


        playerLabel.setIcon(new ImageIcon(player)); 
        playerNum = new JLabel(PlayerName.getText());
        this.add(playerNum);
        this.add(confirm);
        this.add(color);
        this.add(playerLabel);
       // PlayerName.setPreferredSize(new Dimension(100,5));
        this.add(PlayerName);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private void difficulty() {   
   this.add(diff);
   SwingUtilities.updateComponentTreeUI(this);
         this.invalidate();
         this.validate();
         this.repaint();
    }
   
 String getPlayerName()
{
   return PlayerName.getText(); 
}
String getPlayercolor(){
    return colorSelected;
}
String getPlayerLevel(){
    return (String)diff.getSelectedItem();
}
boolean isComputerPlayer()
{
    return confirm.isSelected();
}
}