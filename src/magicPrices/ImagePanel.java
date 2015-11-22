package magicPrices;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import javax.swing.*;

class ImagePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8320645107264815060L;
	Image image;
	ImageObserver imageObserver;
	int yOffset = 25;
	int widthToHeightRatio;

	// constructor with filename
	ImagePanel(String filename) {
		ImageIcon icon = new ImageIcon(filename);
		image = icon.getImage();
		imageObserver = icon.getImageObserver();
	}

	// constructor with icon
	ImagePanel(ImageIcon icon) {
		image = icon.getImage();
		imageObserver = icon.getImageObserver();
	}

	ImagePanel(Image inImage) {
		image = inImage;
		ImageIcon imgIcon = new ImageIcon(inImage);
		imageObserver = imgIcon.getImageObserver();
		this.setBounds(0, 0, 250, 200);
		// setSize(image.getWidth(imageObserver),image.getHeight(imageObserver)+yOffset);
	}

	ImagePanel(BufferedImage inImage) {
		image = inImage.getScaledInstance(250, 200, 0);
		this.setBounds(0, 0, 250, 200);
	}

	// overload setIcon method
	void setIcon(ImageIcon icon) {
		image = icon.getImage();
		imageObserver = icon.getImageObserver();
	}

	// overload paint()
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(image, 0, 0, 250, 200, imageObserver);
	}

	public void changeImage(String filename) {
		ImageIcon icon = new ImageIcon(filename);
		image = icon.getImage();
		imageObserver = icon.getImageObserver();
		repaint();
	}
}