package gui;
import javax.swing.JFrame;
import javax.swing.SwingUtilities; // What is Swing utilities

/**
 *  Driver class for MesonetFrame
 * 
 * @author Aria Lewis
 * @version 2018-12-3
 */
public class FrameDriver 
{
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			
			public void run()
			{
				new MesonetFrame();
			}
		});
	}

}
