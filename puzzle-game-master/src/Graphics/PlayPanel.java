package Graphics;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Config.*;
import Model.Board;
import Model.Location;
import Model.Mapper;
import Model.PuzzlePiece;
public class PlayPanel extends JPanel{

	private  int width;
	private  int height;

	private Drawer drawer;
	private PanelConfig PanelConfig;
	private static PlayPanel play;
	private PlayPanel() {
		setPreferredSize(new Dimension(width, height));		
		PanelConfig = new PanelConfig("GAMEPANEL_CONFIG_FILE");
        configurePanel();
	}
	
    private void configurePanel() {
  
        this.setSize(PanelConfig.getWidth(), PanelConfig.getHeight());
    }
	
	
	public static PlayPanel  getinsist() {
		if(play==null)
			play=new PlayPanel();
		return play;
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawer=new Drawer((Graphics2D)g);
			drawer.drawImage();	
		}
}
