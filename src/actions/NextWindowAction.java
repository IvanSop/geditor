package actions;

import gui.Frame;
import gui.InternalFrame;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public class NextWindowAction extends AbstractAction {

	public NextWindowAction() {
		ClassLoader cl = this.getClass().getClassLoader();

		putValue(NAME, "Next Window");
		putValue(SMALL_ICON, new ImageIcon(cl.getResource("nextWindow.png")));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT,
				ActionEvent.SHIFT_MASK));
		putValue(ACTION_COMMAND_KEY, "Next Window");
		putValue(SHORT_DESCRIPTION, "Next Window");

	}

	public void actionPerformed(ActionEvent e) {
		//System.out.println("Action [" + e.getActionCommand() + "] performed!");

		ArrayList<InternalFrame> frames = Frame.getInstance()
				.getInternalframes();
		int n = frames.size();
		int x = -1;

	
		// trazenje selektovanog
		for (int i = 0; i < n; i++) {
			if (frames.get(i).isSelected()) {
				x = i;
				break;
			}
		}
		if (x != -1) { // sve ovo radim ako je nesto selektovano inace ne
			for (int j = x; j < n; j++) {
				if (!(j < n - 1)) {
					//System.out.println("lose sledeci ce biti "
							//+ String.valueOf(j + 1));
					break;

				} else {
					//System.out.println("dobro sledeci ce biti"
							//+ String.valueOf(j + 1) + " i bio je");
					if (!frames.get(j + 1).isClosed()) {
						try {
							frames.get(j + 1).setSelected(true);
						} catch (PropertyVetoException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						break;
					}
				}
			}
		}
	

	}

}