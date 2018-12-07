package gui;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import javafx.scene.layout.Border;

/**
 * hows that elements where users will select parameters
 * @author Aria Lewis
 * @version 2018-12-3
 *
 */
public class ParameterPanel extends JPanel implements ActionListener
{
	
	
	/**
	 * Make a JPanel for the Parameter options
	 */
	private static final long serialVersionUID = 1L;
	JCheckBox tair;
	JCheckBox ta9m;
	JCheckBox srad;
	JCheckBox wspd;
	JCheckBox pres;
	
	TitledBorder tborder;
	ButtonGroup boxesGroup;
	// Contains a JCheckBox and GridLayout
	// Implement the layout of the components
	
	public ParameterPanel()
	{
		setBackground(new Color(128,128,128));
		
		tborder = new TitledBorder("Parameter");	
		tborder.setTitleJustification(TitledBorder.LEFT);
		tborder.setTitlePosition(TitledBorder.TOP);
		//paintBorder(tborder, new Graphics(), x, y, width, height);
		
		setBorder(tborder);
		
		setLayout(new GridLayout(5, 1));
		
		/** add checkbox buttons **/
		tair = new JCheckBox("TAIR");
		ta9m = new JCheckBox("TA9M");
		srad = new JCheckBox("SRAD");
		wspd = new JCheckBox("WSPD");
		pres = new JCheckBox("PRES");
		
		
		tair.setBackground(new Color(128,128,128));
		ta9m.setBackground(new Color(128,128,128));
		srad.setBackground(new Color(128,128,128));
		wspd.setBackground(new Color(128,128,128));
		pres.setBackground(new Color(128,128,128));
		
		add(tair);
		add(ta9m);
		add(srad);
		add(wspd);
		add(pres);
	
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
	
		JButton clicked = (JButton)e.getSource();
			
			//if(clicked == checkBox) then tell the program to save param

	}
}
