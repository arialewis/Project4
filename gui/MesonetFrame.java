package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import com.sun.glass.ui.Menu;
import com.sun.glass.ui.MenuBar;
import java.io.*;
import MapData.MapData;;

/**
 * Primary window of the interface
 * 
 * @author Aria Lewis
 * @version 2018-12-3
 *
 */

public class MesonetFrame extends JFrame
{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FileMenuBar fmenuBar;
	private JPanel title;
	private JLabel titleLable;
	private StatisticsPanel statsPanel;
	private ParameterPanel paramPanel;
	private TablePanel tablePanel;
	private JPanel buttonHolder;
	private JButton calculate;
	private JButton exit;
	MapData stats;
	
	/**
	 *  Complete the menu creation process and the impementatio of the open menu listener
	 *  
	 *
	 */
	public class FileMenuBar extends JMenuBar
	{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		private JMenu menu;
		
		/**
		 * Creates panel showing File options
		 */

			// Add menu to menu bar
			
			public FileMenuBar()
			{
				menu = new JMenu("Files");
				add(menu);
				//super.add(menu, BorderLayout.WEST);
				//setLayout(new BorderLayout());
				//add menuItems to Files Menu
				menu.add(new JMenuItem("Open Data Files"));
				menu.add(new JMenuItem("Exit"));
				// add here?
			
			}
			
	}
	
	
	public MesonetFrame()
	{
		super("Oklahoma Mesonet - Statistics Calculator");
		setLayout(new BorderLayout()); // NWSE and Center, important
		
		// Create menubar and add to frame
		fmenuBar = new FileMenuBar();
		setJMenuBar(fmenuBar);
		
		// Add title panel
		title = new JPanel();
		title.setBackground(new Color(211,211,211));
		titleLable = new JLabel("Mesonet - We don't set records, we just report them!");
		title.add(titleLable);
		add(title, BorderLayout.NORTH);
		
		// Add other panels to frame
		statsPanel = new StatisticsPanel();
		paramPanel = new ParameterPanel();
		tablePanel = new TablePanel();
		buttonHolder = new JPanel();
	
		// create buttons for buttonholder jpanel
		calculate = new JButton("Calculate");
		exit = new JButton("Exit");
	
		// add buttons to jpanel
		buttonHolder.add(calculate);
		buttonHolder.add(exit);
		
		// add panels to frame
		add(tablePanel, BorderLayout.EAST);
		add(paramPanel, BorderLayout.WEST);
		add(statsPanel, BorderLayout.CENTER);

		add(buttonHolder, BorderLayout.SOUTH);
		
	
		
		fmenuBar.getMenu(0).getItem(0).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
 				File f = new File("C:\\Users\\alewi\\Documents\\data");
				JFileChooser chooser = new JFileChooser(f, FileSystemView.getFileSystemView());
				//chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("MDF files", "MDF");
				chooser.setFileFilter(filter);
				chooser.setDialogTitle("Open");
	
			
			
				//chooser.addChoosableFileFilter(filter);

				int returnValue = chooser.showOpenDialog(null);
				
				if (returnValue == JFileChooser.APPROVE_OPTION)
				{
				//	File filename = new File(chooser.getSelectedFile(), null);
				}
	           	
            } 
        }); 
		
		calculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
 
				
	           	
            } 
        }); 
	
		exit.
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
	}
	
}
