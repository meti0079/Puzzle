import javax.imageio.ImageIO;
import javax.swing.*;

import Graphics.MainFrame;
import Graphics.PlayPanel;
import Model.Mapper;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args){
		Config.ConfigLoader urls = Config.ConfigLoader.getInstance(getConfigFile(args));
		Mapper p =Mapper.getinsist();
		
	
	}
	  private static String getConfigFile(String[] args) {
	        String configAddress = "default";
	        if (args.length > 1) {
	            configAddress = args[0];
	        } else {
//	            System.out.println(S);
	            if (System.getenv("PUZZLE_ CONFIG") != null && !System.getenv("PUZZLE_ CONFIG").isEmpty()) {
	                configAddress = System.getenv("PUZZLE_ CONFIG");
	            }
	        }
	        return configAddress;
	    }
}
