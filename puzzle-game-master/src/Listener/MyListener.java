package Listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import Graphics.PlayPanel;
import Model.Board;
import Model.Mapper;

public class MyListener implements KeyListener {

	@Override
	public void keyTyped(KeyEvent keyEvent) {
	}
	@Override
	public void keyPressed(KeyEvent keyEvent) {


		if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
			Mapper.getinsist().moveRight();
		} else if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
			Mapper.getinsist().moveLeft();
		} else if (keyEvent.getKeyCode() == KeyEvent.VK_UP) {
			Mapper.getinsist().moveUp();
		} else if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
			Mapper.getinsist().moveDown();	
		}
	}
	@Override
	public void keyReleased(KeyEvent keyEvent) {

	}
}
