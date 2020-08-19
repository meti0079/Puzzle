package Model;

import javax.swing.JOptionPane;

import Graphics.MainFrame;
import Graphics.PlayPanel;

public class Mapper {
	private static Mapper map;
	private MainFrame frame;
	private PlayPanel playPanel;
	private Board board;


	private Mapper() {
		frame=new MainFrame();
		board=new Board();
		playPanel=playPanel.getinsist();
	}
	public static Mapper getinsist() {
		if(map==null) {
			map=new Mapper();
		}
		return map;
	}
	public void moveRight() {
		if (board.getMissingPiece()% 3 == 2) {
			return;
		}
		board.swapPieces(board.getMissingPiece(),board.getMissingPiece() + 1);
		board.setMissingPiece(board.getMissingPiece() + 1);
		playPanel.repaint();
		gameFinished();
	}
	public void moveLeft() {
		if (board.getMissingPiece() % 3 == 0) {
			return;
		}
		board.swapPieces(board.getMissingPiece(),board.getMissingPiece() - 1);
		board.setMissingPiece(board.getMissingPiece() - 1);
		playPanel.repaint();
		gameFinished();
	}
	public void moveUp() {
		if (board.getMissingPiece() <= 2) {
			return;
		}
		board.swapPieces(board.getMissingPiece(), board.getMissingPiece() - 3);
		board.setMissingPiece(board.getMissingPiece() - 3);
		playPanel.repaint();
		gameFinished();
	}
	public void moveDown() {
		if (board.getMissingPiece() >= 6) {
			return;
		}
		board.swapPieces(board.getMissingPiece(),board.getMissingPiece() + 3);
		board.setMissingPiece(board.getMissingPiece() + 3);
		playPanel.repaint();
		gameFinished();
	}


	public void gameFinished() {
		for (int i = 0; i < 9; i++) {
			int pieceIdentifier = board.getpuzzlepiece(i).getPieceNumber();
			if (pieceIdentifier == 8) {
				continue;
			}
			if (pieceIdentifier != i) {
				return ;
			}
		}
		JOptionPane.showMessageDialog(null, "You finished the game, congratulation", "game finished", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}
}
