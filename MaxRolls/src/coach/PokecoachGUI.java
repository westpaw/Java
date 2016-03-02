package coach;

import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


public class PokecoachGUI
{
	
	private JFrame frame;
	
	private final static boolean shouldFill = true;
	private final static boolean shouldWeightX = true;
	private final static boolean RIGHT_TO_LEFT = false;
	
	public PokecoachGUI()
	{
		frame = new JFrame("Pokécoach");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.makeComponents(frame.getContentPane());
		frame.pack();
	}
	
	public void makeComponents(Container pane)
	{
		if(RIGHT_TO_LEFT)
			pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		JButton button;
		JPopupMenu popupMenu;
		JtextField textField;
		JTextArea textArea; //however to make a static text label
		JImage image;
		JTable table;
		
		//make all needed JComps
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		if(shouldFill)
		{
			//natural height, maximum width
			c.fill = GridBagConstraints.HORIZONTAL;
		}
		
	}
	
	

}
