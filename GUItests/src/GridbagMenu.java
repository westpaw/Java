import java.awt.CardLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class GridbagMenu extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	//buttons
	    private JButton newButton, findButton;
	    JPanel panels;

	    public void addComponentToPane(Container pane) {
	        pane.setLayout(new GridBagLayout());
	        GridBagConstraints c = new GridBagConstraints();

	        c.fill = GridBagConstraints.BOTH;

	        createPanels();

	        pane.add(panels, c);
	    }

	    private void createPanels() {
	        JPanel mainMenu = createMainMenu();

	        panels = new JPanel(new CardLayout());
	        panels.add(mainMenu, "mainWindow");
	        panels.add(new JLabel("Add card"), "add");
	        panels.add(new JLabel("Find card"), "find");
	    }

	    private JPanel createMainMenu() {
	        GridBagConstraints c = new GridBagConstraints();
	        c.gridx = GridBagConstraints.REMAINDER;
	        c.fill = GridBagConstraints.BOTH;

	        JPanel mainMenu = new JPanel(new GridBagLayout());

	        // add
	        mainMenu.add(newButton = new JButton("Add"), c);
	        newButton.setActionCommand("new");
	        newButton.addActionListener(this);

	        // find
	        mainMenu.add(findButton = new JButton("Find"), c);
	        findButton.setActionCommand("find");
	        findButton.addActionListener(this);
	        return mainMenu;
	    }

	    public void actionPerformed(ActionEvent e) {
	        CardLayout allpanels = (CardLayout) (panels.getLayout());

	        switch (e.getActionCommand()) {
	        case "new":
	            allpanels.show(panels, "add");
	            break;

	        case "find":
	            allpanels.show(panels, "find");
	            break;
	        }
	    }

	    private static void createGUI() {

	        JFrame frame = new JFrame("Check");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        GridbagMenu contentPane = new GridbagMenu();
	        contentPane.addComponentToPane(frame.getContentPane());
	        frame.pack();
	        frame.setVisible(true);
	    }

	    public static void main(String[] args) {
	        createGUI();
	    }
	
}
