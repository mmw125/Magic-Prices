package magicPrices;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class CardGrid {

        JFrame frame;
        public static void main(String[] args) {
				new CardGrid();
        }
        CardGrid(){
                frame = new JFrame();
                frame.setVisible(true);
                String basicWebAddress = "http://magiccards.info/scans/en/";
                for(int i = 1; i < 249; i++)
                {
                	URL url = null;
                    try {
                            url = new URL(basicWebAddress+"dtk"+"/"+i+".jpg");
                    } catch (Exception e) {
                            
                            e.printStackTrace();
                    }
                    BufferedImage image = null;
                    try {
                            image = ImageIO.read(url);
                    } catch (IOException e) {
                            e.printStackTrace();
                    }
                    //BufferedImage buffImg = (BufferedImage) image;
                    image = image.getSubimage(19, 46, 275, 202);
                    //image = (Image) buffImg;
                    ImagePanel pan = new ImagePanel(image);
                    pan.setBounds(400, 0, 250, 200);
                    //frame.setVisible(true);
                    //panel_1.add(pan); 
                }
                
        }

}