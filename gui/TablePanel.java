package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

/**
 * Shows selected information and associated statistics
 * @author Aria Lewis
 * @version 2 18-12-3
 */
public class TablePanel extends JPanel
{

	/**
	 * Displays Statistics
	 */
	private static final long serialVersionUID = 1L;

	JTable table;
	JScrollPane scroller;
	String data[][];
	// Use BorderLayout
	// Implements layout of components

	
	public TablePanel()
	{
		
		// Make header row and read data rows in 
		String header[] = {"Station", "Parameter", "Statistics", "Value", 
				"Reporting Stations", "Date"};
		
		// Create enough room for headers
		String data[][] = new String[25][6];
			
		table = new JTable(data, header);
		
		table.setBounds(0,0,200,300);          
	    scroller = new JScrollPane(table);    
	    add(scroller);              
	    setVisible(true);
 		table.setGridColor(Color.WHITE);
	}
	
}
