package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import javafx.scene.layout.Border;

/**
 * Shows that elements where users will select statistics type
 * @author Aria Lewis
 * @version 2018-12-3
 */
public class StatisticsPanel extends JPanel implements ActionListener
{

	/**
	 * Make a JPanel for the Parameter options
	 */
	private static final long serialVersionUID = 1L;
	JRadioButton min;
	JRadioButton max;
	JRadioButton avg;

	TitledBorder tborder;
	ButtonGroup boxesGroup;
	// Contains a JRadioButton and GridLayout
	// Implement the layout of the components
	
	public StatisticsPanel()
	{
		setBackground(new Color(169,169,169));
		setPreferredSize( new Dimension( 40, 480 ));
		
		tborder = new TitledBorder("Statistics");	
		tborder.setTitleJustification(TitledBorder.LEFT);
		tborder.setTitlePosition(TitledBorder.TOP);
		//paintBorder(tborder, new Graphics(), x, y, width, height);
		
		setBorder(tborder);
		
		setLayout(new GridLayout(3, 1));
		
		/** add checkbox buttons **/
		min = new JRadioButton("MINIMUM");
		avg = new JRadioButton("AVERAGE");
		max = new JRadioButton("MAXIMUM");
		
		
		/** Create groupbutton for checkboxes **/
		boxesGroup = new ButtonGroup();
		
		/** add checkboxes to buttongroup **/
		boxesGroup.add(min);
		boxesGroup.add(avg);
		boxesGroup.add(max);
		
		
		min.setBackground(new Color(169,169,169));
		avg.setBackground(new Color(169,169,169));
		max.setBackground(new Color(169,169,169));
		
		add(min);
		add(avg);
		add(max);
		setPreferredSize( new Dimension( 40, 480 ));

	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
	
		JButton clicked = (JButton)e.getSource();
			
			//if(clicked == checkBox) then tell the program to save param

	}
	
}
