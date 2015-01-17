package actions;

import gui.Frame;

import java.awt.event.ActionEvent;
import java.beans.PropertyVetoException;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public class CascadeWindowsAction extends AbstractAction {

	public CascadeWindowsAction() {
		ClassLoader cl = this.getClass().getClassLoader();

		putValue(NAME, "Cascade Windows");
		putValue(SMALL_ICON,
				new ImageIcon(cl.getResource("cascadeWindows.png")));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("shift C"));
		putValue(ACTION_COMMAND_KEY, "Cascade Windows");
		putValue(SHORT_DESCRIPTION, "Cascade Windows");

	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("Action [" + e.getActionCommand() + "] performed!");

		int n = Frame.getInstance().getDesk().getAllFrames().length; 
																		
																		

		int fvisina = Frame.getInstance().getDesk().getHeight() / 2;
		int fsirina = Frame.getInstance().getDesk().getWidth() / 2;

		if (n >= 1) {
			for (int i = 0; i < n; i++) {

				Frame.getInstance().getDesk().getAllFrames()[i].setSize(
						fsirina, fvisina);

				Frame.getInstance().getDesk().getAllFrames()[i].setLocation(
						30 + (i * 30), 30 + (i * 30));
				try {
					Frame.getInstance().getDesk().getAllFrames()[i]
							.setSelected(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// System.out.println(Frame.getInstance().getDesk().getAllFrames()[i].getLocation());
			}

		}
	}
}