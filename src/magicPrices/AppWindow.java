package magicPrices;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class AppWindow {

	private JFrame frame;
	private int numOfData;
	JPanel panel;
	JScrollPane scrollPane;
	int frameHeight = 200;
	int frameWidth = 650;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppWindow window = new AppWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AppWindow() {
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 537, 507);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

		panel = new JPanel();
		panel.setPreferredSize(new Dimension(500, 100));
		scrollPane.setViewportView(panel);
		panel.setLayout(null);

		numOfData = 0;
	}

	public void addData(String[] data, final String set, final int number) {
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.black);
		// panel_1.setBounds(new Rectangle(0, 100*numOfData, 500, 100));
		panel_1.setAlignmentY(Component.TOP_ALIGNMENT);
		panel_1.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel_1.setBounds(0, frameHeight * numOfData, frameWidth, frameHeight);
		panel_1.setPreferredSize(new Dimension(frameWidth, frameHeight));
		panel.add(panel_1);
		// panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		panel_1.setLayout(null);
		JPanel cardNameContainer = new JPanel();
		panel_1.add(cardNameContainer);
		cardNameContainer.setLayout(new GridLayout(0, 1, 0, 0));
		JLabel lblCardname = new JLabel(data[0]);
		lblCardname.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCardname.setHorizontalAlignment(SwingConstants.CENTER);
		cardNameContainer.add(lblCardname);
		cardNameContainer.setBounds(0, 0, 300, frameHeight);

		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		// panel_3.setLayout(new GridLayout(1, 0, 0, 0));
		panel_3.setLayout(new GridLayout(1, 1));
		panel_3.setBounds(300, 0, 100, frameHeight);
		// JLabel lblCardname = new JLabel("CardName");

		String basicWebAddress = "http://magiccards.info/scans/en/";
		URL url = null;
		try {
			url = new URL(basicWebAddress + set + "/" + number + ".jpg");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		BufferedImage image = null;
		try {
			image = ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// BufferedImage buffImg = (BufferedImage) image;
		image = image.getSubimage(19, 46, 275, 202);
		// image = (Image) buffImg;
		ImagePanel pan = new ImagePanel(image);
		pan.setBounds(400, 0, 250, 200);
		// frame.setVisible(true);
		panel_1.add(pan);

		// JLabel lblNewLabel = new JLabel("priceLow");
		JLabel lblNewLabel = new JLabel(data[1]);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		// panel_3.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel(data[2]);
		// JLabel lblNewLabel_1 = new JLabel("priceMid");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_1);

		// JLabel lblNewLabel_2 = new JLabel("priceHigh");
		JLabel lblNewLabel_2 = new JLabel(data[3]);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		// panel_3.add(lblNewLabel_2);

		numOfData++;
		panel.setPreferredSize(new Dimension(frameWidth, numOfData * frameHeight));
		frame.invalidate();
		frame.validate();
	}
}