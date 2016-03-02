package structures;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Menu extends JFrame implements ActionListener
{
	private static final int WINDOW_WIDTH = 480;

	private static final int WINDOW_LENGTH = 640;

	private static final int MAIN = 0;

	private static final int LAB = 1;

	private static final int BATTLE = 2;

	private static final int CALC = 3;

	private JButton lab , battle , calc , save;

	private JPanel deck;

	public void addComponentToPane(Container pane)
	{
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		c.fill = GridBagConstraints.BOTH;

		createPanels();

		pane.add(deck , c);
	}

	private void createPanels()
	{
		JPanel mainMenu = createMenu(MAIN);
		JPanel labMenu = createMenu(LAB);
		JPanel battleMenu = createMenu(BATTLE);
		JPanel calcMenu = createMenu(CALC);

		deck = new JPanel(new CardLayout());
		deck.add(mainMenu , "mainWindow");
		deck.add(labMenu , "labWindow");
		deck.add(battleMenu , "battleWindow");
		deck.add(calcMenu , "calcWindow");
	}

	private JPanel createMenu(int t)
	{
		GridBagConstraints c = new GridBagConstraints();
		JPanel menu = new JPanel(new GridBagLayout());
		if(t == MAIN)
			menu = createMainMenu(menu , c);
		else if(t == LAB)
			menu = createLabMenu(menu , c);
		else if(t == BATTLE)
			menu = createBattleMenu(menu , c);
		else if(t == CALC)
			menu = createCalcMenu(menu , c);
		return menu;
	}

	private JPanel createMainMenu(JPanel mainMenu , GridBagConstraints c)
	{
		// button to generator
		mainMenu.add(lab = new JButton("Create") , c);
		lab.setActionCommand("lab");
		lab.addActionListener(this);

		// button to random battle 
		mainMenu.add(battle = new JButton("Battle") , c);
		battle.setActionCommand("battle");
		battle.addActionListener(this);

		// button to battle calculator
		mainMenu.add(calc = new JButton("Calculate") , c);
		calc.setActionCommand("calc");
		calc.addActionListener(this);
		return mainMenu;
	}

	private JPanel createLabMenu(JPanel labMenu , GridBagConstraints c)
	{
		//lab components
		labMenu.add(save = new JButton("Save and Return to Main Menu") , c);
		lab.setActionCommand("main");
		lab.addActionListener(this);
		return labMenu;
	}

	private JPanel createBattleMenu(JPanel battleMenu , GridBagConstraints c)
	{
		//battle components
		battleMenu.add(save = new JButton("Save and Return to Main Menu") , c);
		lab.setActionCommand("main");
		lab.addActionListener(this);
		return battleMenu;
	}

	private JPanel createCalcMenu(JPanel calcMenu , GridBagConstraints c)
	{
		//calc components
		calcMenu.add(save = new JButton("Save and Return to Main Menu") , c);
		lab.setActionCommand("main");
		lab.addActionListener(this);
		return calcMenu;
	}

	public void actionPerformed(ActionEvent e)
	{
		CardLayout allpanels = (CardLayout) (deck.getLayout());

		switch (e.getActionCommand())
		{
			case "lab":
				System.out.println("l");
				allpanels.show(deck , "labWindow");
				break;

			case "battle":
				allpanels.show(deck , "battleWindow");
				break;

			case "calc":
				allpanels.show(deck , "calcWindow");
				break;

			case "main":
				System.out.println("m");
				//save work method
				allpanels.show(deck , "mainWindow");
				break;
		}
	}

	private static void createGUI()
	{
		JFrame frame = new JFrame("PokéApps");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(WINDOW_LENGTH , WINDOW_WIDTH));

		Menu contentPane = new Menu();
		contentPane.addComponentToPane(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args)
	{
		createGUI();
	}

}
