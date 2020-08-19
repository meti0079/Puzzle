package Graphics;

import java.awt.Graphics2D;

import Model.Mapper;
import Model.PuzzlePiece;

public class Drawer {

	private Graphics2D g2;
	public Drawer(Graphics2D g) {
		setGraphics2D(g);
	}
	 void drawImage() {
		 for (PuzzlePiece piece : Mapper.getinsist().getBoard().getalpiece()) {
	        g2.drawImage(piece.getImage(),
	                (int) piece.getLocation().getX(),
	                (int) piece.getLocation().getY(),150,
	               150, null);
	    }
	 }
	   void setGraphics2D(Graphics2D graphics2D) {
	        this.g2 = graphics2D;
	    }
}
