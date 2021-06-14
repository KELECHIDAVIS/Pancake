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

public abstract class GamePanel extends JPanel implements Runnable, KeyListener, MouseListener
{
	//this is where you are going to draw and render all your objects and images
	//this is also where the game loop will be
	// the while loop will be in the run method 
	
	protected Thread gameThread = new Thread(this); 
	public double UPS = 60.0; 
	protected int SCREENH, SCREENW; 
	
	public GamePanel()
	{
		this.addKeyListener(this); 
		this.addMouseListener(this); 
		this.setFocusable(true);
		this.setBackground(Color.BLACK);// background color 
		
		//sounds are initialized
		initSounds(); 
		
		
		
		
		
	}
	
	public void start()
	{
		gameThread.start();
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
		
		final double ns = 1000000000.0/ UPS; 
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
				repaint(); 
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
	
	
	
	
	public abstract void update();
	
	public abstract void paint(Graphics g );



	
	//These three methods are the keylisteners use keypressed for movement 
	@Override
	public abstract void keyTyped(KeyEvent e); 



	@Override
	public abstract void keyPressed(KeyEvent e);



	@Override
	public abstract void keyReleased(KeyEvent e);

	@Override
	public abstract void mouseClicked(MouseEvent e);

	@Override
	public  abstract void mousePressed(MouseEvent e);

	@Override
	public  abstract void mouseReleased(MouseEvent e);

	@Override
	public  abstract void mouseEntered(MouseEvent e);

	@Override
	public  abstract void mouseExited(MouseEvent e);

}
