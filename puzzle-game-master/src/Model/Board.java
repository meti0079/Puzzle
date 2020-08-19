package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;
import java.util.Random;

import javax.swing.JOptionPane;

import Config.ConfigLoader;
import Config.*;



public class Board {
	PuzzlePiece [] board=new PuzzlePiece[9];

	private int missingPiece = 0;
	private int a,b,c,d,f,g,h,k,m;
	private int pw;
	private Configs properties ;
	ArrayList<Integer> piecesRandomOrder = new ArrayList<>();
	public Board() {
		Random ran=new Random();
		String name="";
		int co=ran.nextInt(7);
		if(co==0) {
			name="Constants";	
		}else {
			name="Constants"+co;
		}
		if(name.equalsIgnoreCase("Constants")) {
			properties = ConfigLoader.getInstance().getProperties("Constants");			
		}else if(name.equalsIgnoreCase("Constants1")) {
			properties = ConfigLoader.getInstance().getProperties1("Constants1");			
		}else if(name.equalsIgnoreCase("Constants2")){
			properties = ConfigLoader.getInstance().getProperties2("Constants2");				
		}else if(name.equalsIgnoreCase("Constants3")) {
			properties = ConfigLoader.getInstance().getProperties3("Constants3");			
		}else if(name.equalsIgnoreCase("Constants4")) {
			properties = ConfigLoader.getInstance().getProperties4("Constants4");			
		}else if(name.equalsIgnoreCase("Constants5")) {
			properties = ConfigLoader.getInstance().getProperties5("Constants5");			
		}else if(name.equalsIgnoreCase("Constants6")) {
			properties = ConfigLoader.getInstance().getProperties6("Constants6");			
		}

		initConstane();
		boolean gameFinished = false;
		if (!solvable(getMissingPiece(), piecesRandomOrder)){
			JOptionPane.showMessageDialog(null, "this puzzle is not solvable, change your config and try again", "Puzzle not solvable", JOptionPane.WARNING_MESSAGE);
			gameFinished = true;
		}
		int j=0;
		int k=0;
		for (int i = 0; i < 9; i++) {
			if (getMissingPiece() != i) {
				board[i]=(new PuzzlePiece((piecesRandomOrder.get(i) + 1) + ".png", new Location(pw*k,pw*j)));
			} else {
				board[i]=(new PuzzlePiece("missing.jpg",  new Location(pw*k,pw*j)));
			}
			if(k==2) {
				j++;
				k=0;
			}else
				k++;	
		}

	}
	public void initConstane() {
		this.a=this.getConstant("a");
		//		System.out.println(a);
		this.b=this.getConstant("b");
		this.c=this.getConstant("c");
		this.d=this.getConstant("d");
		this.f=this.getConstant("f");
		this.g=this.getConstant("g");
		this.h=this.getConstant("h");
		this.k=this.getConstant("k");
		this.m=this.getConstant("m");
		this.pw=this.getConstant("pw");
		piecesRandomOrder.add(a);
		piecesRandomOrder.add(b);
		piecesRandomOrder.add(c);
		piecesRandomOrder.add(d);
		piecesRandomOrder.add(f);
		piecesRandomOrder.add(g);
		piecesRandomOrder.add(h);
		piecesRandomOrder.add(k);
		piecesRandomOrder.add(m);
		for(int i=0;i<9;i++) {
			if(piecesRandomOrder.get(i)==8) {
				setMissingPiece(i);
			}
		}
	}
	public PuzzlePiece [] getalpiece() {
		return board;
	}


	public void setMissingPiece(int missingPiece) {
		this.missingPiece = missingPiece;
	}

	public int getMissingPiece() {
		return missingPiece;
	}

	private static boolean solvable(int missingPiece, ArrayList<Integer> piecesOrder) {
		int inversionCount = 0;
		for (int i = 0; i < piecesOrder.size(); i++) {
			for (int j = i + 1; j < piecesOrder.size(); j++) {
				if (piecesOrder.get(i) > piecesOrder.get(j)) {
					inversionCount += 1;
				}
			}
		}
		int parity = inversionCount % 2;
		int  distanceOfMissingPiece = (2 - (missingPiece % 3)) + (2 - (missingPiece / 3));
		parity ^= (distanceOfMissingPiece % 2);
		if (parity == 0) {
			return true;
		}
		return false;
	}
	public void swapPieces(int i, int j) {
		PuzzlePiece copy = this.board[i].getClone();
		board[i].setImage(board[j].getImage());
		board[i].setPieceNumber(board[j].getPieceNumber());
		board[j].setImage(copy.getImage());
		board[j].setPieceNumber(copy.getPieceNumber());

	}
	public PuzzlePiece getpuzzlepiece(int x) {
		return board[x];
	}
	public int getConstant(String name){
		return properties.readInteger(name);
	}

}
