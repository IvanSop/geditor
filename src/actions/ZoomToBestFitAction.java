package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public class ZoomToBestFitAction extends AbstractAction {

	public ZoomToBestFitAction() {
        ClassLoader cl = this.getClass().getClassLoader();
		
		
		putValue(NAME, "Zoom To Best Fit");
		putValue(SMALL_ICON, new ImageIcon(cl.getResource("zoomToBestFit.png")));
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
        putValue(ACTION_COMMAND_KEY, "Zoom To Best Fit");
        putValue(SHORT_DESCRIPTION, "Zoom To Best Fit");
		
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("Action [" + e.getActionCommand() + "] performed!");
    }
}