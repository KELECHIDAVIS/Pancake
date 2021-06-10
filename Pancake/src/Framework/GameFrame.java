package Framework;

import java.awt.Dimension;

import javax.swing.JFrame;

public abstract class GameFrame extends JFrame 
{
	// this holds everything and everything starts on intialization
	
	public GameFrame(int width, int height, String title, GamePanel panel )
	{
		setTitle(title); 
		//add panel before anything to ensure it is focused for the keylistener
		//GamePanel panel = new GamePanel(); //maybe could make this a variable for better deployment
		add(panel);  //add your own panel when you want to make your own game 
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // this is how it should be set up 
		setSize(new Dimension(width, height)); 
		setLocationRelativeTo(null);
		
		//this.addKeyListener(new Key(panel));
		
	
		
	}
}
