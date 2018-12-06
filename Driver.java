import java.io.IOException;

import javax.swing.SwingUtilities;

import gui.MesonetFrame;

public class Driver {

	/**
	 * @author Aria Lewis
	 * @version 10/18/2018
	 * 
	 * Project 3
	 * 
	 * Driver and main 
	 */
	public static void main(String[] args) throws IOException 
	{
		
		// Call MapData class
		final int YEAR = 2018;
		final int MONTH = 8;
		final int DAY = 30;
		final int HOUR = 17;
		final int MINUTE = 45;
	
		// Direct to data folder
		final String directory = "data";
	
		// Create new MapData object
		MapData mapData = new MapData(YEAR, MONTH, DAY, HOUR, MINUTE, directory);
		
		// Output of mapData
		//System.out.println(mapData);
		
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run() {
                new MesonetFrame();
            }
        });



	}
	
}
