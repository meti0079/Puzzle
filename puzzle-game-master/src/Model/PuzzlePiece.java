package Model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
public class PuzzlePiece {
	private Image img;
	public Location location;

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	private int pieceNumber;

	public int getPieceNumber() {
		return pieceNumber;
	}

	public void setPieceNumber(int pieceNumber) {
		this.pieceNumber = pieceNumber;
	}

	private PuzzlePiece(String imageName) {
		try {
			img = ImageIO.read(new File("src/assets/" + imageName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (!imageName.equals("missing.jpg")) {
			pieceNumber = Integer.parseInt(imageName.substring(0, 1)) - 1;
		} else {
			pieceNumber = 8;
		}
	}

	public PuzzlePiece(String ImagePath, Model.Location location2) {
		this(ImagePath);
		this.location =  location2;
	}

	private PuzzlePiece(Image img, Location location, int pieceIdentifier) {
		this.img = img;
		this.location = location;
		this.pieceNumber = pieceIdentifier;
	}


	public Image getImage() {
		return img;
	}

	public void setImage(Image img) {
		this.img = img;
	}

	public PuzzlePiece getClone() {
		PuzzlePiece clone = new PuzzlePiece(img, location, pieceNumber);

		return clone;
	}
}
