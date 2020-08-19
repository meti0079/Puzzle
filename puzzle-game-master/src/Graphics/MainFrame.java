package Graphics;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Config.FrameConfig;
import Listener.MyListener;

public class MainFrame	extends JFrame{
	private FrameConfig config;
	public MainFrame() {
		setLocationRelativeTo(null);
		addKeyListener(new MyListener());
		PlayPanel p=PlayPanel.getinsist();
		add(p);
		setVisible(true);
		initFrame();
		pack();
	}

	private void initFrame() {
		try {
			config = new FrameConfig("FRAME_CONFIG_FILE");
			this.ConfigFrame();
			this.setLocationRelativeTo(null);
			this.setVisible(true);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void ConfigFrame() {
		this.setPreferredSize(new Dimension(config.getWidth(), config.getHeight()));
		this.setDefaultCloseOperation(3);
		this.setResizable(config.isResizable());
	}
}