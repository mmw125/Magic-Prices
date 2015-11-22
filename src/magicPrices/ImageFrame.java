package magicPrices;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.*;

class ImageFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image image;
	ImageObserver imageObserver;
	int yOffset = 25;
	int widthToHeightRatio;

	// constructor with filename
	ImageFrame(String filename) {
		ImageIcon icon = new ImageIcon(filename);
		image = icon.getImage();
		imageObserver = icon.getImageObserver();
	}

	// constructor with icon
	ImageFrame(ImageIcon icon) {
		image = icon.getImage();
		imageObserver = icon.getImageObserver();
	}

	ImageFrame(Image inImage) {
		image = inImage;
		widthToHeightRatio = image.getWidth(imageObserver)
				/ image.getWidth(imageObserver);
		ImageIcon imgIcon = new ImageIcon(inImage);
		imageObserver = imgIcon.getImageObserver();
		setSize(image.getWidth(imageObserver), image.getHeight(imageObserver)
				+ yOffset);
		setResizable(false);
	}

	// overload setIcon method
	void setIcon(ImageIcon icon) {
		image = icon.getImage();
		imageObserver = icon.getImageObserver();
	}

	// overload paint()
	public void paint(Graphics g) {
		super.paint(g);

		g.drawImage(image, 0, yOffset, getWidth(), getHeight() - yOffset,
				imageObserver);
	}

	public void changeImage(String filename) {
		ImageIcon icon = new ImageIcon(filename);
		image = icon.getImage();
		imageObserver = icon.getImageObserver();
		repaint();
	}
}