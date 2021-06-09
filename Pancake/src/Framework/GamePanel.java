package Framework;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import Framework.audio.Audio;

public class GamePanel extends JPanel implements Runnable, KeyListener, MouseListener
{
	//this is where you are going to draw and render all your objects and images
	//this is also where the game loop will be
	// the while loop will be in the run method 
	
	private Thread gameThread ; 
	//private int UPS = 0;     for fps counter
	//private Audio clapSound; // a test sound 
	public GamePanel()
	{
		this.addKeyListener(this); 
		this.addMouseListener(this); 
		this.setFocusable(true);
		this.setBackground(Color.BLACK);// background color 
		
		//sounds are initialized
		initSounds(); 
		
		
		
		
		
	}
	
	public void initSounds() // initializes all the sounds 
	{
		// put sounds here with the
	}
	
	@Override
	public void run() // main game loop 
	{
		long lastTime = System.nanoTime() ; 
		long timer = System.currentTimeMillis(); 
		
		final double ns = 1000000000.0/ 60.0; 
		double delta = 0; 
		int frames=0;
		int updates = 0; 
		while(true)
		{
			
			long now = System.nanoTime(); 
			delta += (now-lastTime)/ns; 
			lastTime=now; 
			while(delta>=1)
			{
				update(); 
				updates++; 
				delta--; 
			}
			
			frames++; 
			
			if(System.currentTimeMillis()-timer>1000)
			{
				repaint(); 
				timer+=1000; 
				 // Updates per seconds
				frames=0; 
				updates=0; 
				
			}
		}
	}
	
	
	
	
	public void update() // function that handles game logic ;  gets called 60 times per second 
	{
		
		
	}
	
	public void paint(Graphics g ) // this is the function where you render your shapes and images
	{
		super.paint(g);
		/*
		 * this is for fps counter
		
		g.setFont(new Font("Sans Seriff", Font.BOLD, 15));
		g.setColor(Color.gray);
		g.drawString("FPS: "+UPS, 0,14);*/ 
		 
	}



	
	//These three methods are the keylisteners use keypressed for movement 
	@Override
	public void keyTyped(KeyEvent e)
	{
		
		
	}



	@Override
	public void keyPressed(KeyEvent e)
	{
		
		
	}



	@Override
	public void keyReleased(KeyEvent e)
	{
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
	
		
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		
		
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		
		
	}

}
