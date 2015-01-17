package gui;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import actions.ActionManager;

public class Palette extends JToolBar {
	public Palette() {
		super(SwingConstants.VERTICAL);
		setFloatable(true);
		
		
		ClassLoader cl = this.getClass().getClassLoader();
		add(ActionManager.getAction().getSelAction());
		add(ActionManager.getAction().getPutRect());
		add(ActionManager.getAction().getPutCircle());
		add(ActionManager.getAction().getPutTriangle());
		add(ActionManager.getAction().getPutStar());
		
	}
}
